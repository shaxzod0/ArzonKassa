package uz.dastyor.arzonkassa

import retrofit2.Call
import retrofit2.http.GET

interface Apiinterface {
    @GET("posts")
    fun getData(): Call<List<MyDataItem>>
}