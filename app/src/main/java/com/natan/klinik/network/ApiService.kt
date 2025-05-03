package com.natan.klinik.network

import com.natan.klinik.model.ApiResponse
import com.natan.klinik.model.CheckoutRequest
import com.natan.klinik.model.Clinic
import com.natan.klinik.model.DoctorItem
import com.natan.klinik.model.Guide
import com.natan.klinik.model.OrderResponse
import com.natan.klinik.model.ProductItem
import com.natan.klinik.model.Profile
import okhttp3.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @FormUrlEncoded
    @POST("customer/sign-in") // Sesuaikan dengan endpoint API kamu
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Profile>

    @FormUrlEncoded
    @POST("customer/sign-up") // Sesuaikan dengan endpoint API kamu
    fun register(
        @Field("email") email: String,
        @Field("name") name: String,
        @Field("phone") phone: String,
        @Field("password") password: String
    ): Call<Profile>

    @GET("product") // Sesuaikan dengan endpoint API kamu
    fun getProduct(
    ): Call<List<ProductItem>>

    @GET("clinic") // Sesuaikan dengan endpoint API kamu
    fun getClinic(
    ): Call <Clinic>

    @GET("doctors") // Sesuaikan dengan endpoint API kamu
    fun getDoctor(
    ): Call<List<DoctorItem>>

    @GET("dog-care-guides") // Sesuaikan dengan endpoint API kamu
    fun getGuide(
    ): Call<List<Guide>>

    @POST("checkout")
    fun checkout(@Body request: CheckoutRequest): Call<ApiResponse>

    @GET("orders/{user_id}")
    fun getOrderHistory(
        @Path("user_id") userId: Int
    ): Call<OrderResponse>
}
