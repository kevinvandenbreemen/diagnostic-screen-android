package com.vandenbreemen.android.diagnostics.view

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.vandenbreemen.common.diagnostics.DiagnosticSection

@BindingAdapter("diagnosticSectionContent")
fun TextView.populateWithDiagnosticSectionContent(content: DiagnosticSection) {

    this.text = StringBuilder().apply {
        content.content.forEach { item->
            append(item).append("\n")
        }
    }.toString().trim()

}