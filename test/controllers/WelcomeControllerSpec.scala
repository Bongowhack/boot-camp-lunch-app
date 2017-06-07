package controllers

import Services.GreetingService
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.FakeRequest
import play.api.test.Helpers.{status, _}

/**
  * Created by mikepratt on 06/06/17.
  */
class WelcomeControllerSpec extends PlaySpec with GuiceOneAppPerTest {
  "WelcomeController GET" should {
    "return a successful response, return some html and have a title" in {
      val controller = new WelcomeController(FakeMorningGreeter)
      val result = controller.welcome().apply(FakeRequest(GET, "/foo"))
      status(result) mustBe OK
      contentType(result) mustBe Some("text/html")
      //        contentAsString(result) must include ("<h1>Hello!</h1>")
      contentAsString(result) must include("<title>Welcome!</title>")

    }
    "respond to the /welcome url" in {
      val request = FakeRequest(GET, "/welcome").withHeaders("Host" -> "localhost")
      val home = route(app, request).get
      status(home) mustBe OK
    }
    "say hello and have a title" in {
      val controller = new WelcomeController(FakeMorningGreeter)
    }

    "say good morning and have a title" in {
      val controller = new WelcomeController(FakeMorningGreeter)
      val result = controller.welcome().apply(FakeRequest(GET, "/foo"))
      contentAsString(result) must include("<h1>Good morning!</h1>")
      contentAsString(result) must include("<title>Welcome!</title>")
    }

    "say good afternoon and have a title" in {
      val controller = new WelcomeController(FakeAftertnoonGreeter)
      val result = controller.welcome().apply(FakeRequest(GET, "/foo"))
      contentAsString(result) must include("<h1>Good afternoon!</h1>")
      contentAsString(result) must include("<title>Welcome!</title>")
    }


    object FakeMorningGreeter extends GreetingService {
      override def greeting: String = "Good morning!"
    }

    object FakeAftertnoonGreeter extends GreetingService {
      override def greeting: String = "Good afternoon!"
    }

    class WelcomeControllerSpec extends PlaySpec with GuiceOneAppPerTest {
      "WelcomeController GET" should {
        "return a successful response" in {
          val controller = new WelcomeController(FakeMorningGreeter)
          val result = controller.welcome().apply(FakeRequest(GET, "/foo"))
          status(result) mustBe OK
        }

      }

    }
  }
}