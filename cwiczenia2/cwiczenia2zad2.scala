object cwiczenia2zad2 {

  def main(): Unit = {

    // zadanie 2
    val kontoBankowe = new KontoBankowe(200)

    println(kontoBankowe.wplac(200))
    println(kontoBankowe.wyplac(200))
    println(kontoBankowe.wplac(-100))
    println(kontoBankowe.wyplac(1000))

    println(kontoBankowe.getStanKonta)
  }

  class KontoBankowe (stanPoczatkowy: BigDecimal) {

    private var stanKonta: BigDecimal = stanPoczatkowy

    def this() = this(0)

    def wplac(kwotaWplaty: BigDecimal): BigDecimal = {
      if(kwotaWplaty <= 0) {
        println("Nieprawidłowa kwota wpłaty")
      } else {
        stanKonta += kwotaWplaty
      }
      stanKonta
    }

    def wyplac(kwotaWyplaty: BigDecimal): BigDecimal = {
      if((stanKonta - kwotaWyplaty) < 0) {
        println("Brak środków na koncie")
      } else {
        stanKonta -= kwotaWyplaty
      }
      stanKonta
    }

    def getStanKonta: BigDecimal = {
      stanKonta
    }
  }
}