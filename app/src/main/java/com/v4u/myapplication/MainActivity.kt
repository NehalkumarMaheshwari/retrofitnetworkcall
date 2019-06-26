package com.v4u.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.v4u.retrofitnetworkcall.NetworkResponseListener
import com.v4u.retrofitnetworkcall.RetrofitApiLogic

class MainActivity : AppCompatActivity(), NetworkResponseListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitApiLogic(this).callingGetApi(1,"URL")
    }

    override fun onSuccessResponse(req: Int, response: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onErrorResponse(req: Int, response: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFailureResponse(req: Int, message: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
