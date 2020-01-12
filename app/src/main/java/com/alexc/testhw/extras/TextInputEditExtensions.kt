package com.alexc.testhw.extras

import android.content.Context
import android.view.inputmethod.InputMethodManager
import com.google.android.material.textfield.TextInputEditText

fun TextInputEditText.hideKeyboard(context: Context?){
    val imm = context?.getSystemService(android.app.Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
    this.clearFocus()
}