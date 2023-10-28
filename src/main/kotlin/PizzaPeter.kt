open class PizzaPeter(
    neapolitanPizzaPrice:Double, romanPizzaPrice:Double,
     sicilianPizzaPrice:Double, tyroleanPizzaPrice:Double
):PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
),Drinks{
    override var drinkCount: Int = 0
    override var drinkPrice: Double = 120.0
    override fun drinkSell() {
        println("Будете кофе?")
        println("1. Да\n2. Нет")
        if (readln()=="1") {
            println("С вас ${drinkPrice} руб")
            drinkCount++
        }
    }
    override fun romanPizzaSale() {
        romanPizzaCount++
        println("римская пицца в спб")
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("неаполитанская пицца в спб")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("сицилийская пицца в спб")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("тирольская пицца в спб")
    }
    }