package br.com.tecnomotor.retrofit

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class BasicClient<T>(urlServer: String) {
    private val retrofit = Retrofit
        .Builder()
        .baseUrl(urlServer)
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    fun create(service: Class<T>): T {
        return retrofit.create(service)
    }
}