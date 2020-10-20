package com.zzazzu.sqllitetest_201020.DBHelper

import android.app.Activity
import android.app.Person
import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.zzazzu.sqllitetest_201020.R
import kotlinx.android.synthetic.main.lowlayout.view.*
import java.text.FieldPosition

class ListPersonAdapter (internal val activity: Activity,
                         internal val lstPerson: List<Person>,
                         internal val edtd_id: EditText,
                         internal val edt_name:EditText,
                         internal val edt_email:EditText):BaseAdapter() {

    internal var inflater:LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rowView: View
        rowView = inflater.inflate(R.layout.low_layout, null)

        rowView.row_id.text = lstPerson[position].id.toString()
        rowView.row_name.text = lstPerson[position].name.toString()
        rowView.row_email.text = lstPerson[position].email.toString()

        rowView.setOnClickListener {
            edtd_id.setText(rowView.row_id.text.toString())
            edt_name.setText(rowView.row_name.text.toString())
            edt_email.setText(rowView.row_email.text.toString())
        }
        return rowView
    }

    override fun getItem(position: Int): Any {
        return lstPerson[position]

    }

    override fun getItemId(position: Int): Long {
        return lstPerson[position].id.toLong()

    }

    override fun getCount(): Int {
        return lstPerson.size
    }

}




