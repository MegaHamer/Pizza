open class PizzaMoscow(
    neapolitanPizzaPrice:Double, romanPizzaPrice:Double,
     sicilianPizzaPrice:Double, tyroleanPizzaPrice:Double
):PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
),CheckPhoto{
    override fun showCheckPhoto() {
        println("У вас есть фотографии чека?")
        println("1. Да\n2. Нет")
        if (readln()=="1") println("Cкидка 50 руб")
    }
    override fun romanPizzaSale() {
        romanPizzaCount++
        println("римская пицца в мск")
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("неаполитанская пицца в мск")
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("сицилийская пицца в мск")
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("тирольская пицца в мск")
    }
    }