package com.example.sharedpreferences.bottomsheet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferences.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_bottom_sheet_dialog.*
import kotlinx.android.synthetic.main.layout_bottom_sheet.view.*

class BottomSheet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet_dialog)

        btnShowBottomSheet.setOnClickListener {
            // clickOpenBottomSheet()
            openBottomSheet()
//            val viewDialog: View = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
//            val newBottomSheetDialog = BottomSheetDialog(this)
//            newBottomSheetDialog.setContentView(viewDialog)
//            newBottomSheetDialog.show()
//            newBottomSheetDialog.setCancelable(false)
//            btnCancel?.setOnClickListener {
//                newBottomSheetDialog.setCancelable(true)
//            }
        }
    }

    private fun openBottomSheet() {
        val viewDialog = layoutInflater.inflate(R.layout.layout_bottom_sheet, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(viewDialog)
        bottomSheetDialog.show()
        bottomSheetDialog.setCancelable(false)

        viewDialog.btnCancel?.setOnClickListener {
            bottomSheetDialog?.dismiss()
        }
    }
}
