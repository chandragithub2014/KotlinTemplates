package com.kotlintemplates.DInjection.View;

import android.app.Application;

import com.kotlintemplates.DInjection.View.DI.DaggerNetworkComponent;
import com.kotlintemplates.DInjection.View.DI.NetworkComponent;
import com.kotlintemplates.DInjection.View.DI.NetworkModule;
import com.kotlintemplates.DInjection.View.Repository.HelperURL;

public class CustomApplication extends Application {
    private NetworkComponent networkComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        networkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(HelperURL.BASE_URL))
                .build();
    }
    public NetworkComponent getNetworkComponent(){
        return networkComponent;

    }
}
