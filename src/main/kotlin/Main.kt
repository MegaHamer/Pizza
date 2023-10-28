import kotlin.system.exitProcess

fun main() {
    val pizzaMoscow = PizzaMoscow(200.0,300.0,270.0,350.0)
    val pizzaPiter = PizzaPeter(250.50,320.99, 290.30,370.60)
    var currentPizza:PizzaCity

    while (true){
        println("Выберите город:")
        println("1. Москва\n2. Санкт- Петербург\n\n0. Выход из программы")
        currentPizza = when (readln()){
            "1"->{
                pizzaMoscow
            }
            "2"->{
                pizzaPiter
            }
            "0"->break
            else-> {
                println("ERROR")
                continue
            }
        }
        println("Выберите пиццу:")
        println("1. Неаполитанская пицца\n2. Римская пицца\n" +
                "3. Сицилийская пицца\n4. Тирольская пицца\n" +
                "0. Посмотреть статистику")
        selectPizza(currentPizza)
    }
}

private fun selectPizza(currentPizza: PizzaCity) {
    when (readln()) {
        "1" -> {
            currentPizza.neapolitanPizzaSale()
            selectAddService(currentPizza)
        }

        "2" -> {
            currentPizza.romanPizzaSale()
            selectAddService(currentPizza)
        }

        "3" -> {
            currentPizza.sicilianPizzaSale()
            selectAddService(currentPizza)
        }

        "4" -> {
            currentPizza.tyroleanPizzaSale()
            selectAddService(currentPizza)
        }

        "0" -> {
            currentPizza.showStatistics()
            if (currentPizza is Drinks) currentPizza.drinkStatistics()
        }
        else -> {
            println("ERROR")
            exitProcess(1)
        }
    }
}

fun selectAddService(currentPizza:PizzaCity){
    when (currentPizza){
        is CheckPhoto -> currentPizza.showCheckPhoto()
        /*is Drinks-> currentPizza.drinkSell()*/
    }
}