using EmbASP.it.unical.mat.embasp.languages.asp;
using System;
using System.Collections.Generic;
using System.Reflection;

namespace it.unical.mat.embasp.languages
{
    public abstract class Mapper
    {
        protected internal readonly IDictionary<string, Type> predicateClass = new Dictionary<string, Type>();
        protected internal readonly IDictionary<Type, IDictionary<string, MethodInfo>> classSetterMethod = new Dictionary<Type, IDictionary<string, MethodInfo>>();

        protected internal abstract string GetActualString(string predicate, Dictionary<int, object> parametersMap);

        public virtual Type GetClass(string predicate)
        {
            if (predicateClass.ContainsKey(predicate))
                return predicateClass[predicate];
            return null;
        }

        public virtual object GetObject(string @string)
        {
            string predicate = GetId(@string);
            if (predicate is null)
                return null;

            // Not exist mapping between the predicate and the class
            Type cl = GetClass(predicate);
            if (cl == null)
                return null;

            string[] parameters = GetParam(@string);
            if (parameters == null)
                return null;

            object obj = System.Activator.CreateInstance(cl);
            PopulateObject(cl, parameters, obj);
            return obj;
        }

        protected internal abstract string GetId(string @string);

        protected internal abstract string[] GetParam(string @string);

        public virtual string GetString(object obj)
        {
            string predicate = RegisterClass(obj.GetType());

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
                    string nameMethod = "get" + char.ToUpper(field.Name[0]) + field.Name.Substring(1);
                    object value = obj.GetType().GetMethod(nameMethod).Invoke(obj, new object[] { });

                    var attr = field.GetCustomAttribute(typeof(Param));
                    Param pAttr = attr as Param;
                    parametersMap[pAttr.value] = value;
                }
            }
            return GetActualString(predicate, parametersMap);
        }

        private void PopulateObject(Type cl, string[] parameters, object obj)
        {
            foreach (FieldInfo field in cl.GetFields(BindingFlags.DeclaredOnly | BindingFlags.Public | BindingFlags.NonPublic | BindingFlags.Static | BindingFlags.Instance))
            {
                if (Attribute.IsDefined(field, typeof(Param)))
                {
                    var attr = field.GetCustomAttribute(typeof(Param));
                    Param pAttr = attr as Param;
                    int term = pAttr.value;
                    string nameMethod = "set" + char.ToUpper(field.Name[0]) + field.Name.Substring(1);
                    MethodBase method = classSetterMethod[cl][nameMethod];

                    if (method.GetParameters()[0].ParameterType.ToString().Equals(typeof(int).FullName))
                        method.Invoke(obj, new object[] { Convert.ToInt32(parameters[term]) });
                    else if (method.GetParameters()[0].ParameterType.ToString().Equals(typeof(SymbolicConstant).FullName))
                        method.Invoke(obj, new object[] { new SymbolicConstant(parameters[term]) });
                    else
                        method.Invoke(obj, new object[] { parameters[term] });
                }
            }
        }

        public virtual string RegisterClass(Type cl)
        {
            Attribute annotation = cl.GetCustomAttribute(typeof(Id));
            if (annotation == null)
                throw new IllegalAnnotationException();

            string predicate = ((Id)annotation).value;
            if (predicate.Contains(" "))
                throw new ObjectNotValidException();

            predicateClass[predicate] = cl;
            IDictionary<string, MethodInfo> namesMethods = new Dictionary<string, MethodInfo>();
            foreach (MethodInfo method in cl.GetMethods())
                if (method.Name.StartsWith("set"))
                    namesMethods[method.Name] = method;
            classSetterMethod[cl] = namesMethods;
            return predicate;
        }

        public virtual void UnregisterClass(Type cl)
        {
            Attribute annotation = cl.GetCustomAttribute(typeof(Id));
            if (annotation == null)
                throw new IllegalAnnotationException();

            string predicate = ((Id)annotation).value;
            predicateClass.Remove(predicate);
            classSetterMethod.Remove(cl);
        }
    }
}