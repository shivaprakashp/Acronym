package com.acronym.app.retrofit
import com.acronym.app.BuildConfig
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    private val MainApi = HttpUrl.Builder()
        .scheme("http")
        .host("www.nactem.ac.uk")
        .encodedPath("/software/acromine/dictionary.py/")
        .build()

    private val retrofitClient: Retrofit.Builder by lazy {

        val levelType: HttpLoggingInterceptor.Level
        if (BuildConfig.BUILD_TYPE.contentEquals("debug"))
            levelType = HttpLoggingInterceptor.Level.BODY else levelType = HttpLoggingInterceptor.Level.NONE

        val logging = HttpLoggingInterceptor()
        logging.setLevel(levelType)

        val okhttpClient = OkHttpClient.Builder()
        okhttpClient.addInterceptor(logging).build()

        Retrofit.Builder()
            .baseUrl(MainApi)
            .client(okhttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiInterface: Apiiinterface by lazy {
        retrofitClient
            .build()
            .create(Apiiinterface::class.java)
    }
}