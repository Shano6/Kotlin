package com.example.facebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook.app.RestClient
import com.example.facebook.app.User_RecycleViewAdapter
import com.example.facebook.app.dto.ReqResData
import com.example.facebook.app.dto.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RestClient.initClient()

        val users : ArrayList<User> = arrayListOf();
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerID);

        RestClient.reqResApi.getUsers(1).enqueue(
            object: Callback<ReqResData<List<User>>>{
                override fun onResponse(
                    call: Call<ReqResData<List<User>>>,
                    response: Response<ReqResData<List<User>>>
                ) {
                    if(response.isSuccessful && response.body() != null){
                        response.body()!!.data?.forEach {
                                user -> users.add(user);
                        }
                    }
                }
                override fun onFailure(call: Call<ReqResData<List<User>>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            }
        )

        val adapter = User_RecycleViewAdapter(this, users)
        recyclerView.adapter = adapter;
        recyclerView.layoutManager = LinearLayoutManager(this);
    }
}