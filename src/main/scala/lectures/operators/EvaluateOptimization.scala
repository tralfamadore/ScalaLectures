package lectures.operators

import lectures.functions.{Computation, CurriedComputation, Data, FunctionalComputation}

/**
  * В задачке из lectures.functions.Computations, мы реализовали
  * один и тот же метод 3-я разными способами
  *
  * Пришло время оценить на сколько разные имплементации
  * отличаются друг от друга по производительности
  *
  * Для этого, раскомментируйте код, выполните в циклах вызов 3-х имплементаций
  * Оцените разницу во времени выполнения и объясните ее происхожение: Thread.sleep !
  *
  */
object EvaluateOptimization extends App with Data {

  val startTimestamp = System.currentTimeMillis()

  println("___Computation.computation____")

  // ВЫПОЛНИТЬ В ЦИКЛЕ  ОТ 1 ДО 100 Computation.computation(
  for (i <- 1 to 100) {
    Computation.computation(Computation.filterData, Computation.dataArray)
    println("elapsed time in Computation.computation " + (System.currentTimeMillis() - startTimestamp))
  }


  println("_____CurriedComputation.partiallyAppliedCurriedFunction____")
  // ВЫПОЛНИТЬ В ЦИКЛЕ  ОТ 1 ДО 100 CurriedComputation.partiallyAppliedCurriedFunction(
  val curriedStartTime = System.currentTimeMillis()
  for (i <- 1 to 100) {
    CurriedComputation.partiallyAppliedCurriedFunction(Computation.dataArray)
    println("elapsed time " + (System.currentTimeMillis() - startTimestamp))
  }

  // ВЫПОЛНИТЬ В ЦИКЛЕ  ОТ 1 ДО 100 FunctionalComputation.filterApplied
  println("_____CurriedComputation.filterApplied_______")
  val functionalStartTime = System.currentTimeMillis()
  for (i <- 1 to 100) {
    FunctionalComputation.filterApplied(Computation.dataArray)
    println("elapsed time " + (System.currentTimeMillis() - startTimestamp))
  }

  // ВЫВЕСТИ РАЗНИЦУ В ПРОДОЛЖИТЕЛЬНОСТИ ВЫПОЛНЕНИЯ МЕЖДУ КАРРИРОВАННОЙ ВЕРСИЕЙ
  // И ФУНКЦИОНАЛЬНОЙ

  val diff = (functionalStartTime - curriedStartTime) - (System.currentTimeMillis() - functionalStartTime)

  println(s"Difference is about $diff milliseconds")
}

