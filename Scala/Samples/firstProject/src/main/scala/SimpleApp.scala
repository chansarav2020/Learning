import org.jsoup.Jsoup
import scala.collection.JavaConverters._
object SimpleApp extends App {
  val doc = Jsoup.connect("http://www.google.com").get()
  val newsHeadlines = doc.select(".title-link__title-text")
  newsHeadlines.asScala.map(_.text()).foreach(println)
   println("It works1")
}
