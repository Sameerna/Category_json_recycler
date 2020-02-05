package com.example.recycler_json_task

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val  BASE_URL ="https://pascolan-config.s3.us-east-2.amazonaws.com/android/v1/prod/Category/hi/category.json"
interface jchoiceApi {
    @GET ("category")
     fun getCategory(): Call<List<Categorry> >

    companion object {
         operator fun invoke():jchoiceApi{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(jchoiceApi::class.java)
         }
    }
}