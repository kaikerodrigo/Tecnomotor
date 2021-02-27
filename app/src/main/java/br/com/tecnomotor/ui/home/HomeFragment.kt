package br.com.tecnomotor.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.tecnomotor.R
import br.com.tecnomotor.retrofit.api.TypeVehicleManufacture
import br.com.tecnomotor.retrofit.api.VehicleManufacture
import com.google.android.material.textfield.TextInputEditText

class HomeFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val btnTypeVehicleManufacturer = root.findViewById<Button>(R.id.btn_type_vehicle_manufacturer)
        val edtTypeVehicleManufacturer = root.findViewById<TextInputEditText>(R.id.edt_type_vehicle_manufacturer)

        val btnVehicleManufacturer = root.findViewById<Button>(R.id.btn_vehicle_manufacturer)
        val edtVehicleManufacturer = root.findViewById<TextInputEditText>(R.id.edt_vehicle_manufacturer)
        
        val layoutManager = LinearLayoutManager(root.context)
        val listRecyclerView: RecyclerView = root.findViewById(R.id.list_recycler_view_demonstration_information)

        listRecyclerView.layoutManager = layoutManager

        btnTypeVehicleManufacturer.setOnClickListener {
            TypeVehicleManufacture().getTypeVehicleManufacture(
                listRecyclerView,
                root.context,
                edtTypeVehicleManufacturer
            )
        }


        btnVehicleManufacturer.setOnClickListener {
            VehicleManufacture().getVehicleManufacture(
                listRecyclerView,
                root.context,
                edtVehicleManufacturer,
                edtTypeVehicleManufacturer.text.toString()
            )
        }

        return root
    }
}