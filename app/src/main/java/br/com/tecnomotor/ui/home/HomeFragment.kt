package br.com.tecnomotor.ui.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.tecnomotor.R
import br.com.tecnomotor.dao.impl.TipoSistemaDaoImpl
import br.com.tecnomotor.retrofit.api.TypeVehicleManufacture
import br.com.tecnomotor.retrofit.api.VehicleManufacture
import br.com.tecnomotor.retrofit.api.VehicleModel
import br.com.tecnomotor.utils.Constant
import br.com.tecnomotor.utils.Constant.LAST_CHOICE_TYPE_VEHICLE_MANUFACTURE
import br.com.tecnomotor.utils.Constant.LAST_CHOICE_VEHICLE
import br.com.tecnomotor.utils.Constant.LAST_CHOICE_VEHICLE_MANUFACTURE
import br.com.tecnomotor.utils.other.GlobalMethods
import br.com.tecnomotor.utils.recycler.adapter.StringFilterAdapterTypeVehicleManufacture
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val txtViewTitleDemonstrationInformation =
            root.findViewById<TextView>(R.id.txt_view_title_demonstration_information)

        val btnTypeVehicleManufacturer =
            root.findViewById<Button>(R.id.btn_type_vehicle_manufacturer)
        val edtTypeVehicleManufacturer =
            root.findViewById<TextInputEditText>(R.id.edt_type_vehicle_manufacturer)

        val btnVehicleManufacturer = root.findViewById<Button>(R.id.btn_vehicle_manufacturer)
        val edtVehicleManufacturer =
            root.findViewById<TextInputEditText>(R.id.edt_vehicle_manufacturer)

        val btnVehicle = root.findViewById<Button>(R.id.btn_vehicle)
        val edtVehicle = root.findViewById<TextInputEditText>(R.id.edt_vehicle)

        val layoutManager = LinearLayoutManager(root.context)
        val listRecyclerView: RecyclerView =
            root.findViewById(R.id.list_recycler_view_demonstration_information)

        val spLastChoice: SharedPreferences = root.context.getSharedPreferences(
            Constant.SHARED_PREFERENCE_LAST_CHOICE,
            Context.MODE_PRIVATE
        )
        val globalMethods = GlobalMethods()

        if (!globalMethods.recoverSharedPreferences(
                spLastChoice,
                LAST_CHOICE_TYPE_VEHICLE_MANUFACTURE
            ).isNullOrEmpty()
            && !globalMethods.recoverSharedPreferences(
                spLastChoice,
                LAST_CHOICE_TYPE_VEHICLE_MANUFACTURE
            ).isNullOrBlank()
        ) {
            edtTypeVehicleManufacturer.setText(
                globalMethods.recoverSharedPreferences(
                    spLastChoice,
                    LAST_CHOICE_TYPE_VEHICLE_MANUFACTURE
                )
            )
        }

        if (!globalMethods.recoverSharedPreferences(spLastChoice, LAST_CHOICE_VEHICLE_MANUFACTURE)
                .isNullOrEmpty()
            && !globalMethods.recoverSharedPreferences(
                spLastChoice,
                LAST_CHOICE_VEHICLE_MANUFACTURE
            ).isNullOrBlank()
        ) {
            edtVehicleManufacturer.setText(
                globalMethods.recoverSharedPreferences(
                    spLastChoice,
                    LAST_CHOICE_VEHICLE_MANUFACTURE
                )
            )
        }

        if (!globalMethods.recoverSharedPreferences(spLastChoice, LAST_CHOICE_VEHICLE)
                .isNullOrEmpty()
            && !globalMethods.recoverSharedPreferences(spLastChoice, LAST_CHOICE_VEHICLE)
                .isNullOrBlank()
        ) {
            edtVehicle.setText(
                globalMethods.recoverSharedPreferences(
                    spLastChoice,
                    LAST_CHOICE_VEHICLE
                )
            )
        }

        listRecyclerView.layoutManager = layoutManager

        btnTypeVehicleManufacturer.setOnClickListener {
            txtViewTitleDemonstrationInformation.text =
                root.context.getString(R.string.type_vehicle_manufacturer_place_holder)
            edtTypeVehicleManufacturer.setText(root.context.getString(R.string.type_vehicle_manufacturer_place_holder))
            edtVehicleManufacturer.setText(root.context.getString(R.string.vehicle_manufacturer_place_holder))

            if (globalMethods.isNetworkConnected(root.context)) {
                TypeVehicleManufacture().getTypeVehicleManufacture(
                    listRecyclerView,
                    root.context,
                    edtTypeVehicleManufacturer
                )
            } else {
                val typeVehicleModelDao = TipoSistemaDaoImpl(root.context)
                val listVehicleModel = typeVehicleModelDao.all
                if (!listVehicleModel.isNullOrEmpty()) {
                    val listSrt: MutableList<String> = ArrayList()

                    listVehicleModel.forEach {
                        listSrt.add(it.nome!!)
                    }

                    val stringFilterAdapterTypeVehicleManufacture =
                        StringFilterAdapterTypeVehicleManufacture(
                            listSrt as ArrayList<String>,
                            root.context,
                            edtTypeVehicleManufacturer
                        )
                    listRecyclerView.adapter = stringFilterAdapterTypeVehicleManufacture
                } else if (!globalMethods.recoverSharedPreferences(
                        spLastChoice,
                        Constant.TYPE_VEHICLE_MANUFACTURE
                    ).isNullOrBlank()
                    && !globalMethods.recoverSharedPreferences(
                        spLastChoice,
                        Constant.TYPE_VEHICLE_MANUFACTURE
                    ).isNullOrEmpty()
                ) {
                    val gson = Gson()
                    val type: Type = object : TypeToken<ArrayList<String?>?>() {}.type
                    val stringFilterAdapterTypeVehicleManufacture =
                        StringFilterAdapterTypeVehicleManufacture(
                            gson.fromJson(
                                globalMethods.recoverSharedPreferences(
                                    spLastChoice,
                                    Constant.TYPE_VEHICLE_MANUFACTURE
                                ), type
                            ) as ArrayList<String>,
                            root.context,
                            edtTypeVehicleManufacturer
                        )
                    listRecyclerView.adapter = stringFilterAdapterTypeVehicleManufacture

                } else {
                    val stringFilterAdapterTypeVehicleManufacture =
                        StringFilterAdapterTypeVehicleManufacture(
                            ArrayList(),
                            root.context,
                            edtTypeVehicleManufacturer
                        )
                    listRecyclerView.adapter = stringFilterAdapterTypeVehicleManufacture
                }
            }


        }


        btnVehicleManufacturer.setOnClickListener {
            txtViewTitleDemonstrationInformation.text =
                root.context.getString(R.string.vehicle_manufacturer_place_holder)
            edtVehicleManufacturer.setText(root.context.getString(R.string.vehicle_manufacturer_place_holder))
            edtVehicle.setText(root.context.getString(R.string.vehicle_place_holder))

            VehicleManufacture().getVehicleManufacture(
                listRecyclerView,
                root.context,
                edtVehicleManufacturer,
                edtTypeVehicleManufacturer.text.toString()
            )
        }

        btnVehicle.setOnClickListener {
            txtViewTitleDemonstrationInformation.text =
                root.context.getString(R.string.vehicle_manufacturer_place_holder)
            edtVehicle.setText(root.context.getString(R.string.vehicle_place_holder))

            VehicleModel().getVehicleModel(
                listRecyclerView,
                root.context,
                edtVehicle,
                edtVehicleManufacturer.text.toString(),
                edtTypeVehicleManufacturer.text.toString()
            )
        }

        return root
    }
}