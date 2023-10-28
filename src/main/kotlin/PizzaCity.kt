import java.lang.Math.round

abstract class PizzaCity(
     val neapolitanPizzaPrice:Double, val romanPizzaPrice:Double,
     val sicilianPizzaPrice:Double, val tyroleanPizzaPrice:Double
 ) {
     var neapolitanPizzaCount = 0
     var romanPizzaCount = 0
     var sicilianPizzaCount = 0
     var tyroleanPizzaCount = 0
     abstract fun neapolitanPizzaSale()
     abstract fun romanPizzaSale()
     abstract fun sicilianPizzaSale()
     abstract fun tyroleanPizzaSale()
     fun showStatistics(){
         println("Продано сицилийской пиццы: $sicilianPizzaCount")
         println("Продано неаполитпнской пиццы: ${neapolitanPizzaCount}")
         println("Продано римской пиццы: $romanPizzaCount")
         println("Продано тирольской пиццы: $tyroleanPizzaCount")
         val money =neapolitanPizzaCount * neapolitanPizzaPrice +
                 romanPizzaCount * romanPizzaPrice +
                 sicilianPizzaCount * sicilianPizzaPrice +
                 tyroleanPizzaCount * tyroleanPizzaPrice
         println("Всего заработано денег на пицце: $money")
         var serviceSum:Double=0.0
         val pizzaCount = (neapolitanPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount).toDouble()
         if (this is Drinks){
                 serviceSum += drinkPrice * drinkCount
                 println("\nПриобрели ${drinkCount}(${round(drinkCount/pizzaCount*100.0)}%) напитков по ${drinkPrice}. Итого: ${drinkPrice * drinkCount}")
             drinkStatistics()
         }
         if (this is Sauce){
             serviceSum += sauceCount[0]*sauceValue[0]+sauceCount[1]*sauceValue[1]
             println()
             sauceStatistics()
         }
         if (this is CheckPhoto){
                 serviceSum += checkPhotoDiscount * checkPhotoCount * -1
                 println("\nЧек предоставили ${checkPhotoCount}(${round(checkPhotoCount/pizzaCount*100.0)}%) раз со скидкой ${checkPhotoDiscount}. Итого: ${checkPhotoDiscount * checkPhotoCount}")
         }
         println("\nВсего заработано с учетом сервиса: ${money+serviceSum}\n\n")
     }
}