package com.lln.kotlinacademy.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lln.kotlinacademy.R
import com.lln.kotlinacademy.util.DB
import com.lln.kotlinacademy.util.showMessage
import kotlinx.android.synthetic.main.activity_credential.*

class CredentialActivity : AppCompatActivity() {

    private lateinit var nome: String
    private lateinit var senha: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credential)
        initActions()
    }

    fun initActions() {
        credential_btn_cancel.setOnClickListener { cancelar ->
            clearForm()
        }

        credential_btn_login.setOnClickListener { login ->
            setCredential()
            validForm()
        }
    }

    fun clearForm() {
        credential_et_nome.text.clear()
        credential_et_password.text.clear()
        nome = EMPTY
        senha = EMPTY
    }

    fun validForm() {
        if (isValidForm()) {
            credentialSuccess()
        }
    }

    fun credentialSuccess() {
        if (nome.equals(NOME) && senha.equals(SENHA)) {
            showMessage(this, getString(R.string.msg_success_login))
        } else {
            showMessage(this, getString(R.string.msg_error_invalid_credential))
        }
    }

    fun isValidForm(): Boolean {

        if (!validNameEmpty() && !validPasswordEmpty()) {
            showMessage(this, getString(R.string.msg_error_all_empty))
            return false
        }

        if (!validNameEmpty()) {
            return false
        }

        if (!validPasswordEmpty()) {
            return false
        }

        return true
    }

    fun validNameEmpty(): Boolean {
        if (nome.isEmpty()) {
            showMessage(this, getString(R.string.msg_error_name_empty))
            return false
        }
        return true
    }

    fun validPasswordEmpty(): Boolean {
        if (senha.isEmpty()) {
            showMessage(this, getString(R.string.msg_error_empty_password))
            return false
        }
        return true
    }

    fun setCredential() {
        nome = credential_et_nome.text.toString().DB()
        senha = credential_et_password.text.toString().DB()
    }

    companion object {
        val NOME = "Lucas"
        val SENHA = "123asd"
        val EMPTY = ""
    }
}
