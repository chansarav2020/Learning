object RoyProfilePicture {
    def main(args: Array[String]) {

      var minDim=readInt
      var noOfTestCases=readInt

        var fbPromptFn=(l:Int,w:Int,h:Int )=>{
          if(w<l || h<l) println("UPLOAD ANOTHER")
          else if (w==h) println("ACCEPTED")
          else println("CROP IT")
      }
      for(i<- 1 to noOfTestCases){
       val Array(width,height) = readLine.split(" ").map(_.toInt)
        fbPromptFn(minDim,width,height)
      }



    }
}

