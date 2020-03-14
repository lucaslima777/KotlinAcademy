package com.lln.kotlinacademy.ui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.lln.kotlinacademy.R
import com.lln.kotlinacademy.model.Produto
import com.lln.kotlinacademy.util.showMessage
import kotlinx.android.synthetic.main.activity_spinner.*

class SpinnerActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var data: ArrayList<String>

    private lateinit var adapterProduto: ArrayAdapter<Produto>
    private lateinit var dataProduto: ArrayList<Produto>

    private val default = "select name"
    private val defaultProduct = "select product"
    private val quantityTotal = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        initVars()
        initActions()
    }

    private fun initActions() {
        spinner_btn.setOnClickListener {
            val item = spinner_produtos.selectedItem as Produto
            showMessage(context, item.idProduto.toString())
        }

        spinner_btn_set.setOnClickListener {
            spinner_produtos.setPromptId(getPositionIndex(spinner_produtos, 1000))
        }
    }

    private fun getPositionIndex(spinner: Spinner, id: Long): Int {
        return 0
    }

    private fun initVars() {
        context = this
        quantityTotal.generateNames()

        adapter = ArrayAdapter(
            context,
            android.R.layout.simple_spinner_item,
            data
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_id.adapter = adapter

        //Produtos
        quantityTotal.generateProduct()

        adapterProduto = ArrayAdapter(
            context,
            android.R.layout.simple_spinner_item,
            dataProduto
        )

        adapterProduto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        spinner_produtos.adapter = adapterProduto
    }

    private fun Int.generateNames() {
        data = ArrayList()
        data.add(default)

        for (i in 1..this) {
            data.add("Option - $i")
        }
    }

    private fun Int.generateProduct() {
        dataProduto = ArrayList()
        dataProduto.add(Produto(-1L, defaultProduct))

        for (i in 1..this) {
            dataProduto.add(Produto((i * 1000).toLong(), "Produto - $i"))
        }
    }

}

