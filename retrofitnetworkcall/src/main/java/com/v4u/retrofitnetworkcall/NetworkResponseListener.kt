package com.v4u.retrofitnetworkcall

interface NetworkResponseListener {
    fun onSuccessResponse(req: Int, response: String)
    fun onErrorResponse(req: Int, response: String)
    fun onFailureResponse(req: Int, message: String?)
}