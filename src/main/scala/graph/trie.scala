package graph

import scala.annotation.tailrec
import scala.collection.mutable

class TrieNode()  {
  val children: mutable.HashMap[Char, TrieNode] =  new mutable.HashMap()
  var counter :Int = 0
  var isWord : Boolean = false
}

sealed trait Trie  {

  def append(word : String) :Boolean
  //def findByPrefix(prefix: String): scala.collection.Seq[String]
  def wordCount(word: String): Int
//  def remove(word : String) : Boolean

}

class MyTrie extends Trie {

  val ll: scala.collection.mutable.HashMap[Char, TrieNode] = mutable.HashMap.empty

  override def append(words: String): Boolean = {
    val str: IndexedSeq[Char] = for {wd <- words
                                     val delim: Boolean = wd == ' ' || wd == ',' || wd == '.'
                                     }
    yield if (delim) ' ' else wd

    ll += str.head -> (new TrieNode())
    addKeys(ll(str.head), str.tail)
    true

  }

  override def wordCount(word: String): Int = {
    if (word.isEmpty || ll.isEmpty || !ll.keys.exists(_==word.head)) 0
    else {
      findKey(ll(word.head),word.tail)
    }
  }


  private def findKey(node : TrieNode,str: String):Int = {
    if (str.isEmpty)  {
      if (node.isWord) node.counter else 0
    }
    else
      {
        if ( !node.children.keys.exists(_==str.head)) 0
        else
          {
            findKey(node.children(str.head),str.tail)
          }
      }
  }

  @tailrec
  private def addKeys(node: TrieNode, str: IndexedSeq[Char]): Unit = {
    if (!str.isEmpty) {
      if (str.head == ' ') {
        //modify the node
        if (node!=null) {
          node.isWord = true
          node.counter += 1
        }

        // go back to beginning
        addKeys(null,str.tail)
      }
      else {
        if (node==null){
          if (!ll.keys.exists(_==str.head))
            ll += str.head -> new TrieNode()
          addKeys(ll(str.head), str.tail)
        }
        else {
          if (node.children.keys.exists(_ == str.head)) {
            addKeys(node.children(str.head), str.tail)
          } else {
            node.children += str.head -> new TrieNode()
            addKeys(node.children(str.head), str.tail)
          }
        }
      }
    }
  }

}

object Trie {

  def main(args: Array[String]): Unit = {
    require(args.length == 1)
    println("start trie")

    val mytext = "This three, tree to be a tool window when started to go ski. them theirs to  be Great day."
    val mytrie = new MyTrie()
    mytrie.append(mytext)
    val testWord :String = "to"
    val wordCounter :Int = mytrie.wordCount(testWord)
    println(s"${testWord} status: ${wordCounter}")
  }
}