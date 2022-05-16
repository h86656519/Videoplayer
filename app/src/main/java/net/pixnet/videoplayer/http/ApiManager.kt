package net.pixnet.videoplayer.http

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager() {
    private var retrofit: Retrofit

    companion object {
        private lateinit var okHttpClient: OkHttpClient.Builder
        private var apiManager: ApiManager? = null

        @JvmStatic
        fun getInstance(): ApiManager {
            return ApiManager().also { apiManager = it }
        }
    }

    init {
        okHttpClient = OkHttpClient.Builder()

        okHttpClient.addInterceptor(Interceptor { chain: Interceptor.Chain ->
            val builder: Request.Builder = chain.request().newBuilder()
            builder.addHeader("Authorization", "0123456789#0#examId")
            val originRequest: Request = builder.build()
            chain.proceed(originRequest)
        }).addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })

        retrofit = Retrofit.Builder()
            .baseUrl("https://srv0api-dev-v2-dot-framy-stage.uc.r.appspot.com")
            .client(okHttpClient.build())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getVideoApiRetrofit(): VideoApi {
        return retrofit.create(VideoApi::class.java)
    }
}