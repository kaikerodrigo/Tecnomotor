package br.com.tecnomotor.utils.recycler.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import br.com.tecnomotor.R
import br.com.tecnomotor.utils.Constant
import br.com.tecnomotor.utils.other.GlobalMethods
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import org.json.JSONArray
import org.json.JSONObject
import java.util.stream.Collectors
import java.util.stream.IntStream


class StringFilterAdapterVehicle(
    private val element: JsonElement,
    private val context: Context,
    private val textInputEditText: TextInputEditText
) : RecyclerView.Adapter<StringFilterAdapterVehicle.ViewHolder>() {
    private var lastCheckedPosition = -1
    private val spLastChoice: SharedPreferences = context.getSharedPreferences(Constant.SHARED_PREFERENCE_LAST_CHOICE, Context.MODE_PRIVATE)
    private val globalMethods = GlobalMethods()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StringFilterAdapterVehicle.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_vehicle, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: StringFilterAdapterVehicle.ViewHolder,
        position: Int
    ) {
        val jsonArray = element.asJsonArray
        holder.vehicleModel.text = getValuesForGivenKey(jsonArray.toString(), "veiculoMotorizacao")!![position]

        holder.radioButton.isChecked = position == lastCheckedPosition
        holder.radioButton.setOnClickListener {
            if (position == lastCheckedPosition) {
                textInputEditText.setText(context.getString(R.string.vehicle_manufacturer_place_holder))
                holder.radioButton.isChecked = false
                lastCheckedPosition = -1
            } else {
                globalMethods.saveSharedPreferences(spLastChoice, Constant.LAST_CHOICE_VEHICLE, getValuesForGivenKey(jsonArray.toString(),"veiculoMotorizacao")!![position])

                textInputEditText.setText(
                    getValuesForGivenKey(
                        jsonArray.toString(),
                        "veiculoMotorizacao"
                    )!![position]
                )
                lastCheckedPosition = position
                notifyDataSetChanged()
            }

        }


    }

    override fun getItemCount(): Int {
        val jsonArray: JsonArray = element.asJsonArray
        return jsonArray.size()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vehicleModel: TextView =
                view.findViewById<View>(R.id.txt_vehicle_recycler_1) as TextView
        var radioButton: RadioButton =
                view.findViewById<View>(R.id.radio_button_vehicle_recycler) as RadioButton
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun getValuesForGivenKey(jsonArrayStr: String?, key: String?): List<String?>? {
        val jsonArray = JSONArray(jsonArrayStr)
        return IntStream.range(0, jsonArray.length())
                .mapToObj { index -> (jsonArray[index] as JSONObject).optString(key) }
                .collect(Collectors.toList())
    }
}