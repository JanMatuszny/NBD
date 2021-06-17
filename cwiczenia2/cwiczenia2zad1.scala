object cwiczenia2zad1 {

  def main(): Unit = {

    // Zadanie 1
    println(workOrWeekend("Wtorek"))
    println(workOrWeekend("Sobota"))
    println(workOrWeekend("Niedzielelelela"))
  }

  def workOrWeekend(dayOfWeek: String): String = {
    dayOfWeek match {
      case "Poniedziałek" => "Praca"
      case "Wtorek" => "Praca"
      case "Środa" => "Praca"
      case "Czwartek" => "Praca"
      case "Piątek" => "Praca"
      case "Sobota" => "Weekend"
      case "Niedziela" => "Weekend"
      case _ => "Nie ma takiego dnia"
    }
  }
}