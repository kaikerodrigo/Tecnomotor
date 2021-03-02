package br.com.tecnomotor.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jackson.JacksonConverterFactory

class BasicClient1<T>(urlServer: String) {
    private val retrofit = Retrofit
            .Builder()
            .baseUrl(urlServer)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun create(service: Class<T>): T {
        return retrofit.create(service)
    }
}