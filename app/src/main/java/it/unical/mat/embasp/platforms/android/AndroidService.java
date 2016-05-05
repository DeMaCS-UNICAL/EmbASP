package it.unical.mat.embasp.platforms.android;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;


public abstract class AndroidService extends Service implements it.unical.mat.embasp.base.Service{

    protected IBinder binder;


    /*Returns the current Service class , can be used to interact directly with the Service*/
    public class AndroidBinder extends Binder {
        public AndroidService getService(){
            return AndroidService.this;
        }
    }

    /*used when an activity calls onBind function*/
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return binder;
    }


}
