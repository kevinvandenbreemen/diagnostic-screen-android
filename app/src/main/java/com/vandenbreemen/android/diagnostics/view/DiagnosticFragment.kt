package com.vandenbreemen.android.diagnostics.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.vandenbreemen.android.diagnostics.BR
import com.vandenbreemen.android.diagnostics.R
import com.vandenbreemen.android.diagnostics.databinding.FragmentDiagnosticScreenBinding
import com.vandenbreemen.android.diagnostics.databinding.LayoutDiagnosticSectionBinding
import com.vandenbreemen.common.diagnostics.DiagnosticsData

class DiagnosticSectionViewHolder(viewGroup: ViewGroup, val binding: LayoutDiagnosticSectionBinding): RecyclerView.ViewHolder(viewGroup)  {

}

class DiagnosticSectionAdapter(private val diagnosticsData: DiagnosticsData): RecyclerView.Adapter<DiagnosticSectionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiagnosticSectionViewHolder {

        return with(LayoutDiagnosticSectionBinding.inflate(LayoutInflater.from(parent.context))) {
            DiagnosticSectionViewHolder(
                root as ViewGroup,
                this
            )
        }

    }

    override fun onBindViewHolder(holder: DiagnosticSectionViewHolder, position: Int) {
        with(diagnosticsData.sections[position]) {
            holder.binding.setVariable(BR.section, this)
        }

    }

    override fun getItemCount(): Int {
        return diagnosticsData.sections.size
    }

}

/**
 * Display diagnostic info
 */
class DiagnosticFragment(private val diagnosticsData: DiagnosticsData): Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return with(FragmentDiagnosticScreenBinding.inflate(inflater, container, false)) {
            this.model = diagnosticsData

            this.root.findViewById<RecyclerView>(R.id.diagnostic_readings).run {
                adapter = DiagnosticSectionAdapter(diagnosticsData)
            }

            return this.root
        }
    }

}