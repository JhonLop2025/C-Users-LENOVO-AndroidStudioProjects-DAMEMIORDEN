package com.example.damemiorden

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.damemiorden.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fragemntos(Inicio())

        binding.menuNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.inicio -> fragemntos(Inicio())
                R.id.promociones -> fragemntos(Promociones())
                R.id.ubicacion -> fragemntos(Ubicacion())
                R.id.pedido -> fragemntos(Pedido())
                R.id.perfil -> fragemntos(Perfil())
            }
            true
        }
    }

    fun fragemntos(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}