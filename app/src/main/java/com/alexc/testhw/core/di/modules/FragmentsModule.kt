package com.alexc.testhw.core.di.modules

import com.alexc.testhw.calculator.CalculatorFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface FragmentsModule {

    @ContributesAndroidInjector
    fun contributeCalculatorFragment(): CalculatorFragment

}