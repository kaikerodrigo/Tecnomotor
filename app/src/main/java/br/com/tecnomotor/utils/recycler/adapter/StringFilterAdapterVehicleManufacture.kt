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
import br.com.tecnomotor.model.Montadora
import br.com.tecnomotor.utils.Constant
import br.com.tecnomotor.utils.other.GlobalMethods
import com.google.android.material.textfield.TextInputEditText

class StringFilterAdapterVehicleManufacture(
        private val filterList: List<Montadora>,
        private val context: Context,
        private val textInputEditText: TextInputEditText
) : RecyclerView.Adapter<StringFilterAdapterVehicleManufacture.ViewHolder>() {
    private var lastCheckedPosition = -1
    private val spLastChoice: SharedPreferences = context.getSharedPreferences(Constant.SHARED_PREFERENCE_LAST_CHOICE, Context.MODE_PRIVATE)
    private val globalMethods = GlobalMethods()

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): StringFilterAdapterVehicleManufacture.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_vehicle_manufacturer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
            holder: StringFilterAdapterVehicleManufacture.ViewHolder,
            position: Int
    ) {
        holder.vehicleManufacturerName.text = filterList[position].nome
        holder.radioButton.isChecked = position == lastCheckedPosition
        holder.radioButton.setOnClickListener {
            if (position == lastCheckedPosition) {
                textInputEditText.setText(context.getString(R.string.vehicle_manufacturer_place_holder))
                holder.radioButton.isChecked = false
                lastCheckedPosition = -1
            } else {
                globalMethods.saveSharedPreferences(spLastChoice, Constant.LAST_CHOICE_VEHICLE_MANUFACTURE,filterList[position].nome)
                textInputEditText.setText(filterList[position].nome)
                lastCheckedPosition = position
                notifyDataSetChanged()
            }

        }


    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vehicleManufacturerName: TextView =
                view.findViewById<View>(R.id.txt_vehicle_manufacturer_recycler) as TextView
        var radioButton: RadioButton =
                view.findViewById<View>(R.id.radio_button_vehicle_manufacturer_recycler) as RadioButton
    }
}