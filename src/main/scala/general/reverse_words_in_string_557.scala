package general

object reverse_words_in_string_557 {

  def main(args:Array[String]): Unit = {
     val s:String = "this is a test gotta do my best"
    println(reverseWords(s))
  }

  def reverseWords(s: String): String = {


    ((for(w<-s.split(" ")) yield w.reverse.mkString+" ").mkString).trim

  }
}
