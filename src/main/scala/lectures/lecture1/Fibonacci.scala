package lectures.lecture1

/**
  * Created by s.popov2 on 20.05.2016.
  */
object Fibonacci extends App {

  // Task 2
  def fibs(num: Int) = {
    if(num == 1) 1
    if(num == 2 ) 2
    //fibs(num - 1) + fibs(num - 2)
  }

  print(fibs(9))

  // TASK 2.5
  def fibs2(num: Int): Int =
    if (num <= 2) Array(1, 1, 2)(num)
    else fibs2(num: Int, num, Array.empty[Int])(num)

  private def fibs2(num: Int, counter: Int, acc: Array[Int]): Array[Int] =  ???

  print(fibs2(16))



}


