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
      "return a successful response, return some html and say hello and have a title" in {
        val controller = new WelcomeController
        val result = controller.welcome().apply(FakeRequest(GET, "/foo"))
        status(result) mustBe OK
        contentType(result) mustBe Some("text/html")
        contentAsString(result) must include ("<h1>Hello!</h1>")
        contentAsString(result) must include ("<title>Welcome!</title>")

      }
    "respond to the /welcome url" in {
        val request = FakeRequest(GET, "/welcome").withHeaders("Host" -> "localhost")
        val home = route(app, request).get
        status(home) mustBe OK
}
      "say hello and have a title" in {
        val controller = new WelcomeController
      }
    }


/*
    "return some html" in {
    val controller = new WelcomeController
    val result = controller.welcome().apply(FakeRequest(GET, "/foo"))
    contentType(result) mustBe Some("text/html")
}

    "say hello and have a title" in {
    val controller = new WelcomeController
    val result = controller.welcome().apply(FakeRequest(GET, "/foo"))
    contentAsString(result) must include ("<h1>Hello!</h1>")
    contentAsString(result) must include ("<title>Welcome!</title>")
  }*/
}
