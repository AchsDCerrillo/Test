package com.alexc.testhw.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexc.testhw.R
import java.lang.Double.parseDouble
import java.math.BigDecimal
import javax.inject.Inject

class CalculatorViewModel @Inject constructor():ViewModel() {

    private var aInput: BigDecimal? = null
    private var bInput: BigDecimal? = null

    val validInputs: MutableLiveData<Boolean> = MutableLiveData()

    val aInputError: MutableLiveData<Int?> = MutableLiveData()
    val bInputError: MutableLiveData<Int?> = MutableLiveData()
    val result: MutableLiveData<String> = MutableLiveData()

    init {
        validInputs.postValue(false)
        aInputError.postValue(null)
        bInputError.postValue(null)
        result.postValue("")
    }

    fun validateAInput(aInputFragment: String?) {
        result.postValue("")

        if (!aInputFragment.isNullOrEmpty()) {

            try {
                val numA = parseDouble(aInputFragment)

                aInput = numA.toBigDecimal()

                val enableButton = aInput != null && bInput != null

                validInputs.postValue(enableButton)

                aInputError.postValue(null)

            } catch (e: NumberFormatException) {

                validInputs.postValue(false)

                aInputError.postValue(R.string.invalid_number_error)

            }

        }else {
            validInputs.postValue(false)
            aInputError.postValue(R.string.empty_input_error)
        }
    }

    fun validateBInput(bInputFragment: String?) {
        result.postValue("")

        if (!bInputFragment.isNullOrEmpty()) {

            try {
                val numB = parseDouble(bInputFragment)

                bInput = numB.toBigDecimal()

                val enableButton = aInput != null && bInput != null

                validInputs.postValue(enableButton)

                bInputError.postValue(null)

            } catch (e: NumberFormatException) {

                validInputs.postValue(false)

                bInputError.postValue(R.string.invalid_number_error)

            }

        }else {
            validInputs.postValue(false)
            bInputError.postValue(R.string.empty_input_error)
        }
    }

    fun calculate() {
        result.postValue(aInput!!.plus(bInput!!).toPlainString())
    }

}