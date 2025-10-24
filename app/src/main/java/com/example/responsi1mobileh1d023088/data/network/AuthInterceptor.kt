package com.example.responsi1mobileh1d023088.data.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        // API Key untuk Football Data API
        requestBuilder.addHeader("X-Auth-Token", "53e83a4e46194ff1b170071dc017a770")
        requestBuilder.addHeader("Content-Type", "application/json")
        requestBuilder.addHeader("Accept", "application/json")

        val request = requestBuilder.build()
        Log.d("AuthInterceptor", "Final request headers: ${request.headers}")

        return chain.proceed(request)
    }
}
