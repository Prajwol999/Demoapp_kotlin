package com.example.demokotlin

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demokotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var loginBinding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        sharedPreferences = getSharedPreferences("signup", MODE_PRIVATE)

        loginBinding.textView.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }

        loginBinding.signupView2.setOnClickListener {
            sharedPreferences = getSharedPreferences("signup", MODE_PRIVATE)
            var email = sharedPreferences.getString("email", "")
            var password = sharedPreferences.getString("password", "")

            if (email == loginBinding.editTextTextEmailAddress.text.toString() && password == loginBinding.editTextTextPassword.text.toString()) {
                intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
            }
        }


    }

    override fun onResume() {
        super.onResume()
        loginBinding.editTextTextEmailAddress.setText(sharedPreferences.getString("email", ""))
        loginBinding.editTextTextPassword.setText(sharedPreferences.getString("password", ""))
        Toast.makeText(this@LoginActivity, "Welcome", Toast.LENGTH_SHORT).show()


    }
}