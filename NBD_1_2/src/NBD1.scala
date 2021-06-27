import scala.annotation.tailrec
import scala.collection.mutable.Map

object NBD1 {
  def main(args: Array[String]) {

    //Zadanie 1
    def myConcat(list: List[String]) = {
      var stringFor: String = ""

      for(x <- list){
        stringFor += x + ","
      };

      if(stringFor.endsWith(",")) stringFor.dropRight(1)
    }

    def myConcatOnlyP(list: List[String]) = {
      var stringFor: String = ""

      for(x <- list if x.startsWith("P") ){
        stringFor += x + ","
      };

      if(stringFor.endsWith(",")) stringFor.dropRight(1)
    }

    def myConcatWhile(list: List[String]) = {

      var stringWhile: String = ""

      var i = 0
      val size = list.size

      while(i < size){
        stringWhile += list(i) + ","
        i += 1
      };

      if(stringWhile.endsWith(",")) stringWhile.dropRight(1)
    }

    val daysList = List("Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela" )

    println("1.a " + myConcat(daysList));
    println("1.b " + myConcatOnlyP(daysList));
    println("1.c " + myConcatWhile(daysList));

    //Zadanie 2

    def myConcatRe(list: List[String]): String = {
      if(list.isEmpty){
        ""
      } else {
        list.head + "," + myConcatRe(list.tail)
      }
    }

    def myConcatReInv(list: List[String]):String = {

      if(list.isEmpty){
        ""
      } else {
        myConcatReInv(list.tail) + list.head + ","
      }

    }

    println("2.a " + myConcatRe(daysList));
    println("2.b " + myConcatReInv(daysList));

    //Zadanie 3

    def myConcatReTa(list: List[String]) = {
      @tailrec
      def iter(list: List[String], result: String): String ={
        if(list.isEmpty){
          result
        } else {
          iter(list.tail, result + list.head + ",")
        }
      }
      iter(list, "")

    }

    println("3 " + myConcatReTa(daysList));

    //Zadanie 4

    def myConcatFoldL(list: List[String]) = {
      list.foldLeft("")(_ + _ + ",")
    }

    def myConcatFoldR(list: List[String]) = {
      list.foldRight("")(_ + "," + _)
    }

    def myConcatFoldLP(list: List[String]) = {
      list.foldLeft("") {
        (x, y) => {
          if(y.startsWith("P")){
            x + y + ","
          } else {
            x
          }

        }
      }
    }

    println("4.a " + myConcatFoldL(daysList));
    println("4.b " + myConcatFoldR(daysList));
    println("4.c " + myConcatFoldLP(daysList));

    //Zadanie 5

    val prices = Map("smartfon" -> 3000, "laptop" -> 9000)

    val pricesTransformed = prices map {case (key, value) => (key, value * 0.9)}

    println("5 " + pricesTransformed)

    //Zadanie 6

    def myTuple(x:(String,Int,Int)): Unit = {
      x match {
        case (str, i, i1) => {
          println(str)
          println(i)
          println(i1)
        }
      }
    }

    println("6:")

    val t0 = ("abc", 0, 1)

    myTuple(t0)

    //Zadanie 7

    val testOption:Option[Int] = Some(999)

    println("7 " + testOption)

    //Zadanie 8

    def removeZ(list: List[Int]): List[Int] = {
      if(list.isEmpty){
        List()
      } else {
        if(list.head != 0){
          List(list.head) ++ removeZ(list.tail)
        } else {
          removeZ(list.tail)
        }

      }
    }

    val list8 = List(1,0,2,0,3)

    println("8 " + removeZ(list8))

    //Zadanie 9

    def listIncrement(list:List[Int]): List[Int] ={
      list map (_ + 1)
    }

    val list9 = List(1,2,3)

    println("9 " + listIncrement(list9))

    //Zadanie 10

    def listfilter(list:List[Int]): List[Int] ={
      (list filter( x => x >= -5 && x <= 12)).map(_.abs)
    }

    val list10 = List(-6,-2,1,3,13)

    println("10 " + listfilter(list10))

  }
}

