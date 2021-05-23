package com.example.calculadoradegorjeta

import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    lateinit var seekBarGorjeta: SeekBar
    lateinit var textPorcentagem:TextView
    lateinit var valorGorjeta:TextView
    lateinit var valorConta:TextInputEditText
    lateinit var valorTotal:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lembrarDeFazer()

        seekBarGorjeta = findViewById(R.id.seekBarGorjeta)
        textPorcentagem = findViewById(R.id.textResultadoSeekBar)
        valorGorjeta = findViewById(R.id.valorGorjeta)
        valorConta = findViewById(R.id.valorConta)
        valorTotal = findViewById(R.id.valorTotal)


        var porcentagem:Double = 0.0
        var gorjeta:Double = 0.0
        var totalConta:Double=0.0

        seekBarGorjeta.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
                porcentagem = progress.toDouble()
                gorjeta = (progress * valorConta.text.toString().toDouble() ) /100

                textPorcentagem.text=("${Math.round(porcentagem)}%")
                valorGorjeta.text = ("R$ ${gorjeta}")

                totalConta = (gorjeta + ( valorConta.text.toString().toDouble()))
                valorTotal.text="R$ ${totalConta}"

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }
        fun lembrarDeFazer(){
            TODO("Melhorar a interface")
        }
}