package lectures.lecture1

/**
  * Допишите curriedComputation и functionalComputation, так, что бы часть вычислений
  * они позволяли выполнить те же действия , что и computation, но благодаря
  * разделяли эти дейсвия на 2 части
  *  1 часть - создание массива из строки
  *  2 часть  - применение фильтра к массиву с данными
  *
  */
object OptimizeByReference {

  def computation(filterData: String, dataProducer: Array[String]): Array[String] = {

    //EMULATE HEAVY LOAD
    Thread.sleep(500)
    //PRODUCE WORDS ARRAY FROM A STRING
    val filterArray = filterData.split(" ")

    //EMULATE HEAVY LOAD
    Thread.sleep(2000)
    // LEAVE ONLY EQUAL WORDS IN BOTH ARRAYS
    dataProducer.filter(dataItem => filterArray.contains(dataItem))

  }

  def curriedComputation(filterData: String)(dataProducer: Array[String]): Array[String] = ???

  val partiallyAppliedCurriedFunction = curriedComputation(???) _

  def functionalComputation(filterData: String): () => Nothing = ???

  val functionFilter = functionalComputation(???)

}

object OptimizeByReferenceApp extends App {

  import OptimizeByReference._

  def execute() = {

    val filterData = "Клара у Карала украла корралы, Карл у Клары украл кларнет"
    val dataArray = "Клара Цеткин обожала Карла Маркса".split(" ")

    val result1 = computation(filterData, dataArray)

    val result2 = partiallyAppliedCurriedFunction(???)

    val result3 = functionFilter()

  }

}



