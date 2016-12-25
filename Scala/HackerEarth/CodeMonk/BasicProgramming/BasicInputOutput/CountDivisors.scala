
object CountDivisors {
    def main(args: Array[String]) {

    val Array(start,end,divisor) = readLine.split(" ").map(_.toInt)
    var countVar=0;
    val count=((countVar:Int,c:Int)=>if (c%divisor==0) countVar+1 else countVar)
    println( (start.to(end).toArray).foldLeft(0)(count))

//println(((start to end).filter(x=>x%k==0)).length)
    }
}
