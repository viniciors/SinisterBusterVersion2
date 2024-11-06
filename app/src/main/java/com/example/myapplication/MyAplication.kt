package com.example.myapplication

import android.app.Application
import com.google.firebase.database.FirebaseDatabase

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Inicializa o Firebase Database com persistência offline
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
    }
}
