package com.example.calculadora

class CalculadoraKt {
    var num1: String = ""
    var num2: String = ""
    var operacion: Char = 0.toChar()

    fun meterNumero(num: Int){
        num2 += num
    }
    fun meterComa(){
        if(!num2.contains(".")){
            num2 += "."
        }
    }
    fun clear(){
        num1 = ""
        num2 = ""
        operacion = 0.toChar()
    }
    fun operacion(op: Char){
        num1 = num2
        num2 =""
        operacion = op
    }
    fun igual(){
        var num1 = this.num1.toDouble()
        var num2 = this.num2.toDouble()

        this.num2 = when(operacion){
            '+' -> (num1 + num2).toString()
            '-' -> (num1 - num2).toString()
            '*' -> (num1 * num2).toString()
            '/' -> (num1 / num2).toString()
            else -> ""
        }
    }


}