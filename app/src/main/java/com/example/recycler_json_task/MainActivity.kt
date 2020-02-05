package com.example.recycler_json_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        jchoiceApi().getCategory().enqueue(object :Callback<List<Categorry>>{

            override fun onFailure(call: Call<List<Categorry>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                Toast.makeText(applicationContext,"Try again!",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<List<Categorry>>,
                response: Response<List<Categorry>>
            ) {

               val categorry = response.body()

                categorry?.let {
                       showjdata(it)
                   }
                }

        })

    }
    private fun showjdata(jdatas:List<Categorry>){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CategoryAdapter(jdatas)
    }
}
