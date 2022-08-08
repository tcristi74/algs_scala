package general
/*Implement strStr().
Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
Input: haystack = "hello", needle = "ll"
Output: 2*/


object strstr {

  def main(args:Array[String]): Unit ={

    val haystack = "hello"
    val needle = "llo"
    val out = strStr(haystack,needle)
    println(out)
  }

  def strStr(haystack: String, needle: String): Int = {
    if (needle.length==0){
      0
    }
    else {
      var found = -1
      val needleLen = needle.length
      for(i<- 0 to haystack.length-needleLen if found  == -1){
        if  (haystack(i)==needle(0) && haystack.substring(i,i+needleLen)==needle){
          found=i
        }
      }
      found
    }
  }


























  def strStr_ini(haystack: String, needle: String): Int = {

    var start :Int = -1
    var nIndex :Int= 0
    var done  =false
    if (needle==""){
      done = true
      start = 0
    }
    for(i<-0 until haystack.length if !done) {
      if (haystack(i) == needle(nIndex)) {
        if (start == - 1) {
          start = i
        }
        nIndex+=1
        if (nIndex == needle.length){
          done = true
        }
      }
      else {
        start = -1
        nIndex= 0
      }
    }
    if  (nIndex==needle.length) start else -1
  }
}
