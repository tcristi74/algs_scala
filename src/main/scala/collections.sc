//1MAPS


import scala.collection.mutable.ArrayBuffer
import scala.collection.{SortedSet, mutable}

val m1:mutable.Map[String,Int] = mutable.Map("a"->60,"b"->70,"c"->56)

m1.maxBy(p=>p._2)
m1.groupBy(p=>p._2)(70)



m1.addOne("r" ->555)
m1.update("a",666)

m1 += ("t" ->5555)

val x:Option[Int] = m1.get("rrrr")
x.getOrElse(-5)

x match {
  case Some(s) =>s
  case  None =>"?"

}
m1.update("geoge",555)
m1.update("geoge",666)
m1("rr")=44
m1("rr")

m1.get("rredf")==None
m1.getOrElse("eee",666)
m1.updateWith("c") {
  case Some(n) =>
    val t = n - 10
    if (t == 0) None else Some(t)
  case None => Some(1)
}


var im:scala.collection.immutable.Map[String,Int] = Map("a"->60,"b"->70,"c"->56)
var m:Map[String,Int] = Map("a"->60,"b"->70,"c"->56)
val im2:scala.collection.immutable.Map[String,Int] = Map("a"->60,"b"->70,"c"->56)
im += ("d"->33)
m
//remove element
im-="d"
for ((k,v)<-im){
  println(k,v)
}

im2 +("rr"->566)

//HEAP
var ss:SortedSet[Int] = SortedSet(4,6,3,285)(Ordering[Int].reverse)
ss+=44
ss.firstKey
ss -=ss.firstKey
ss


val a = ss.slice(0,2).reduce((a,b) => a+b )

var ar=Array(1,2,1)

ar(2) = 33
ar



val arr = Array("scooby", "dooby", "doo")
arr(0) = "scrappy"
arr(1) = "dappy"
//if we want to insert
val ar1 :ArrayBuffer[Int]  = ArrayBuffer(4)

ar1.insert(0,55)
ar1.append(33)
ar1+=34

var ar2 :ArrayBuffer[Int]  = ArrayBuffer(4)
ar2 = 44+:ar2 :+77
ar2 +=222
ar2.toArray
ar2.splitAt(1)

//List
var l :List[Int] = List.empty
l :+=4
l

l =l :::  List(1,2,3)

l

l :::= List(6)
l
l= l :+ 7 :+ 8
l :: List(2,3)





