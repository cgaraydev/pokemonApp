package com.example.pokemonapp.dialog

import android.graphics.Paint
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pokemonapp.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Fragment.setUpBottomSheetDialog(
    onSendClick: (String) -> Unit
) {
    val dialog = BottomSheetDialog(requireContext(), R.style.DialogStyle)
    val view = layoutInflater.inflate(R.layout.reset_password_dialog, null)
    dialog.setContentView(view)
    dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
    dialog.show()

    val etEmail = view.findViewById<EditText>(R.id.etEmailForgotPassword)
    val btnSend = view.findViewById<Button>(R.id.btnSendEmail)
    val tvCancel = view.findViewById<TextView>(R.id.tvCancel)

    tvCancel.paintFlags = tvCancel.paintFlags or Paint.UNDERLINE_TEXT_FLAG

    btnSend.setOnClickListener {
        val email = etEmail.text.toString().trim()
        onSendClick(email)
        dialog.dismiss()
    }

    tvCancel.setOnClickListener {
        dialog.dismiss()
    }
}