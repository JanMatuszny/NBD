
object cwiczenia1 {
  val daysOfWeek = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")
  val productsMap = Map("cookies" -> 5.0, "coca-cola" -> 4.80, "beef" -> 10.0)
  val tuple3 = Tuple3(3, 4.0, "Test")
  val animals = Map("chicken" -> "bird", "tuna" -> "fish")
  val integerList = List(0, 1, 5, 5, 6, 0, 7, 8)
  val list = List(1, 2, 3, 5, 8, 12, 20)
  val realList = List(17.0, -8.0 ,1.0, -3.0, 0.0, -5.0, 12.0, -7.0)

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

    // zadanie 8
    println("Filter zeros: ")
    println(zeroFiltering(integerList))

    // zadanie 9
    println("Increment numbers: ")
    println(incrementByOne(list))

    // zadanie 10
    println("Absolute numbers: ")
    println(absList(realList))
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

  def zeroFiltering(list: List[Int]): List[Int] = {
    list.filter(p => p != 0)
  }

  def incrementByOne(list: List[Int]): List[Int] = {
    list.map(p => p+1)
  }

  def absList(list: List[Double]): List[Double] = {
    list.filter(p => p >= -5.0)
      .filter(p => p <= 12.0)
      .map(p => abs(p))
  }

  private def abs(d: Double): Double = {
    if(d < 0.0) -d
    else d
  }
}
