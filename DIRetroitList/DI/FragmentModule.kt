package com.kotlintemplates.DIRetroitList.DI

import com.kotlintemplates.DIRetroitList.View.RetroDIFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    internal abstract fun contributeRetroDIFragment(): RetroDIFragment
}