package com.alexc.testhw.extras

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout


@BindingAdapter("app:errorText")
fun TextInputLayout.setErrorMessage(errorMessage: Int?) {
    error = if (errorMessage != null) {
        context.getString(errorMessage)
    }else {
        null
    }
}