package lectures.operators

/**
  * Проходит чемпионат по спортивному киданю костей
  * Сражются "Наши" и "Приезжие"
  *
  * Каждый член кманды бросил кубик и должен сравнить с каждым из команды соперника
  * Результаты должны быть записаны в ассоциативный массив в таком виде
  * val results: Array[String] = (("Artem vs John" -> 3), ("Artem vs James" -> 5))
  * При этом числовове значение должно быть получено как разность между результатами первого и второго игроков
  *
  * Когда составлен массив results, надо подсчитать чья взяла.
  * Если результат встречи >0 то finalResult увеличиваем на единицу
  * Если <0, уменьшаем
  *
  * В итоге надо напечатать
  * "Наша взяла",  если наших побед больше, т.е. finalResult > 0
  * "Продули", если победили приезжие
  * "Победила дружба" в случае ничьей
  *
  * Для решения задачи, раскомментируйте тело объекта Competition
  */

object Competition extends App {

  val locals = Map("Artem" -> 6, "Sergey" -> 5, "Anton" -> 2, "Vladimir" -> "2", "Alexander" -> 4l)
  val foreigners = Map[String, Int]("John" -> 3, "James" -> 1, "Tom" -> 2, "Dick" -> 5, "Eric" -> 6)

  //  val results = for (l <- locals;
  //                     ???) {
  //    val localName = l._1
  //    val localValue = l._2
  //    ???
  //  }

  //  var finalResult = 0
  //  for(r <- results) {
  //    if(???)finalResult = finalResult + 1
  //    else ???
  //  }

  print("Победила дружба")
}
