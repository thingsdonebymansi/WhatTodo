package com.guptamansi.whattodo

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
         //   v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        //    insets
       // }

        var todoList = mutableListOf(
            Todo("Exercise", false),
            Todo("Study", false),
            Todo("Eat",false),
            Todo("Play games", false)

        )

        val adapter = TodoAdapter(todoList)
        val rVTodo: RecyclerView = findViewById(R.id.rVTodos)

        rVTodo.adapter = adapter
        rVTodo.layoutManager = LinearLayoutManager(this)

        val btnAddTodo: AppCompatButton = findViewById(R.id.btnAddTodo)
        val eTText: EditText = findViewById(R.id.eTText)
        btnAddTodo.setOnClickListener{
            val title = eTText.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size -1)
        }



    }
}