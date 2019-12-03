package com.imastudio.kotlinketigaapp.network
import com.google.gson.GsonBuilder
 import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object InitRetrofit {

    val BASE_URL ="http://192.168.60.22/crudmahasiswa/"
    val BASE_URLBERITA ="https://newsapi.org/v2/"
    var MAPURL ="https://maps.googleapis.com/maps/api/place/"
    val BASE_URLMAPMASJID ="${MAPURL}nearbysearch/"
    val IMAGE_URL =MAPURL


    val interceptor = HttpLoggingInterceptor().
        setLevel(HttpLoggingInterceptor.Level.BODY)
    val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .retryOnConnectionFailure(true)
        .connectTimeout(15,TimeUnit.SECONDS)
        .build()
    val gson = GsonBuilder().setLenient().create()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getInstance() : RestApi = retrofit.create(RestApi::class.java)

  val retrofitPortalberita = Retrofit.Builder()
        .baseUrl(BASE_URLBERITA)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getInstancePortaberita() : RestApi = retrofitPortalberita.create(RestApi::class.java)

  val retrofitmapMasjid = Retrofit.Builder()
        .baseUrl(BASE_URLMAPMASJID)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    fun getInstanceMapMasjid() : RestApi = retrofitmapMasjid.create(RestApi::class.java)



}