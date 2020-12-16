package com.example.retrofitapp

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiInterfaceOne {

    @GET("users")
    fun getUsers() : Call<List<MyDataClass>>

}
class RetrofitClient {
    companion object{
        val myRetrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
                       .build()
            .create(ApiInterfaceOne::class.java)


    }
}