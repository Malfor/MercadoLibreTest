package com.rodolfo.mercadolibre.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.rodolfo.mercadolibre.R

class AlertDialogFragment(var description: String) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.error)
            builder.setMessage(description)
                    .setPositiveButton(R.string.accept
                    ) { dialog, _ ->
                        dialog.dismiss()
                    }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}