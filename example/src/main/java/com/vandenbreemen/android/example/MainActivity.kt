package com.vandenbreemen.android.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vandenbreemen.android.diagnostics.view.DiagnosticFragment
import com.vandenbreemen.common.diagnostics.DiagnosticSection

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.content, DiagnosticFragment(
            com.vandenbreemen.common.diagnostics.DiagnosticsData.Builder(
                "Example Diagnostics"
            ).addSection(DiagnosticSection.Builder("Section 1")
                .addContent("The First System is Active")
                .addContent("The Second System is Down")
                .build()
            ).addSection(
                DiagnosticSection.Builder("Stembolts").addContent("Self-sealing 1223").addContent("Auto-sealing: 123123").addContent("Illegal: 12").build()
            )
                .build()
        )).commit()
    }
}