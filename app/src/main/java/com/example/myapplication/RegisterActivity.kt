package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val registerButton: Button = findViewById(R.id.btnRegister)
        val emailField: EditText = findViewById(R.id.etRegisterEmail)
        val passwordField: EditText = findViewById(R.id.etRegisterPassword)

        registerButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                registerUser(email, password)
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Registro bem-sucedido", Toast.LENGTH_SHORT).show()
                    // Redirecionar para a LoginActivity após o registro
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    finish() // Finaliza RegisterActivity
                } else {
                    Toast.makeText(this, "Erro no registro: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
