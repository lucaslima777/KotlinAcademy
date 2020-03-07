package com.lln.kotlinacademy.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lln.kotlinacademy.R
import com.lln.kotlinacademy.util.DB
import com.lln.kotlinacademy.util.showMessage
import kotlinx.android.synthetic.main.activity_credential.*
import kotlinx.android.synthetic.main.activity_credit.*

class CreditActivity : AppCompatActivity() {

    private lateinit var txtIdade: String

    private lateinit var nome: String
    private lateinit var age: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)
        initActions()
    }

    private fun initActions() {

        credit_btn_analyze.setOnClickListener {
            txtIdade = credit_et_age.text.toString()
            setCredential()

            if (validNameEmpty() && validAgedEmpty()) {
                analyzeCredit()
            } else {
                showMessage(this, "Preencha os Campos")
            }
        }

    }

    private fun analyzeCredit() {
        val idade = txtIdade.toInt()

        if (credit_cb_city.isChecked) {
            if (idade >= 25) {
                showMessage(this, "R$ 5.000,00")
            }

            if (idade < 25) {
                showMessage(this, "R$ 1.000,00")
            }
        } else {
            if (idade >= 25) {
                showMessage(this, "R$ 2.500,00")
            }

            if (idade < 25) {
                showMessage(this, "R$ 0,00")
            }
        }
    }

    fun validNameEmpty(): Boolean {
        if (nome.isEmpty()) {
            showMessage(this, "Nome Obrigatorio")
            return false
        }
        return true
    }

    fun validAgedEmpty(): Boolean {
        if (age.isEmpty()) {
            showMessage(this, "Idade Obrigatorio")
            return false
        }
        return true
    }

    fun setCredential() {
        nome = credit_et_nome.text.toString().DB()
        age = credit_et_age.text.toString().DB()
    }
}
