package com.v4u.retrofitnetworkcall

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


object ApiClient {
    private var requestInterface: IRequestInterface? = null
    /**
     * Create retrofit instance
     * retrofit instance create IRequestInterface instance
     * IRequestInterface is used for calling post and get api
     * @return IRequestInterface
     */
    fun getClient(headerMap: HashMap<String, String>): IRequestInterface? {

        if (requestInterface == null) {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(HeaderInterceptor(headerMap))

            val retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build()

            requestInterface = retrofit.create(IRequestInterface::class.java)
        }
        return requestInterface
    }
}