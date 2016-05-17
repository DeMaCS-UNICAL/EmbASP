package it.unical.mat.embasp.platforms.android;

import android.app.IntentService;

public abstract class AndroidService extends IntentService implements it.unical.mat.embasp.base.Service{
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public AndroidService(String name) {
        super(name);
    }

}
