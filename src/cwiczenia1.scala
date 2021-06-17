object cwiczenia1 {
  val daysOfWeek = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
  val productsMap = Map("cookies" -> 5.0, "coca-cola" -> 4.80, "beef" -> 10.0)
  val tuple3 = Tuple3(3, 4.0, "Test")
  val animals = Map("chicken" -> "bird", "tuna" -> "fish")

  def main(): Unit = {

    // zadanie 1a
    println("Days of week by for loop: ")
    daysOfWeekForLoop

    // zadanie 1b
    println("Only P days by for loop: ")
    daysOfWeekOnlyPDays

    // zadanie 1c
    println("Days of week while loop: ")
    daysOfWeekWhileLoop

    // zadanie 2a
    println("Days of week recursive loop: ")
    println(daysOfWeekRec(daysOfWeek))

    // zadanie 2b
    println("Days of week inverse recursive loop: ")
    println(daysOfWeekInverseRec(daysOfWeek))

    // zadanie 4a
    println("Days of week foldLeft: ")
    println(daysOfWeekFoldLeft(daysOfWeek))

    // zadanie 4b
    println("Days of week foldRight: ")
    println(daysOfWeekFoldRight(daysOfWeek))

    // zadanie 4c
    println("Days of week foldLeft with filter: ")
    println(daysOfWeekWithPFold(daysOfWeek))

    // zadanie 5
    println("Map products: ")
    println(promotion(productsMap))

    // zadanie 6
    println("Tuple 3: ")
    printTuple(tuple3)

    // zadanie 7
    println("Chicken is " + animals.get("chicken"))
    println("Dog is: " + animals.getOrElse("dog", "unknown"))
  }

  def daysOfWeekForLoop = {
    for(i <- daysOfWeek.indices) {
      println(daysOfWeek(i))
    }
  }

  def daysOfWeekOnlyPDays = {
    for(i <- daysOfWeek.indices) {
      if(daysOfWeek(i).startsWith("P")) {
        println(daysOfWeek(i))
      }
    }
  }

  def daysOfWeekWhileLoop = {
    var i = 0
    while(i < daysOfWeek.length -1 ) {
      println(daysOfWeek(i))
      i = i + 1
    }
  }

  def daysOfWeekRec(list: List[String]): String = {
    if(list.isEmpty) ""
    else list.head + '\n' + daysOfWeekRec(list.tail)
  }

  def daysOfWeekInverseRec(list: List[String]): String = {
    if(list.isEmpty) ""
    else list.last + '\n' + daysOfWeekInverseRec(list.init)
  }

  def daysOfWeekFoldLeft(list: List[String]): String = {
    list.foldLeft("")(_ + _ + '\n')
  }

  def daysOfWeekFoldRight(list: List[String]): String = {
    list.foldRight("")( '\n' + _ + _)
  }

  def daysOfWeekWithPFold(list: List[String]): String = {
    list.filter(p => p.startsWith("P")).foldLeft("")(_ + _ + '\n')
  }

  def promotion(products: Map[String, Double]): Map[String, Double] = {
    products.mapValues(p => p*0.9).toMap
  }

  def printTuple(tuple: (Int, Double, String)): Unit = {
    tuple.productIterator.foreach(p => println(p))
  }
}
