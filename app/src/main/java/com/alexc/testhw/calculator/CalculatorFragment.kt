package com.alexc.testhw.calculator


import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.alexc.testhw.R
import com.alexc.testhw.core.Initializer
import com.alexc.testhw.databinding.FragmentCalculatorBinding
import com.alexc.testhw.extras.hideKeyboard
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class CalculatorFragment : Fragment(), Initializer {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var calculatorViewModel: CalculatorViewModel

    private lateinit var binding: FragmentCalculatorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentCalculatorBinding>(
            inflater,
            R.layout.fragment_calculator,
            container,
            false)

        return binding.root
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
        initViews()
    }

    override fun references() {
        calculatorViewModel = ViewModelProviders.of(this, viewModelFactory)[CalculatorViewModel::class.java]
        binding.calculatorvm = calculatorViewModel
        binding.lifecycleOwner = this
    }

    override fun actions() {

        binding.aInputEditText.addTextChangedListener {
            calculatorViewModel.validateAInput(it?.toString())
        }

        binding.bInputEditText.addTextChangedListener {
            calculatorViewModel.validateBInput(it?.toString())
        }

    }

    private fun initViews(){
        binding.aInputEditText.hideKeyboard(activity?.applicationContext)
        binding.bInputEditText.hideKeyboard(activity?.applicationContext)
    }

}
