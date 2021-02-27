package br.com.tecnomotor.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.tecnomotor.R
import br.com.tecnomotor.retrofit.api.TypeAutomobileManufacture
import com.google.android.material.textfield.TextInputEditText

class HomeFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val btnTypeAutomobileManufacturer = root.findViewById<Button>(R.id.btn_type_vehicle_manufacturer)
        val edtTypeAutomobileManufacturer = root.findViewById<TextInputEditText>(R.id.edt_type_vehicle_manufacturer)

        val layoutManager = LinearLayoutManager(root.context)
        val listRecyclerView: RecyclerView = root.findViewById(R.id.list_recycler_view_demonstration_information)

        listRecyclerView.layoutManager = layoutManager

        btnTypeAutomobileManufacturer.setOnClickListener {
            TypeAutomobileManufacture().getTypeAutomobileManufacture(
                listRecyclerView,
                root.context,
                edtTypeAutomobileManufacturer
            )
        }

        return root
    }
}