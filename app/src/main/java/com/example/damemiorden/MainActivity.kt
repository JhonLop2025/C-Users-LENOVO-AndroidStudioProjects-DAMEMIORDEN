package com.example.damemiorden

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.damemiorden.databinding.ActivityMainBinding

// 🔹 Fragment Intro
class IntroFragment : Fragment(R.layout.introactivity) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔥 Botón continuar
        val btn = view.findViewById<View>(R.id.btnContinuar)

        btn.setOnClickListener {
            (activity as MainActivity).fragmentos(Inicio())
        }
    }
}

// 🔹 MainActivity
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔥 Ocultar menú al inicio
        binding.menuNav.visibility = View.GONE

        // 🔥 Mostrar Intro primero
        fragmentos(IntroFragment())

        binding.menuNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.inicio -> fragmentos(Inicio())
                R.id.promociones -> fragmentos(Promociones())
                R.id.ubicacion -> fragmentos(Ubicacion())
                R.id.pedido -> fragmentos(Pedido())
                R.id.perfil -> fragmentos(Perfil())
            }
            true
        }
    }

    fun fragmentos(fragment: Fragment) {

        // 🔥 Mostrar u ocultar menú
        if (fragment is IntroFragment) {
            binding.menuNav.visibility = View.GONE
        } else {
            binding.menuNav.visibility = View.VISIBLE
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}