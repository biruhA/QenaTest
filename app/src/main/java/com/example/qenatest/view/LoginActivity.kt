package com.example.qenatest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.qenatest.R
import com.example.qenatest.databinding.ActivityLoginBinding
import com.example.qenatest.databinding.ActivityRegistrationBinding
import com.example.qenatest.view_model.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()
    private var username: String = ""
    private var password: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerBtn.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }

        binding.submitBtn.setOnClickListener {
            username = binding.usernameEdit.text.toString()
            password = binding.passwordEdit.text.toString()
            if(username.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please fill the form", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
//        loginViewModel.toolBarTitle.observe(this){
//
//        }

    }
}