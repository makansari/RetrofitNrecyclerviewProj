package com.example.bfrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.MyDataClass
import com.example.retrofitapp.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
// retrofit with recycler view... NO MVVM DEMO
class MainActivity : AppCompatActivity() {
    lateinit var myAdapter : MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userList  = ArrayList<MyDataClass>()

        var recyclerView = findViewById<RecyclerView>(R.id.recyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

        val makeCall = RetrofitClient.myRetrofit.getUsers()
        makeCall.enqueue(object : Callback<List<MyDataClass>> {

            override fun onResponse(
                call: Call<List<MyDataClass>>,
                response: Response<List<MyDataClass>>
            ) {
                var users : List<MyDataClass> = response.body()!!
                Log.i("mytag","" +users)
                for(Eachuser in users){
                    userList.add(MyDataClass(Eachuser.id,Eachuser.name,Eachuser.username))
                    Log.i("mytag" , "" + Eachuser.id  + Eachuser.name + Eachuser.username)
                }
                myAdapter.refreshList(userList)
            }

            override fun onFailure(call: Call<List<MyDataClass>>, t: Throwable) {
                Log.i("mytag","Faliure : " + t.message)
            }
        })

         myAdapter = MyAdapter(userList)
        recyclerView.adapter = myAdapter

        /*val userList  = ArrayList<Users>()

        userList.add (Users("Ansari","1235644","Delhi"))
        userList.add(Users("Debashis","334444","Noida"))
        userList.add(Users("Saxena","775775","Bangalore"))
        userList.add(Users("Kabir","2365855","Mysore"))
        userList.add(Users("Ansari","775775","Mumabi"))

        val myAdapter = MyAdapter(userList)

        recyclerView.adapter = myAdapter*/
    }
}
