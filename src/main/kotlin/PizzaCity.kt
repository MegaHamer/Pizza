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
         var service:Double=0.0
         when (this){
             is Drinks -> {
                 service = drinkPrice * drinkCount
                 println("Приобрели ${drinkCount} напитков по ${drinkPrice}. Итого: $service")
             }
             is CheckPhoto -> {
                 service = checkPhotoDiscount * checkPhotoCount * -1
                 println("Чек предоставили ${checkPhotoCount} раз со скидкой ${checkPhotoDiscount}. Итого: ${-service}")
             }
         }
         println("Всего заработано с учетом сервиса: ${money+service}")
     }
}