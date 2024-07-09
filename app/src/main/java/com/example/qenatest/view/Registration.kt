package com.example.qenatest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.qenatest.R
import com.example.qenatest.databinding.ActivityRegistrationBinding

class Registration : AppCompatActivity() {
    private lateinit var binding:ActivityRegistrationBinding
    private var username: String = ""
    private var password: String = ""
    private var email: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitBtn.setOnClickListener {
            username = binding.usernameEdit.text.toString()
            password = binding.passwordEdit.text.toString()
            email = binding.emailEdit.text.toString()

            if(username.isEmpty() || password.isEmpty() || email.isEmpty()){
                Toast.makeText(this, "Please fill the form", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }

    }
}