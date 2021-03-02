package br.com.tecnomotor.utils.recycler.adapter

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.tecnomotor.R
import br.com.tecnomotor.utils.Constant
import br.com.tecnomotor.utils.Constant.LAST_CHOICE_TYPE_VEHICLE_MANUFACTURE
import br.com.tecnomotor.utils.other.GlobalMethods
import com.google.android.material.textfield.TextInputEditText

class StringFilterAdapterTypeVehicleManufacture(
        private val filterList: ArrayList<String>,
        val context: Context,
        private val textInputEditText: TextInputEditText
) : RecyclerView.Adapter<StringFilterAdapterTypeVehicleManufacture.ViewHolder>() {
    private var lastCheckedPosition = -1
    private val spLastChoice: SharedPreferences = context.getSharedPreferences(Constant.SHARED_PREFERENCE_LAST_CHOICE, Context.MODE_PRIVATE)
    private val globalMethods = GlobalMethods()
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): StringFilterAdapterTypeVehicleManufacture.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_type_vehicle_manufacturer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
            holder: StringFilterAdapterTypeVehicleManufacture.ViewHolder,
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
                globalMethods.saveSharedPreferences(spLastChoice, LAST_CHOICE_TYPE_VEHICLE_MANUFACTURE, filterList[position])
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