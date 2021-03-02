package br.com.tecnomotor.retrofit.api

import android.content.Context
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import br.com.tecnomotor.dao.impl.MontadoraDaoImpl
import br.com.tecnomotor.retrofit.BasicClient
import br.com.tecnomotor.retrofit.interfaceApi.VehicleModelInterface
import br.com.tecnomotor.utils.Constant.URL_INIT
import br.com.tecnomotor.utils.recycler.adapter.StringFilterAdapterVehicle
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class VehicleModel {
    val TAG: String = VehicleModel::class.java.simpleName

    fun getVehicleModel(
            listRecyclerView: RecyclerView,
            context: Context,
            textInputEditText: TextInputEditText,
            pmVersion: String,
            pmType: String
    ) {
        val params: MutableMap<String, String> = HashMap()
        val montadoraDaoImpl = MontadoraDaoImpl(context)
        val montadora = montadoraDaoImpl.findByNome(pmVersion)!![0]
        params["pm.version"] = montadora.id!!.toString()
        params["pm.type"] = pmType
        params["pm.assemblers"] = "29"
        params["pm.pageIndex"] = "0"
        params["pm.pageSize"] = "10"

        val call = BasicClient<VehicleModelInterface>(URL_INIT)
                .create(VehicleModelInterface::class.java)
                .getVehicleModel(params)
        try {
            call.enqueue(object : Callback<JsonObject> {
                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    Log.e(TAG, t.message, t)
                }

                override fun onResponse(
                        call: Call<JsonObject>,
                        response: Response<JsonObject>
                ) {
                    if (response.isSuccessful) {
                        val jsonObject: JsonObject? = response.body()
                        val keys = jsonObject?.keySet()

                        var element: JsonElement? = null
                        keys!!.forEach {
                            element = Gson().fromJson(jsonObject.get(it), JsonElement::class.java)
                        }

                        if (element!!.asJsonArray!!.size() > 0) {
                            val stringFilterAdapterVehicle =
                                    StringFilterAdapterVehicle(
                                            element!!,
                                            context,
                                            textInputEditText
                                    )
                            listRecyclerView.adapter = stringFilterAdapterVehicle
                        } else {
                            val stringFilterAdapterVehicle =
                                    StringFilterAdapterVehicle(
                                            element!!,
                                            context,
                                            textInputEditText
                                    )
                            listRecyclerView.adapter = stringFilterAdapterVehicle
                        }
                    }
                }


            })
        } catch (e: Exception) {
            Log.d(TAG, "getTypeAutomobileManufacture: $e")
        }
    }

}