package com.example.demokotlin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demokotlin.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var registerBinding: ActivityRegisterBinding
    lateinit var sharedPreferences: SharedPreferences


    var gender = arrayOf("Male", "Female", "rather not say")


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        var adapter = ArrayAdapter(
            this@RegisterActivity,
            android.R.layout.simple_spinner_dropdown_item,
            gender
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        registerBinding.spinner.adapter = adapter
        registerBinding.spinner.onItemSelectedListener = this

        registerBinding.buttonSignup.setOnClickListener {
            sharedPreferences = getSharedPreferences("Register", MODE_PRIVATE)
            var editor = sharedPreferences.edit()
            editor.putString("name", registerBinding.nameText.text.toString())
            editor.putString("email", registerBinding.emailAddress2.text.toString())
            editor.putString("password", registerBinding.password2.text.toString())
            var getPass = registerBinding.password2.text.toString()

            if (registerBinding.confirmPass.text.toString() == getPass) {
                editor.putString("confirmPass", registerBinding.confirmPass.text.toString())
            } else {
                registerBinding.confirmPass.error = "password not match"
            }
            editor.putString("gender", registerBinding.spinner.selectedItem.toString())
            if (registerBinding.checkBox4.isChecked) {
                var intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            } else {
                registerBinding.checkBox4.error = "Please accept the terms and conditions"
            }
            editor.apply()

        }
    }
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            val selectedItem = parent.getItemAtPosition(position).toString()
        }
    }
    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")

    }

}

