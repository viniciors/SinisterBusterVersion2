package com.example.myapplication

import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class NotificationsActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private var userId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        // Configura a Toolbar como ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Configurações de Notificações"
        }

        // Inicializar o Firebase Auth e fazer login anônimo, se necessário
        auth = FirebaseAuth.getInstance()
        if (auth.currentUser == null) {
            auth.signInAnonymously()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        userId = auth.currentUser?.uid
                        initializeUI()
                    } else {
                        Toast.makeText(this, "Erro na autenticação", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            userId = auth.currentUser?.uid
            initializeUI()
        }
    }

    private fun initializeUI() {
        // Inicialize o Firebase Database
        database = FirebaseDatabase.getInstance().getReference("user_settings")

        // Encontre o Switch para notificações
        val notificationSwitch: Switch = findViewById(R.id.notification_switch)

        // Carregar o estado atual das configurações de notificações
        loadNotificationSettings(notificationSwitch)

        // Listener para o switch de notificações
        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            saveNotificationSettings(isChecked)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun saveNotificationSettings(isEnabled: Boolean) {
        if (userId == null) {
            Toast.makeText(this, "Erro: Usuário não autenticado", Toast.LENGTH_SHORT).show()
            return
        }

        database.child(userId!!).child("notifications_enabled").setValue(isEnabled)
            .addOnSuccessListener {
                Toast.makeText(this, "Configuração de notificações salva", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Erro ao salvar configuração: ${exception.message}", Toast.LENGTH_LONG).show()
            }
    }

    private fun loadNotificationSettings(notificationSwitch: Switch) {
        if (userId == null) {
            return
        }

        database.child(userId!!).child("notifications_enabled").get().addOnSuccessListener { dataSnapshot ->
            val isEnabled = dataSnapshot.getValue(Boolean::class.java) ?: false
            notificationSwitch.isChecked = isEnabled
        }.addOnFailureListener {
            Toast.makeText(this, "Erro ao carregar configuração", Toast.LENGTH_SHORT).show()
        }
    }
}
