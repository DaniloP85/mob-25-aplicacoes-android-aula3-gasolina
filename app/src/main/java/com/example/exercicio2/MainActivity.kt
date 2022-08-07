package com.example.exercicio2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_calcular.setOnClickListener {

            val valorDigitadoGasolina = edit_txt_preco_gasolina.text.toString()

            val valorDigitadoAlcool = edit_txt_preco_alcool.text.toString()
            val validarCampos = validarCampos(valorDigitadoAlcool, valorDigitadoGasolina)
            if (validarCampos) {
                calculaMelhorPreco(valorDigitadoAlcool, valorDigitadoGasolina)
            } else {
                txt_resultado_gasolina_alcool.text = "Preenche os campos primeiros"
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculaMelhorPreco(precoAlcool: String, precoGasolina: String) {
        val resultado = precoAlcool.toDouble() / precoGasolina.toDouble()
        if (resultado >= 0.7) {
            txt_resultado_gasolina_alcool.text = "Melhor utilizar Gasolina"
        } else {
            txt_resultado_gasolina_alcool.text = "Melhor utilizar Alcool"
        }
    }

    private fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {
        var camposValidos = true
        if (precoAlcool.isBlank()) {
            camposValidos = false
        } else if (precoGasolina.isBlank()) {
            camposValidos = false
        }
        return camposValidos
    }
}