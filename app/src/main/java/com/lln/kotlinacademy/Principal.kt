package com.lln.kotlinacademy

fun main() {

}

fun String.LowerCase() : String {
    return this.trim().toLowerCase()
}

fun calcularDesconto(valor: Double, desconto: Double): Double {

    val valor_fornecido = 100.0
    val desconto = 25.0

    var valor_final: Double? = null

    valor_final = calcularDesconto(valor_fornecido, desconto)

    valor_final?.let {
        println("Valor Final com Desconto: $valor_final")
    }

    return valor * (1 - desconto / 100)
}

fun diferencaEntreOperadores(){
    var valor_primario = 0
    var valor_secundario = 0

    /**
     * Retorna 0 pois o Incremento é apos a Operacao
     *
     * return 0
     */
    println(valor_primario++)


    /**
     * Retorna 1 pois o Incremento é antes da Operacao
     *
     * return 1
     */
    println(++valor_secundario)
}