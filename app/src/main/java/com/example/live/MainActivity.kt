package com.example.live

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val textView : TextView = findViewById(R.id.text_vw)
        //определение адаптера под вывод списка
        val arrayAdapter: ArrayAdapter<*>
        //нахождение списка элементов в ресурсах(string-array)
        val devops_items: List<String> = this.resources.getStringArray(R.array.dewops_names).toList()
        val tools_items: List<String> = this.resources.getStringArray(R.array.tools_name).toList()
        val st_items: List<String> = this.resources.getStringArray(R.array.steck_technolog).toList()
        val work_items: List<String> = this.resources.getStringArray(R.array.work_time).toList()
        val list : ListView = findViewById(R.id.list_view)
        when(item.itemId){
            R.id.action_settings ->{
                textView.text = "Открыт список разработчиков"
                // вывод на xml
                arrayAdapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, devops_items)
                list.adapter = arrayAdapter
                return true
            }
            R.id.action_file1 ->{
                textView.text = "Открыт список ПО"
                arrayAdapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, tools_items)
                list.adapter = arrayAdapter
                return true
            }
            R.id.action_save2 ->{
                textView.text = "Открыт список стека технологий"
                arrayAdapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, st_items)
                list.adapter = arrayAdapter
                return true
            }
            R.id.action_save_as3 ->{
                textView.text = "Открыто расписание дня"
                arrayAdapter = ArrayAdapter(this,
                    android.R.layout.simple_list_item_1, work_items)
                list.adapter = arrayAdapter
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}