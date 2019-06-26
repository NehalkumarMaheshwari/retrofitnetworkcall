package com.v4u.retrofitnetworkcall

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.*

class RetrofitApiLogic(private val networkResponseListener: NetworkResponseListener) {

    /**
     * calling post api with request parameter
     * and return response using NetworkResponseListener
     * @param req is unique number for every url. Easy to bifurcate which context calling which url
     * @param url is api name
     * @param jsonObject for request parameter
     * @param headerMap if you have to add your custom header then and only use this parameter
     */
    fun callingPostApi(req: Int, url: String, jsonObject: JsonObject, headerMap: HashMap<String, String> =
        hashMapOf("Accept" to "application/json", "Content-Type" to "application/json")) {
        try {
            ApiClient.getClient(headerMap)!!.callingPostRequest(url, jsonObject).apply {
                enqueue(object : Callback<JsonObject> {
                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        networkResponseListener.onFailureResponse(req, t.message)
                    }

                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        if (response.code() == 200) {
                            networkResponseListener.onSuccessResponse(req, response.body().toString())
                        } else {
                            networkResponseListener.onErrorResponse(req, response.errorBody().toString())
                        }
                    }
                })
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    /**
     * calling get api
     * and return response using NetworkResponseListener
     * @param req is unique number for every url. Easy to bifurcate which context calling which url
     * @param url is api name
     * @param headerMap if you have to add your custom header then and only use this parameter
     */
    fun callingGetApi(
        req: Int, url: String, headerMap: HashMap<String, String> = hashMapOf(
            "Accept" to "application/json", "Content-Type" to "application/json"
        )
    ) {
        try {
            ApiClient.getClient(headerMap)!!.callingGetRequest(url).apply {
                enqueue(object : Callback<JsonObject> {
                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        networkResponseListener.onFailureResponse(req, t.message)
                    }

                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        if (response.code() == 200) {
                            networkResponseListener.onSuccessResponse(req, response.body().toString())
                        } else {
                            networkResponseListener.onErrorResponse(req, response.errorBody().toString())
                        }
                    }
                })
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    /**
     * calling put api with request parameter
     * and return response using NetworkResponseListener
     * @param req is unique number for every url. Easy to bifurcate which context calling which url
     * @param url is api name
     * @param jsonObject for request parameter
     * @param headerMap if you have to add your custom header then and only use this parameter
     */
    fun callingPutApi(req: Int, url: String, jsonObject: JsonObject, headerMap: HashMap<String, String> =
            hashMapOf("Accept" to "application/json", "Content-Type" to "application/json")) {
        try {
            ApiClient.getClient(headerMap)!!.callingPutRequest(url, jsonObject).apply {
                enqueue(object : Callback<JsonObject> {
                    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                        networkResponseListener.onFailureResponse(req, t.message)
                    }

                    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                        if (response.code() == 200) {
                            networkResponseListener.onSuccessResponse(req, response.body().toString())
                        } else {
                            networkResponseListener.onErrorResponse(req, response.errorBody().toString())
                        }
                    }
                })
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

