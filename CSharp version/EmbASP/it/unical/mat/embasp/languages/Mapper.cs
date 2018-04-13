using System;
using System.Collections.Generic;
using System.Reflection;
using IllegalTermException = it.unical.mat.embasp.languages.asp.IllegalTermException;

namespace it.unical.mat.embasp.languages
{


	public abstract class Mapper
	{

		protected internal readonly IDictionary<string, Type> predicateClass = new Dictionary<string, Type>();

		protected internal readonly IDictionary<Type, IDictionary<string, MethodInfo>> classSetterMethod = new Dictionary<Type, IDictionary<string, MethodInfo>>();

		protected internal abstract string getActualString(string predicate, Dictionary<int, object> parametersMap);

		public virtual Type getClass(string predicate)
		{
      //Console.WriteLine("PREDICATE NAME {0}, value {1}", predicate, predicateClass[predicate]);
      if (predicateClass.ContainsKey(predicate))
        return predicateClass[predicate];
      return null;
		}

		public virtual object getObject(string @string)
		{
			string predicate = getPredicate(@string);

      //Console.WriteLine("Predicate {0}", predicate.ToString());
			if (string.ReferenceEquals(predicate, null))
			{
				return null;
			}
			
      Type cl = getClass(predicate);

			// Not exist mapping between the predicate and the class
			if (cl == null)
			{
				return null;
			}

			string[] parameters = getParameters(@string);

			if (parameters == null)
			{
				return null;
			}

			object obj = System.Activator.CreateInstance(cl);

			populateObject(cl, parameters, obj);

			return obj;

		}

		protected internal abstract string[] getParameters(string @string);

		protected internal abstract string getPredicate(string @string);

		public virtual string getString(object obj)
		{
			string predicate = registerClass(obj.GetType());

			Dictionary<int, object> parametersMap = new Dictionary<int, object>();
			foreach (FieldInfo field in obj.GetType().GetFields(BindingFlags.DeclaredOnly | BindingFlags.Public | BindingFlags.NonPublic | BindingFlags.Static | BindingFlags.Instance))
			{
        // TODO fix isSynthetic
        //if (field.isSynthetic)
        //{
        //	continue;
        //}
        if (Attribute.IsDefined(field, typeof(Param)))
				{
          //Console.WriteLine("Field Parameter {0}", obj.GetType());

          string nameMethod = "get" + char.ToUpper(field.Name[0]) + field.Name.Substring(1);
          //Console.WriteLine("nameMethod -> {0}", obj.GetType().GetMethod(nameMethod));
          object value = obj.GetType().GetMethod(nameMethod).Invoke(obj, new object[] { });
          //Console.WriteLine("Value -> {0}", value);

          //var attr = field.GetCustomAttributes(typeof(Id), false);
          //Param pAttr = attr[0] as Param;
          var attr = field.GetCustomAttribute(typeof(Param));
          Param pAttr = attr as Param;
          parametersMap[pAttr.value] = value;
				}
			}
			return getActualString(predicate, parametersMap);
		}

		private void populateObject(Type cl, string[] parameters, object obj)
		{
			foreach (FieldInfo field in cl.GetFields(BindingFlags.DeclaredOnly | BindingFlags.Public | BindingFlags.NonPublic | BindingFlags.Static | BindingFlags.Instance))
			{
				if (Attribute.IsDefined(field, typeof(Param)))
				{
          //var attr = field.GetCustomAttributes(typeof(Id), false);
          //Param pAttr = attr[0] as Param;
          var attr = field.GetCustomAttribute(typeof(Param));
          Param pAttr = attr as Param;
          int term = pAttr.value;
					string nameMethod = "set" + char.ToUpper(field.Name[0]) + field.Name.Substring(1);
          //Console.WriteLine("cl {0}, NameMethod {1}", cl, nameMethod);
					MethodBase method = classSetterMethod[cl][nameMethod];

          //Console.WriteLine("ParameterType {0}, intName {1}, intFullName {2}, equals {3}", method.GetParameters()[0].ParameterType, typeof(int).Name, typeof(int).FullName, method.GetParameters()[0].ParameterType.ToString().Equals(typeof(int).FullName));
          if (method.GetParameters()[0].ParameterType.ToString().Equals(typeof(int).FullName))
					{
            //Console.WriteLine("TERM {0} ", parameters[term]);
            method.Invoke(obj, new object[] { Convert.ToInt32(parameters[term])});
					}
					else
					{
            //Console.WriteLine("TERM {0} ", parameters[term]);
						method.Invoke(obj, new object[] { parameters[term]});
					}

				}
			}
		}
    
		public virtual string registerClass(Type cl)
		{
      //Attribute annotation = cl.GetCustomAttributes(typeof(Id), false)[0] as Id;
      Attribute annotation = cl.GetCustomAttribute(typeof(Id));

			if (annotation == null)
			{
				throw new IllegalAnnotationException();
			}

			string predicate = ((Id) annotation).value;

			if (predicate.Contains(" "))
			{
				throw new ObjectNotValidException();
			}

			// String predicate = cl.getAnnotation(Predicate.class).value();
			predicateClass[predicate] = cl;
			IDictionary<string, MethodInfo> namesMethods = new Dictionary<string, MethodInfo>();
			foreach (MethodInfo method in cl.GetMethods())
			{
				if (method.Name.StartsWith("set"))
				{
					namesMethods[method.Name] = method;
				}
			}
			classSetterMethod[cl] = namesMethods;
			return predicate;
		}
		
    public virtual void unregisterClass(Type cl)
		{
      // Attribute annotation = cl.GetCustomAttributes(typeof(Id), false)[0] as Id;
      Attribute annotation = cl.GetCustomAttribute(typeof(Id));

			if (annotation == null)
			{
				throw new IllegalAnnotationException();
			}

			string predicate = ((Id) annotation).value;

			predicateClass.Remove(predicate);
			classSetterMethod.Remove(cl);

		}

	}

}