
import scala.math._
import scala.collection.mutable.ArrayBuffer
object Test
 extends App {


val isPrime=(intValue:Int)=>((1 to (sqrt(intValue)).toInt).filter(intValue%_==0).length)<2
val asciiArray= new ArrayBuffer[Int]
asciiArray++=(65 to 90)
asciiArray++=(97 to 122)
val primeAsciiArray=(asciiArray.filter(isPrime(_))).toArray


var noOfTestCases=readInt
for(i<-(1 to noOfTestCases))
{
  var inputStrLen=readInt
  val inputStr=readLine
  val primedStr=for(c<-inputStr)  yield (nearestPrimeAscii(primeAsciiArray,c)).toChar
  println(primedStr.toString)
}



def nearestPrimeAscii(primeArray: Array[Int], key:Int)={
  @scala.annotation.tailrec
  def recur(low:Int, high:Int):Int={
   if(low>high){
      if (low==0)  primeArray(low)
      else if (high==primeArray.size-1) primeArray(high)
      else if(((primeArray(low)-key)<(key-primeArray(high)))) primeArray(low)
      else primeArray(high)
   }
    else{
      val mid=low+(high-low)/2
      primeArray(mid) match{
        case prime if (prime==key)=>key
        case prime if (prime<key)=>recur(mid+1,high)
        case _ =>recur(low,mid-1)
      }
    }
  }
recur(0,primeArray.size-1)
}
}
