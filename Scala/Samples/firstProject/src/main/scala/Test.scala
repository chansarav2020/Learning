
import scala.math._
import scala.collection.mutable.ArrayBuffer
object Test
 extends App {

        val noOfValues = readInt
        val valuesArray=readLine().split(' ').map(BigInt(_))
        var seq1,seq2,seq3,counter=BigInt(0)
        for(a<-valuesArray){
          counter+=1
          if(counter%3==1) seq1+=a
          if(counter%3==2) seq2+=a
          if(counter%3==0) seq3+=a

        }
        println (seq1+" " +seq2+ " " +seq3)



}
