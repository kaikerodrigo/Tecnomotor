package br.com.tecnomotor.retrofit.interfaceApi

import br.com.tecnomotor.utils.Constant.URL_VEHICLE_MODEL
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface VehicleModelInterface {
    @Headers("Content-Type: application/json")
    @GET(URL_VEHICLE_MODEL)
    fun getVehicleModel(@QueryMap params: Map<String, String>): Call<JsonObject>

}