package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers.{status, _}

/**
  * Created by mikepratt on 06/06/17.
  */
class WelcomeControllerSpec extends PlaySpec with GuiceOneAppPerTest {
    "WelcomeController GET" should {
      "return a successful respinse" in {
        val controller = new WelcomeController
        val result = controller.welcome().apply(FakeRequest(GET, "/foo"))
        status(result) mustBe OK
      }

    }

}
