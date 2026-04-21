package com.example.damemiorden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class Pedido : Fragment() {

    private lateinit var etDireccion: EditText
    private lateinit var etApartamento: EditText
    private lateinit var etIndicaciones: EditText
    private lateinit var etTelefono: EditText
    private lateinit var btnCasa: Button
    private lateinit var btnTrabajo: Button
    private lateinit var btnOtro: Button
    private lateinit var btnGuardarDireccion: Button
    private lateinit var tvOtroMomento: TextView

    private var tipoDireccion = "Casa"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pedido, container, false)

        etDireccion = view.findViewById(R.id.etDireccion)
        etApartamento = view.findViewById(R.id.etApartamento)
        etIndicaciones = view.findViewById(R.id.etIndicaciones)
        etTelefono = view.findViewById(R.id.etTelefono)
        btnCasa = view.findViewById(R.id.btnCasa)
        btnTrabajo = view.findViewById(R.id.btnTrabajo)
        btnOtro = view.findViewById(R.id.btnOtro)
        btnGuardarDireccion = view.findViewById(R.id.btnGuardarDireccion)
        tvOtroMomento = view.findViewById(R.id.tvOtroMomento)

        btnCasa.setOnClickListener {
            tipoDireccion = "Casa"
            Toast.makeText(requireContext(), "Tipo de dirección: Casa", Toast.LENGTH_SHORT).show()
        }

        btnTrabajo.setOnClickListener {
            tipoDireccion = "Trabajo"
            Toast.makeText(requireContext(), "Tipo de dirección: Trabajo", Toast.LENGTH_SHORT).show()
        }

        btnOtro.setOnClickListener {
            tipoDireccion = "Otro"
            Toast.makeText(requireContext(), "Tipo de dirección: Otro", Toast.LENGTH_SHORT).show()
        }

        btnGuardarDireccion.setOnClickListener {
            val direccion = etDireccion.text.toString().trim()
            val apartamento = etApartamento.text.toString().trim()
            val indicaciones = etIndicaciones.text.toString().trim()
            val telefono = etTelefono.text.toString().trim()

            if (direccion.isEmpty() || indicaciones.isEmpty() || telefono.isEmpty()) {
                Toast.makeText(requireContext(), "Completa los campos obligatorios", Toast.LENGTH_SHORT).show()
            } else {
                val mensaje = """
                    Dirección guardada
                    Dirección: $direccion
                    Apartamento: $apartamento
                    Indicaciones: $indicaciones
                    Teléfono: $telefono
                    Tipo: $tipoDireccion
                """.trimIndent()

                Toast.makeText(requireContext(), mensaje, Toast.LENGTH_LONG).show()
            }
        }

        tvOtroMomento.setOnClickListener {
            Toast.makeText(requireContext(), "Puedes agregar la dirección después", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}