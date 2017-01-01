object Facotiral {
    def main(args: Array[String]) {
        val number=readInt
        val multiply=(a:Int,b:Int)=>a*b
        println((1 to number).reduceLeft(multiply))


    }
}

