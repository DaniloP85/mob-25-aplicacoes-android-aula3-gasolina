package com.example.exercicio2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * add um botão para limpar os campos
        * caso queira colocar outros valores
        *
        * */

        btn_limpar.setOnClickListener {
            txt_resultado_gasolina_alcool.visibility = TextView.INVISIBLE
            edit_txt_preco_gasolina.setText("")
            edit_txt_preco_alcool.setText("")
        }

        btn_calcular.setOnClickListener {

            val valorDigitadoGasolina = edit_txt_preco_gasolina.text.toString()
            val nome = edit_txt_nome.text.toString()
            val valorDigitadoAlcool = edit_txt_preco_alcool.text.toString()
            val validarCampos = validarCampos(valorDigitadoAlcool, valorDigitadoGasolina)
            if (validarCampos) {
                calculaMelhorPreco(valorDigitadoAlcool, valorDigitadoGasolina, nome)
            } else {
                txt_resultado_gasolina_alcool.visibility = TextView.VISIBLE
                txt_resultado_gasolina_alcool.text = "Preenche os campos primeiros"
            }
        }
    }

    /*
    * add hide and show, caso o cliente queira preencher outros valores
    * */

    @SuppressLint("SetTextI18n")
    private fun calculaMelhorPreco(precoAlcool: String, precoGasolina: String, nome: String) {
        val resultado = precoAlcool.toDouble() / precoGasolina.toDouble()
        if (resultado >= 0.7) {
            txt_resultado_gasolina_alcool.visibility = TextView.VISIBLE
            txt_resultado_gasolina_alcool.text = "$nome: melhor utilizar Gasolina"
        } else {
            txt_resultado_gasolina_alcool.visibility = TextView.VISIBLE
            txt_resultado_gasolina_alcool.text = "$nome: melhor utilizar Alcool"
        }
    }

    /*
    * nessa proxima funcão*/

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