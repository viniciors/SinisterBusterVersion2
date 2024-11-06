package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class AjustesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar o layout do fragmento
        val view = inflater.inflate(R.layout.fragment_ajustes, container, false)

        // Botão de Informações da Conta
        val btnAccountInfo: Button = view.findViewById(R.id.btnAccountInfo)
        btnAccountInfo.setOnClickListener {
            val intent = Intent(activity, AccountInfoActivity::class.java)
            startActivity(intent)
        }

        // Botão de Notificações
        val btnNotifications: Button = view.findViewById(R.id.btnNotifications)
        btnNotifications.setOnClickListener {
            val intent = Intent(activity, NotificationsActivity::class.java)
            startActivity(intent)
        }

        // Botão de Sair
        val btnLogout: Button = view.findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            activity?.finish()
        }

        return view
    }
}