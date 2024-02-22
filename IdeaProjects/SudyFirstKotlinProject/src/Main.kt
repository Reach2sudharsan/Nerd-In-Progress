fun main(){
    val calc = Calculator(2.0,1.0)
    println(calc.add())
    println(calc.sub())
    println(calc.multi())
    println(calc.div())


}

class Calculator(val num1:Double, val num2:Double) {
    fun add() : Double {
        return num1 + num2
    }

    fun sub() : Double {
        return num1 - num2
    }

    fun multi() : Double {
        return num1 * num2
    }

    fun div() : Double {
        return num1 / num2
    }
}
