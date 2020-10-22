package com.zzazzu.sqllitetest_201020

import com.zzazzu.sqllitetest_201020.Model.Person
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zzazzu.sqllitetest_201020.Adapter.ListPersonAdapter
import com.zzazzu.sqllitetest_201020.DBHelper.DBHelper
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

                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )
            db.addPerson(person)
            refreshData ()
        }

        btn_up.setOnClickListener {
            val person = Person(

                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )
            db.updatePerson(person)
            refreshData ()

        }

        btn_del.setOnClickListener {
            var person = Person(

                Integer.parseInt(edt_id.text.toString()),
                edt_name.text.toString(),
                edt_email.text.toString()
            )
            db.deletePerson(person)
            refreshData ()
        }

    }

    private fun refreshData() {
        lstPersons = db.allPerson
        val adapter = ListPersonAdapter(
            this@MainActivity,
            lstPersons,
            edt_id,
            edt_name,
            edt_email
        )
        list.adapter = adapter

    }
}