package com.v4u.retrofitnetworkcall

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.*

interface IRequestInterface {

    @POST
    fun callingPostRequest(@Url url: String, @Body request: JsonObject): Call<JsonObject>

    @GET
    fun callingGetRequest(@Url url: String): Call<JsonObject>

    @PUT
    fun callingPutRequest(@Url url: String, @Body request: JsonObject): Call<JsonObject>
}