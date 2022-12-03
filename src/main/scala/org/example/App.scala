package org.example
import scala.collection.mutable.MutableList
import scala.math.rint


/**
 * @author ${user.name}
 */
object App {

  //task a
  def salary(revenue: Double, bonus: Double, nutrition: Double): Double = (revenue * (bonus/100 + 1) + nutrition)*0.87/12

  //task b
  def deviation(revenue: Double, bonus: Double, nutrition: Double, salary_list: MutableList[Double]) = {
    val s = salary(revenue, bonus, nutrition)
    val mean = (salary_list.sum + s) / (salary_list.size + 1)
    println(mean)
    (1-mean/s) * 100
  }

  def main(args : Array[String]) {

    //task a
    val hello: String = "Hello World!"
    println(hello)

    val rev = hello.reverse
    println(rev)

    val lower = hello.toLowerCase()
    println(lower)

    val del = (s: String, n: Int) => s.dropRight(s.length - n + 1) + s.drop(n)
    println(del(hello,6))

    val gb = del(hello, 12).concat(" and goodbye python!")
    println(gb)

    //task b
    val salary_list: MutableList[Double] = MutableList(100, 150, 200, 80, 120, 75)
    val s = salary(1000, 15, 10)

    //task c
    val d = deviation(1000, 15, 10, salary_list)

    //task d
    salary_list += rint(((1 - d/100)*s)*100)/100
    val min = salary_list.min
    val max = salary_list.max
    println(salary_list)
    println(min,max)

    //task e
    salary_list ++= MutableList(350, 90)
    val sorted_salary_list = salary_list.sorted

    //task f
    val add = (l:MutableList[Double], n:Double) =>
      l.reverse.dropWhile(x => x > n).reverse += n ++= l.dropWhile((x => x < n)) : MutableList[Double]
    val new_salary_list = add(sorted_salary_list, 130)
    println(new_salary_list)

    //task g
    val range_numbers = (l: MutableList[Double], min_range:Double, max_range:Double ) => {
      val sl = l.dropWhile((x => x < min_range)).reverse.dropWhile(x => x > max_range).reverse
      val res: MutableList[Int] = MutableList()
      for (elem <- sl) res += l.indexOf(elem)
      res
    }
    val middle_salary_list = range_numbers(new_salary_list, 120, 200)
    println(middle_salary_list)

    //task h
    val final_salary_list: MutableList[Double] = MutableList()
    for (elem <- new_salary_list) final_salary_list += elem*1.07
    print(final_salary_list)
  }

}
