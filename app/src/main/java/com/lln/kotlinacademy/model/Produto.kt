package com.lln.kotlinacademy.model

class Produto (
    var idProduto: Long,
    var nome: String = ""
) {
    override fun toString(): String {
        return nome
    }
}