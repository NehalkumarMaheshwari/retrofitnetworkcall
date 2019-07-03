package com.v4u.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.v4u.retrofitnetworkcall.NetworkResponseListener
import com.v4u.retrofitnetworkcall.RetrofitApiLogic

class MainActivity : AppCompatActivity(), NetworkResponseListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Calling get api request
         * Req is unique number for every url. Easy to bifurcate which context calling which url
         * Url is api your name
         * Last param is Hash map for header. If you have custom params for header then and only you have to add in method arguments.
         */
        RetrofitApiLogic(this).callingGetApi(1,"URL")
    }

    override fun onSuccessResponse(req: Int, response: String) {
        TODO("Fetch success response here according your req")
    }

    override fun onErrorResponse(req: Int, response: String) {
        TODO("Fetch error response here according your req")
    }

    override fun onFailureResponse(req: Int, message: String?) {
        TODO("Fetch any failure here according your req")
    }
}
