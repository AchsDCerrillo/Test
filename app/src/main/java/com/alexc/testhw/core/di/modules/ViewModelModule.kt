package com.alexc.testhw.core.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexc.testhw.calculator.CalculatorViewModel
import com.alexc.testhw.core.di.viewmodel.ViewModelFactory
import com.alexc.testhw.core.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CalculatorViewModel::class)
    internal abstract fun bindCalculatorViewModel(viewModel: CalculatorViewModel): ViewModel

}