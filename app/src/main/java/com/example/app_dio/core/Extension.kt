package com.example.app_dio.core

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout


var TextInputLayout.text: String
get() = editText?.text?.toString() ?: ""
set(value) {

    editText?.setText(value)

}
fun View.hideSoftKeyboard(){

    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken,0)

}

fun Context.createDialog(block: MaterialAlertDialogBuilder.()-> Unit = {}): androidx.appcompat.app.AlertDialog {
    val builder = MaterialAlertDialogBuilder(this)
    builder.setPositiveButton(android.R.string.ok, null)
    block(builder)
    return  builder.create()

}

fun Context.createProgressDialog(): androidx.appcompat.app.AlertDialog {
    return  createDialog {
        val padding = 16
         val progressBar = ProgressBar(this@createProgressDialog)
        progressBar.setPadding(padding,padding,padding,padding)
        setView(progressBar)

        setPositiveButton(null,null)
        setCancelable(false)
    }


}