package com.example.sharedpreferences
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class  MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var password_toggle: Switch


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        password_toggle=findViewById(R.id.password_toggle)
        button =findViewById(R.id.button)
        loadData()
        button.setOnClickListener(){
            saveData()
        }
   }
private fun saveData() {
    val insertedText = editText.text.toString()
    textView.text = insertedText
    val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("inserted_text", insertedText)
    editor.apply()
    Toast.makeText(this,"Data saved",Toast.LENGTH_SHORT).show()
}
    private fun loadData() {
    val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
    val savedString =sharedPreferences.getString("STRING_KEY",null)
    val savedBoolean =sharedPreferences.getBoolean("BOOLEAN_KEY",false)
    textView.text = savedString
    password_toggle.isChecked=savedBoolean
}}








