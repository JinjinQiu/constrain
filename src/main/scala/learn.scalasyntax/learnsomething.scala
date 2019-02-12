package learn.scalasyntax

object learnsomething {

  def main(args: Array[String]): Unit = {
    println("print the sum = " + getSum(2, 3, 4, 5, 6, 7, 8, 9))
    //println("Factorical of 3 = "+ factorial(3))
    val array = Array(1,2,3,4,5,6,7,8,9)
    //val timess = tryyield(array)
    //val even = for(num <- timess if num %2 ==0)yield num
   // even.foreach(println)
    //multable
    //sort
    //tuples

   // matchtest

   //println(math(10,20,30,(x,y)=>x min y))
    //println(math(10,20,30,_+_))

   // partial
    //currying

    //testmap

    reduce
  }

  def getSum(args: Int*): Int = {
    var sum = 0
    for (num <- args) {
      sum += num
    }
    sum
  }

  def factorial(num: BigInt): BigInt = {
    if(num <= 1){
      return 1
    }else{
      num * factorial(num-1)
    }
  }

  def tryyield(array: Array[Int]):Array[Int] = {
    val times2 = for(num <- array) yield num *2
    times2.foreach(println)
    times2
  }

  def multable :Unit = {
    val mult = Array.ofDim[Int](10,10)
    for(i <- 0 to 9){
      for(j <- 0 to 9){
        mult(i)(j) = i* j
      }
    }

    for(i <- 0 to 9){
      for(j <- 0 to 9){
        printf("%d : %d = %d\n", i, i, mult(i)(j))
      }
    }
  }

  def sort: Unit = {
    val array = Array(1,2,3,4,5,6,7,8,9)
    array.sortWith(_>_).foreach(println)
    println(array.sortWith(_>_).deep.mkString(", "))
  }

  def map: Unit = {
    val employ = Map("manager" -> "hill","secretary" -> "helen" )
  }

  def tuples: Unit = {
    var tulpes = (102, "Nina", 100000.25)
    printf(" %s has $%.2f\n", tulpes._2, tulpes._3)
  }

  def matchtest: Unit = {
    val age = 20
    val result = age match {
      case 20 => age
      case _ => 18
    }
    println("result : " + result)
    val i =2
    i match {
      case 1|3|5|7 => println("ODD num")
      case 2|4|6 => println("even")
    }
  }
  def math(x: Double, y: Double, z:Double, f:(Double, Double) => Double): Double = {
    f(f(x,y),z)
  }
  def partial():Unit={
    val sum = (a:Int, b: Int, c: Int) => a+b+c
    val func = sum(10,20, _:Int)
    println(func(30))
  }

  def currying(): Unit = {
    def add2(x:Int) = (y: Int) => x+y
    val sum40 = add2(40)
    println(sum40(10))
    println(add2(1)(2))
    def add3(x:Int)(y:Int) = x+y
    val sum50 = add3(50)_
    println(sum50(10))
    println(add3(3)(4))
  }


  def testmap():Unit = {
    val lst = List(1,2,3,4,5,6,7,8)
    val lst2 = List(9,10,11,12)
    val lst3 = List(lst, lst2)
    val mymap = Map(1 -> "hi", 2 -> "Hello", 3 ->"nihao")
    println(lst.map(_*2))
    println(lst.map(x => x*4))
    println(lst.map(x => "hi"* x))
    println(mymap.mapValues(x => "say " + x))

    println(lst3.flatten)
    println(lst.map(x => List(x, x+1)))
    println(lst.flatMap(x =>List(x, x+1)))
    println(lst.filter(x => x%2 ==0))
  } 

  //reduce fold and scan

  def reduce():Unit = {
    val lst1 = List(1,2,3,4,5,6,7,8)
    val lst2 = List("hi", "Hello", "Nihao")

    println(lst1.reduceLeft(_+_))
    println(lst1.reduceRight(_+_))

    println(lst1.reduceLeft((x,y) => {println(x + "," + y);x+y}))
    println(lst1.reduceRight((x,y) => {println(x + "," + y);x+y}))

    println(lst1.foldLeft(100)(_+_))
    println(lst1.foldRight(100)(_+_))

    println(lst1.scanLeft(100)(_+_))
    println(lst1.scanRight(100)(_+_))


  }


}
