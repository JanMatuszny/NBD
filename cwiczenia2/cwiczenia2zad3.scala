object cwiczenia2zad3 {

  def main(): Unit = {

    // zadanie 3
    val andrzejJarzyna = new Person("Andrzej", "Jarzyna")
    val pawel = new Person("Pawel", "Test")
    val dorotaKowalska = new Person("Dorota", "Kowalska")

    println(greeting(andrzejJarzyna))
    println(greeting(pawel))
    println(greeting(dorotaKowalska))
  }

  case class Person(name: String, surname: String)

  def greeting(p: Person) = p match {
    case Person("Andrzej", "Jarzyna") => "Cześć Andrzej! Jak się masz?"
    case Person("Dorota", "Kowalska") => "Dzień dobry Doroto!"
    case Person(name, surname) => s"Witam Pana, Panie $surname"
  }
}