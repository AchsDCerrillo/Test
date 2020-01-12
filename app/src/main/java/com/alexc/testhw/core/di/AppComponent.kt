package com.alexc.testhw.core.di

import com.alexc.testhw.core.CoreApplication
import com.alexc.testhw.core.di.modules.ActivitiesModule
import com.alexc.testhw.core.di.modules.FragmentsModule
import com.alexc.testhw.core.di.modules.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivitiesModule::class,
    FragmentsModule::class,
    ViewModelModule::class
])
interface AppComponent: AndroidInjector<CoreApplication>