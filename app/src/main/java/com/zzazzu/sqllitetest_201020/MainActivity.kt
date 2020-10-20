package com.zzazzu.sqllitetest_201020

import android.app.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal lateinit var db:DBHelper
    internal var lstPersons:List<Person> = ArrayList<Person>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHelper(this)

        refreshData()

        btn_add.setOnClickListener {
            val person = Person(

    Integer.parseInt(edt_id.text.toString()),edt_name.text.toString(),edt_email.text.toString()
            )


        }

    }
}