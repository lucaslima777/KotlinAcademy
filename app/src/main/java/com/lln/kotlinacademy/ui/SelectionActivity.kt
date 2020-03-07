package com.lln.kotlinacademy.ui

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lln.kotlinacademy.R
import com.lln.kotlinacademy.util.showMessage
import kotlinx.android.synthetic.main.activity_selection.*

class SelectionActivity : AppCompatActivity() {

    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)

        initVars()
        initActions()
    }

    private fun initVars() {
        context = this

        setValuesSelection()
    }

    private fun setValuesSelection() {
        val checkBoxIos = 1
        val checkBoxAndroid = 0

        val radioButtonProgrammer = "p"
        val radioButtonDesign = "d"

        val toggleButtonBinary = true
        val toggleButtonBoolean = false

        selection_cb_ios.isChecked = checkBoxIos == 1
        selection_cb_android.isChecked = checkBoxAndroid == 1

        when (radioButtonProgrammer.toLowerCase()) {
            "p" -> selection_rb_programmer.isChecked = true
            "d" -> selection_rb_design.isChecked = true
            else -> {

            }
        }

        selection_tb_zero_one.isChecked = toggleButtonBinary
        selection_tb_true_false.isChecked = toggleButtonBoolean

    }


    private fun initActions() {
        selection_cb_ios.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                showMessage(context, "iOS")
            } else {
                showMessage(context, "Not iOS")
            }
        }

        selection_cb_android.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                showMessage(context, "Android")
            } else {
                showMessage(context, "Not Android")
            }
        }

        selection_radio_group.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.selection_rb_programmer -> showMessage(context, "Programador")
                R.id.selection_rb_design -> showMessage(context, "Design")
            }
        }

    }

}
