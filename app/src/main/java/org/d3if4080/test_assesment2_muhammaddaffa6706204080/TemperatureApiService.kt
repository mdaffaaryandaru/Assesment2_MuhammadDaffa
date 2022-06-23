package org.d3if4080.test_assesment2_muhammaddaffa6706204080

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if4080.test_assesment2_muhammaddaffa6706204080.data.Temperature
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/mdaffaaryandaru/Assesment2_MuhammadDaffa/master/app/src/main/java/org/d3if4080/test_assesment2_muhammaddaffa6706204080/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


    interface TemperatureApiService {
    @GET("data.json")
    suspend fun getTemperature() : List <Temperature>
}

object TemperatureApi{
    val service : TemperatureApiService by lazy {
        retrofit.create(TemperatureApiService::class.java)
    }

    enum class ApiStatus { LOADING, SUCCESS, FAILED }
}