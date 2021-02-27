package br.com.tecnomotor.retrofit.api

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import br.com.tecnomotor.model.Montadora
import br.com.tecnomotor.retrofit.BasicClient
import br.com.tecnomotor.retrofit.interfaceApi.VehicleManufactureInterface
import br.com.tecnomotor.utils.Constant.URL_INIT
import br.com.tecnomotor.utils.recycler.adapter.StringFilterAdapterTypeVehicleManufacture
import br.com.tecnomotor.utils.recycler.adapter.StringFilterAdapterVehicleManufacture
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class VehicleManufacture {
    val TAG: String = VehicleManufacture::class.java.simpleName

    fun getVehicleManufacture(
        listRecyclerView: RecyclerView,
        context: Context,
        textInputEditText: TextInputEditText,
        pmType: String
    ) {
        val params: MutableMap<String, String> = HashMap()
        params["pm.type"] = pmType

        val call = BasicClient<VehicleManufactureInterface>(URL_INIT)
            .create(VehicleManufactureInterface::class.java)
            .getVehicleManufacture(params)
        try {
            call.enqueue(object : Callback<List<Montadora>> {
                override fun onFailure(call: Call<List<Montadora>>, t: Throwable) {
                    Log.e(TAG, t.message, t)
                }

                override fun onResponse(
                    call: Call<List<Montadora>>,
                    response: Response<List<Montadora>>
                ) {
                    if (response.isSuccessful) {
                        val list = response.body()
                        if (!list.isNullOrEmpty()) {

                            val stringFilterAdapterVehicleManufacture =
                                StringFilterAdapterVehicleManufacture(
                                    list,
                                    context,
                                    textInputEditText
                                )
                            listRecyclerView.adapter = stringFilterAdapterVehicleManufacture
                        } else {
                            val stringFilterAdapterVehicleManufacture =
                                StringFilterAdapterVehicleManufacture(
                                    ArrayList(),
                                    context,
                                    textInputEditText
                                )
                            listRecyclerView.adapter = stringFilterAdapterVehicleManufacture
                        }
                    }
                }


            })
        } catch (e: Exception) {
            Log.d(TAG, "getTypeAutomobileManufacture: $e")
        }
    }

}