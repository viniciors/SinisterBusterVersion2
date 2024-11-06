package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class AccountInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_info)

        // Encontre a Toolbar no layout
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        // Defina a Toolbar como o ActionBar da Activity
        setSupportActionBar(toolbar)

        // Exibe o botão de voltar na Toolbar
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Informações da Conta" // Este título substitui o título definido no XML, se desejado
        }
    }

    // Ação para o botão de voltar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Finaliza a Activity e retorna para a tela anterior
        return true
    }
}
