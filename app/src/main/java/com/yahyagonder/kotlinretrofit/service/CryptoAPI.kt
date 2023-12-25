package com.yahyagonder.kotlinretrofit.service

import android.database.Observable
import com.yahyagonder.kotlinretrofit.model.CryptoModel
import retrofit2.http.GET

interface CryptoAPI {

    //GET, POST, UPDATE, DELETE

    //https://raw.githubusercontent.com/
    //atilsamancioglu/K21-JSONDataSet/master/crypto.json

    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    fun getData(): io.reactivex.rxjava3.core.Observable<List<CryptoModel>>

}