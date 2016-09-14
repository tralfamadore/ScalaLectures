package lectures.collections

/**
  * Постарайтесь не использовать мутабильные коллекции и var
  * Подробнее о сортировке можно подсмотреть здесь - https://en.wikipedia.org/wiki/Merge_sort
  *
  *
  */
object MergeSortImpl extends App {

  def mergeSort(data: Seq[Int]): Seq[Int] = {

    def merge(left: Seq[Int], right: Seq[Int]): Seq[Int] = {
      var leftIndex = 0
      var rightIndex = 0
      var result: Seq[Int] = Seq()
      while (leftIndex <= left.length - 1 && rightIndex <= right.length - 1) {
        val leftValue = left(leftIndex)
        val rightValue = right(rightIndex)

        if (leftValue <= rightValue) {
          result = result ++ Seq(leftValue)
          leftIndex += 1
        } else {
          result = result ++ Seq(rightValue)
          rightIndex += 1
        }
      }
      while (leftIndex <= left.length - 1) {
        result = result ++ Seq(left(leftIndex))
        leftIndex += 1
      }
      while (rightIndex <= right.length - 1) {
        result = result ++ Seq(right(rightIndex))
        rightIndex += 1
      }

      result
    }

    if (data.length <= 1) {
      data
    } else {
      val (left, right) = data.splitAt(data.length / 2)
      merge(mergeSort(left), mergeSort(right))
    }

  }

  require(mergeSort(List(1, 3, 234, 2, 23, 42, 22, 16, 14, 25)) == List(1, 2, 3, 14, 16, 22, 23, 25, 42, 234))
  require(mergeSort(List(56, 200, 150, 101, 20, 24)) == List(20, 24, 56, 101, 150, 200))
  require(mergeSort(List(1, 3)) == List(1, 3))
  require(mergeSort(List(3, 1)) == List(1, 3))
  require(mergeSort(List(3)) == List(3))
  require(mergeSort(List()) == List())

}
