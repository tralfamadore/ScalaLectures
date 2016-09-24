package lectures.oop


/**
  * BSTImpl - это бинарное дерево поиска, содержащее только значения типа Int
  *
  * * Оно обладает следующими свойствами:
  * * * * * левое поддерево содержит значения, меньшие значения родителя
  * * * * * правое поддерево содержит значения, большие значения родителя
  * * * * * значения, уже присутствующие в дереве, в него не добавляются
  * * * * * пустые значения(null) не допускаются
  *
  * * Завершите реализацию методов кейс класс BSTImpl.
  * * * * * Трейт BST и BSTImpl разрешается расширять любым образом
  * * * * * Изменять сигнатуры классов и методов, данные в  условии, нельзя
  * * * * * Постарайтесь не использовать var и мутабильные коллекции
  * * * * * В задаче про распечатку дерева, нужно раскомментировать и реализовать метод toString()
  *
  * * Для этой структуры нужно реализовать генератор узлов.
  * * Генератор
  * * * * * должен создавать дерево, содержащее nodesCount узлов.
  * * * * * не должен использовать переменные или мутабильные структуры.
  *
  */
trait BST {
  val value: Int
  val left: Option[BST]
  val right: Option[BST]

  def add(newValue: Int): BST

  def find(value: Int): Option[BST]
}

case class BSTImpl(value: Int,
                   left: Option[BSTImpl] = None,
                   right: Option[BSTImpl] = None) extends BST {

  def add(newValue: Int): BST = {
    def add(node: BSTImpl, newValue: Int): BSTImpl = {
      val next = BSTImpl(newValue, None, None)
      if (node.value > newValue) {
        node.left match {
          case None => BSTImpl(node.value, Some(next), node.right)
          case Some(n: BSTImpl) => BSTImpl(node.value, Some(add(n, newValue)), node.right)
        }
      } else if (node.value < newValue) {
        node.right match  {
          case None => BSTImpl(node.value, node.left, Some(next))
          case Some(n: BSTImpl) => BSTImpl(node.value, node.left, Some(add(n, newValue)))
        }
      } else {
        node
      }
    }

    add(this, newValue)
  }

  def find(value: Int): Option[BST] = {
    def find(value: Int, node: Option[BST]): Option[BST] = node match {
      case Some(n: BST) => n.find(value)
    }
    value match {
      case x: Int if x == this.value => Some(this)
      case x: Int if x < this.value => find(x, left)
      case x: Int if x > this.value => find(x, right)
      case _ => None
    }
  }

  // override def toString() = ???

}

object TreeTest extends App {

  val sc = new java.util.Scanner(System.in)
  val maxValue = 110000
  val nodesCount = sc.nextInt()

  val markerItem = (Math.random() * maxValue).toInt
  val markerItem2 = (Math.random() * maxValue).toInt
  val markerItem3 = (Math.random() * maxValue).toInt

  // Generate huge tree
  val root: BST = BSTImpl(maxValue / 2)
//  val tree: BST = ??? // generator goes here

  // add marker items
  val testTree = root.add(markerItem).add(markerItem2).add(markerItem3)

  // check that search is correct
  require(testTree.find(markerItem).isDefined)
  require(testTree.find(markerItem).isDefined)
  require(testTree.find(markerItem).isDefined)

  println(testTree)
}