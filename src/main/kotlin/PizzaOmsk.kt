import java.lang.Math.round
import java.lang.module.ModuleReference

open class PizzaOmsk(
    neapolitanPizzaPrice:Double, romanPizzaPrice:Double,
     sicilianPizzaPrice:Double, tyroleanPizzaPrice:Double
):PizzaCity(
    neapolitanPizzaPrice, romanPizzaPrice,
    sicilianPizzaPrice, tyroleanPizzaPrice
),Drinks,CheckPhoto,Sauce{
    //Sauce
    override var sauceCount: Array<Int> = arrayOf(0,0)
    var sauceCountSum =0
    override var sauceValue: Array<Double> = arrayOf(50.9,56.5)
    override fun sauceSell() {
        println("Выберите соус?")
        println("1. Кетчуп ${sauceValue[0]} р.\n2. Горчица ${sauceValue[1]} р.\n\n0. Не интересует")
        when (readln()){
            "1"-> {
                sauceCount[0]++
                sauceCountSum++
            }
            "2"-> {
                sauceCount[1]++
                sauceCountSum++
            }
        }
    }

    override fun sauceStatistics() {
        println("Продано ${sauceCount[0]} кетчупа и ${sauceCount[1]} горчицы. Всего: ${sauceCountSum}")
        val sauceSum = sauceCount[0]*sauceValue[0]+sauceCount[1]*sauceValue[1]
        println("Получено ${sauceCount[0]*sauceValue[0]} за кетчуп и ${sauceCount[1]*sauceValue[1]} за горчицу. Всего: ${sauceSum}")
    }
    //Photo
    override var checkPhotoCount: Int = 0
    override var checkPhotoDiscount: Double = 30.75
    override fun showCheckPhoto() {
        println("У вас есть фотографии чека?")
        println("1. Да\n2. Нет")
        if (readln()=="1") {
            println("Cкидка ${checkPhotoDiscount}")
            checkPhotoCount++
        }
    }
    //Drink
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
    //Pizza
    override fun romanPizzaSale() {
        romanPizzaCount++
        println("римская пицца в Омске")
        romanPizzaDrinkCount = drinkSell(romanPizzaDrinkCount)
        sauceSell()
        showCheckPhoto()
    }

    override fun neapolitanPizzaSale() {
        neapolitanPizzaCount++
        println("неаполитанская пицца в Омске")
        neapolitanPizzaDrinkCount = drinkSell(neapolitanPizzaDrinkCount)
        sauceSell()
        showCheckPhoto()
    }

    override fun sicilianPizzaSale() {
        sicilianPizzaCount++
        println("сицилийская пицца в Омске")
        sicilianPizzaDrinkCount = drinkSell(sicilianPizzaDrinkCount)
        sauceSell()
        showCheckPhoto()
    }

    override fun tyroleanPizzaSale() {
        tyroleanPizzaCount++
        println("тирольская пицца в Омске")
        tyroleanPizzaDrinkCount = drinkSell(tyroleanPizzaDrinkCount)
        sauceSell()
        showCheckPhoto()
    }
}