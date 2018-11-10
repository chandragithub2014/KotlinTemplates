package com.kotlintemplates.DInjection.View.DI;

import com.kotlintemplates.DInjection.View.View.DIActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {
    public void inject(DIActivity activity);
}
