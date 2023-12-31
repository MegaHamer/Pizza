import java.lang.Math.round
import java.lang.module.ModuleReference

open class PizzaPeter(
    neapolitanPizzaPrice:Double, romanPizzaPrice:Double,
     sicilianPizzaPrice:Double, tyroleanPizzaPrice:Double
):PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
),Drinks{
    override fun drinkStatistics() {
        println("Продано напитков к сицилийской пицце: $sicilianPizzaDrinkCount(${round(sicilianPizzaDrinkCount/sicilianPizzaCount.toDouble()*100.0)}%)")
        println("Продано напитков к неаполитпнской пицце: ${neapolitanPizzaDrinkCount}(${round(neapolitanPizzaDrinkCount/neapolitanPizzaCount.toDouble()*100.0)}%)")
        println("Продано напитков к римской пицце: $romanPizzaDrinkCount(${round(romanPizzaDrinkCount/romanPizzaCount.toDouble()*100.0)}%)")
        println("Продано напитков к тирольской пицце: $tyroleanPizzaDrinkCount(${round(tyroleanPizzaDrinkCount/tyroleanPizzaCount.toDouble()*100.0)}%)")
    }
    override var neapolitanPizzaDrinkCount: Int = 0
    override var romanPizzaDrinkCount: Int = 0
    override var sicilianPizzaDrinkCount: Int = 0
    override var tyroleanPizzaDrinkCount: Int = 0
    override var drinkCount: Int = 0
    override var drinkPrice: Double = 120.0
    override fun drinkSell(PizzaDrinkCount:Int):Int {
        println("Будете кофе?")
        println("1. Да\n2. Нет")
        if (readln()=="1") {
            println("С вас ${drinkPrice} руб")
            drinkCount++
            return PizzaDrinkCount+1
        }
        return PizzaDrinkCount
    }
    override fun romanPizzaSale() {
        romanPizzaCount++
        println("римская пицца в спб")
        romanPizzaDrinkCount = drinkSell(romanPizzaDrinkCount)
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("неаполитанская пицца в спб")
        neapolitanPizzaDrinkCount = drinkSell(neapolitanPizzaDrinkCount)
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("сицилийская пицца в спб")
        sicilianPizzaDrinkCount = drinkSell(sicilianPizzaDrinkCount)
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("тирольская пицца в спб")
        tyroleanPizzaDrinkCount = drinkSell(tyroleanPizzaDrinkCount)
    }
}