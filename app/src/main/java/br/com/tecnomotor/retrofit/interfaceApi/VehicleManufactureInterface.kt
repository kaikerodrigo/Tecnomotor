package br.com.tecnomotor.retrofit.interfaceApi

import br.com.tecnomotor.model.Montadora
import br.com.tecnomotor.utils.Constant.URL_VEHICLE_MANUFACTURE
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface VehicleManufactureInterface {
    @Headers("Content-Type: application/json")
    @GET(URL_VEHICLE_MANUFACTURE)
    fun getVehicleManufacture(@QueryMap params: Map<String, String>): Call<List<Montadora>>

}