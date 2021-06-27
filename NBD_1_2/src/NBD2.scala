
object NBD2 {
  def main(args: Array[String]): Unit = {

    //Zadanie 1
    def matchDays(day: String) = {

      val dayTemp = day.toLowerCase()

      dayTemp match {
          case "poniedziałek" => "Praca"
          case "wtorek" => "Praca"
          case "środa" => "Praca"
          case "czwartek" => "Praca"
          case "piątek" => "Praca"
          case "sobota" => "Weekend"
          case "niedziela" => "Weekend"
          case _ => "Nie ma takiego dnia"

      }
    }
    val daysList = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela", "Krzesło" )

    for (day <- daysList) println("1 " + matchDays(day))

    //Zadanie 2

    class KontoBankowe(){

      private var _stanKonta : Int = 0

      def stanKonta = _stanKonta

      def wplata(pieniadze: Int) = {
        _stanKonta += pieniadze
      }

      def wyplata(pieniadze: Int) = {
        _stanKonta -= pieniadze
      }

      def this(stanKonta: Int){
        this()
        _stanKonta = stanKonta
      }

    }

    val kontoZbyszka = new KontoBankowe()
    val kontoKrzysia = new KontoBankowe(100)

    println("2 " + kontoZbyszka.stanKonta)
    println("2 " + kontoKrzysia.stanKonta)

    kontoZbyszka.wplata(30)
    kontoKrzysia.wyplata(30)

    println("2 " + kontoZbyszka.stanKonta)
    println("2 " + kontoKrzysia.stanKonta)

    //Zadanie 3

    class Osoba3(var imie: String, var nazwisko: String)

    val o1 = new Osoba3("Jan","Kowalski")
    val o2 = new Osoba3("Grzegorz","Brzęczyszczykiewicz")
    val o3 = new Osoba3("Mateusz", "Turek")

    def przywitanie(o: Osoba3) = {

      o.nazwisko match {
        case "Kowalski" => "Cześć " + o.imie + " " + o.nazwisko + ", popularne nazwisko huh?"
        case "Brzęczyszczykiewicz" => "Witaj " + o.imie + " Brzech... Brzen... Brzeczyskie... Co powiesz na to bym mówił Ci po imieniu?"
        case _ => "Witaj " + o.imie + " " + o.nazwisko

      }
    }

    println("3 " + przywitanie(o1))
    println("3 " + przywitanie(o2))
    println("3 " + przywitanie(o3))

    //Zadanie 4

    def zastosujTrzykrotnie(f:Int => Int, x:Int): Int = f(f(f(x)))

    def potega(x:Int) = x*x
    println("4 " + zastosujTrzykrotnie(potega, 2))

    //Zadanie 5

    class Osoba(val imie: String, val nazwisko: String, val podatek: Int)

    trait Pracownik extends Osoba {
      var pensja: Int = 0
      override val podatek: Int = 20

    }

    trait Student extends Osoba {
      override val podatek: Int = 0
    }

    trait Nauczyciel extends Pracownik {
      override val podatek: Int = 10
    }

    val o = new Osoba("Jan","Kowalski", 7) with Pracownik with Student

    println("5 " + o.podatek + " ostatni trait nadaje wartosc dla podatku")

    val o4 = new Osoba("Jan","Kowalski", 7) with Nauczyciel

    println("5 nauczyciel ma pole podatek " + o4.podatek + " oraz pensje z pracownika " + o4.pensja)

    val o5 = new Osoba("Jan","Kowalski", 7) with Nauczyciel with Pracownik

    println("5 " + o5.podatek + " pracownik nie nadpisal podatku nauczyciela, poniewaz nauczyciel juz w sobie zawiera pracownika")
  }
}
