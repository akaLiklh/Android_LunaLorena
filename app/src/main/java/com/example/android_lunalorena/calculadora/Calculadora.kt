package com.example.android_lunalorena.calculadora

class Calculadora {
    var num1: String = ""
    var num2: String = ""
    var operacion: Char = 0.toChar()

    fun meterNumero(num: Int){
        num2 += num
    }
    fun meterComa(){
        if (num2.isEmpty()) {
            num2 = "0."
        } else if (!num2.contains(".")) {
            num2 += "."
        }
    }
    fun clear(){
        num1 = ""
        num2 = ""
        operacion = ' '
    }
    fun operacion(op: Char){
        if (num2.isEmpty()) return
        num1 = num2
        num2 = ""
        operacion = op
    }
    fun igual(){
        val num1 = this.num1.toDoubleOrNull() ?: return
        val num2 = this.num2.toDoubleOrNull() ?: return

        this.num2 = when(operacion){
            '+' -> (num1 + num2).toString()
            '-' -> (num1 - num2).toString()
            '*' -> (num1 * num2).toString()
            '/' -> if (num2 == 0.0) "Error" else (num1 / num2).toString()
            else -> return
        }
        this.num1 = ""
        operacion = ' '
    }
}