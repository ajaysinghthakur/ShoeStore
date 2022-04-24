package com.udacity.shoestore.extension

import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import com.udacity.shoestore.R
import timber.log.Timber

fun EditText.validateString() : Boolean {
    var noErrors = true
    val textString = this.text.toString()
    Timber.i(textString)
    if (textString.isEmpty()) {
        this.error = resources.getString(R.string.error_string)
        noErrors = false
    } else {
        this.error = null

    }

    return noErrors
}

fun EditText.validateDouble() : Boolean {
    var noErrors = true
    if (this.validateString()) {
        val double = this.text.toString().toDoubleOrNull()
        if (double == null) {
            this.error = resources.getString(R.string.size_error_string)
            noErrors = false
        } else if (double == 0.0){
            this.error = resources.getString(R.string.size_error_string)
            noErrors = false
        } else {
            noErrors = true
        }
    }
    return noErrors
}