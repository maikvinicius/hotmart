package com.pesquiseme.hotmart.presentation

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import com.pesquiseme.hotmart.R


object Utils {
    fun showError(message: String?, context: Context){
        val alertDialog: AlertDialog = AlertDialog.Builder(context).create()
        alertDialog.setTitle(context.getString(R.string.alert_title_error))
        alertDialog.setMessage(message)
        alertDialog.setButton(Dialog.BUTTON_POSITIVE, context.getString(R.string.alert_button_error), { dialog, which -> alertDialog.cancel() })
        alertDialog.show()
    }
}