package lectures.types

/**
  * Программа должна удвоить все нечетные члены List и потом просуммировать,
  * сохранив результат в 'result'
  *
  * Ваша задача:
  * Раскоментируйте код
  * Исправьте тело метода mapper так, чтобы программа скопмилировалась
  */
object FixCompile extends App {

  def someFunc(prm1: Int, prm2: String): Option[Int] = ???

  val mapper = (i: Int) => if (i % 2 != 0) i * 2 else i

  val result = List(1, 2, 3, 4, 5, 6, 7, 8, 9).map {
    mapper
  }.foldLeft(0) { (acc, v) => acc + v }

  println(result)

  val numb = try {
    someFunc(2, "s")
  } catch {
    case e: NotImplementedError => println("not implemented!")
    case _ => println("some error occur")
  }
}

