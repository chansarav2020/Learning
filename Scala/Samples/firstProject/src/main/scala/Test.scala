
import scala.math.pow
object Test
 extends App {

val Array(start,end,divisor) = readLine.split(" ").map(_.toInt)


    var countVar=0;
    val count=((countVar:Int,c:Int)=>if (c%divisor==0) countVar+1 else countVar)
    //for(s->start.to(end).toArray) if(s%divisor==0)
   println( (start.to(end).toArray).foldLeft(0)(count))

}
