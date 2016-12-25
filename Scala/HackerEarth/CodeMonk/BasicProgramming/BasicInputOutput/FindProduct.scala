import scala.math.pow
object FindProduct {
    def main(args: Array[String]) {

   val arraySize =readInt
        val arrayStr=readLine
        val array=arrayStr.split(' ').map(_.toInt)
        var product:BigInt=1;
        val divisor=pow(10,9).intValue+7
         for(x<- array) product=((product*x) %  divisor)
        //for((x,i) <- array.view.zipWithIndex) product=((product*x) %  divisor)

        println(product)

        /* println(io.Source.stdin.getLines().drop(1).mkString("").split(" ")
        .map(_.toLong).foldLeft(1L)((acc,n)=>acc*n%(divisor)))*/

    }
}
