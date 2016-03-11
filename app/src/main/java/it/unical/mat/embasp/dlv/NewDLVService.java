package it.unical.mat.embasp.dlv;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by haze on 3/11/16.
 */
public class NewDLVService extends Service {

    private IBinder binder = new DLVBinder();

    public class DLVBinder extends Binder{
        NewDLVService getService(){
            return new NewDLVService();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


}
