package com.v4u.retrofitnetworkcall

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class HeaderInterceptor(private val headerMap: HashMap<String, String>) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        val reqBuilder = request().newBuilder()
        headerMap.forEach {
            reqBuilder.addHeader(it.key, it.value)
        }
        proceed(reqBuilder.build())
    }
}