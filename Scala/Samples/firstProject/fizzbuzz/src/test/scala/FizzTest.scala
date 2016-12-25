import org.scalatest._
import Matchers._
class FizzTest extends FunSuite {
  test("fizzBuzz for 4 is 4") {
    Fizz.buzz(4) shouldEqual "4"
  }
}
