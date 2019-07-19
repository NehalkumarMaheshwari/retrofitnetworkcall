package com.v4u.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.v4u.retrofitnetworkcall.NetworkResponseListener

class MainActivity : AppCompatActivity(), NetworkResponseListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* root.snack("Hello"){
             action("Try"){
                 this@MainActivity.toast("Done")
             }
         }*/


        /*Log.v("Decrypted", "Decrypted String :- " +
                "KoZAAxx/Yoi+Jfa3nkgY5Q==".decryptAES128("abcdefghijklmnop"))*/


        /**
         * Calling get api request
         * apiName is your url name. Easy to bifurcate which context calling which url
         * Url is api your name
         * Last param is Hash map for header. If you have custom params for header then and only you have to add in method arguments.
         */
        //RetrofitApiLogic(this).callingGetApi("Login","URL")
    }



    override fun onSuccessResponse(apiName: String, response: String) {
        TODO("Fetch success response here according your req")
    }

    override fun onErrorResponse(apiName: String, response: String) {
        TODO("Fetch error response here according your req")
    }

    override fun onFailureResponse(apiName: String, message: String?) {
        TODO("Fetch any failure here according your req")
    }
}
