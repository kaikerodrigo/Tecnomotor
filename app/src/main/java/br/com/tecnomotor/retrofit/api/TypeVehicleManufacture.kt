package br.com.tecnomotor.retrofit.api

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import br.com.tecnomotor.retrofit.BasicClient
import br.com.tecnomotor.retrofit.interfaceApi.TypeVehicleManufactureInterface
import br.com.tecnomotor.utils.Constant
import br.com.tecnomotor.utils.Constant.URL_INIT
import br.com.tecnomotor.utils.other.GlobalMethods
import br.com.tecnomotor.utils.recycler.adapter.StringFilterAdapterTypeVehicleManufacture
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TypeVehicleManufacture {
    val TAG: String = TypeVehicleManufacture::class.java.simpleName

    fun getTypeVehicleManufacture(
            listRecyclerView: RecyclerView,
            context: Context,
            textInputEditText: TextInputEditText
    ) {
        val spLastChoice: SharedPreferences = context.getSharedPreferences(Constant.SHARED_PREFERENCE_LAST_CHOICE, Context.MODE_PRIVATE)
        val globalMethods = GlobalMethods()

        val call = BasicClient<TypeVehicleManufactureInterface>(URL_INIT)
                .create(TypeVehicleManufactureInterface::class.java)
                .getTypeAutomobileManufacture()


        try {
            call.enqueue(object : Callback<ArrayList<String>> {
                override fun onFailure(call: Call<ArrayList<String>>, t: Throwable) {
                    Log.e(TAG, t.message, t)
                }

                override fun onResponse(
                        call: Call<ArrayList<String>>,
                        response: Response<ArrayList<String>>
                ) {
                    if (response.isSuccessful) {
                        val list = response.body()
                        if (!list.isNullOrEmpty()) {
                           val gson = Gson()
                            globalMethods.saveSharedPreferences(spLastChoice, Constant.TYPE_VEHICLE_MANUFACTURE,gson.toJson(list))
                            val stringFilterAdapterTypeVehicleManufacture =
                                    StringFilterAdapterTypeVehicleManufacture(
                                            list,
                                            context,
                                            textInputEditText
                                    )
                            listRecyclerView.adapter = stringFilterAdapterTypeVehicleManufacture
                        } else {
                            val stringFilterAdapterTypeVehicleManufacture =
                                    StringFilterAdapterTypeVehicleManufacture(
                                            ArrayList(),
                                            context,
                                            textInputEditText
                                    )
                            listRecyclerView.adapter = stringFilterAdapterTypeVehicleManufacture
                        }
                    }
                }


            })
        } catch (e: Exception) {
            Log.d(TAG, "getTypeAutomobileManufacture: $e")
        }
    }

}