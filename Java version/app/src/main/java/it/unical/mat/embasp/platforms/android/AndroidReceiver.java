package it.unical.mat.embasp.platforms.android;

import android.content.BroadcastReceiver;

import it.unical.mat.embasp.base.Service;


public abstract class AndroidReceiver extends BroadcastReceiver implements Service {
    private AndroidService service;

    public AndroidReceiver(AndroidService service) {
        this.service = service;
    }
}
