package br.com.tecnomotor.utils.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.tecnomotor.R
import com.google.android.material.textfield.TextInputEditText

class StringFilterAdapterVehicleManufacture(
    private val filterList: ArrayList<String>,
    val context: Context,
    private val textInputEditText: TextInputEditText
) : RecyclerView.Adapter<StringFilterAdapterVehicleManufacture.ViewHolder>() {
    private var lastCheckedPosition = -1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StringFilterAdapterVehicleManufacture.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_type_vehicle_manufacturer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: StringFilterAdapterVehicleManufacture.ViewHolder,
        position: Int
    ) {
        holder.typeAutomobileManufacturer.text = filterList[position]
        holder.radioButton.isChecked = position == lastCheckedPosition
        holder.radioButton.setOnClickListener {
            if (position == lastCheckedPosition) {
                textInputEditText.setText(context.getString(R.string.type_vehicle_manufacturer_place_holder))
                holder.radioButton.isChecked = false
                lastCheckedPosition = -1
            } else {
                textInputEditText.setText(filterList[position])
                lastCheckedPosition = position
                notifyDataSetChanged()
            }

        }


    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val typeAutomobileManufacturer: TextView =
            view.findViewById<View>(R.id.txt_type_vehicle_manufacturer) as TextView
        var radioButton: RadioButton =
            view.findViewById<View>(R.id.radio_button_type_vehicle_manufacturer_recycler) as RadioButton
    }
}