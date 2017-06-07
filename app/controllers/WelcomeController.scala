package controllers
import javax.inject.Inject

import Services.GreetingService
import play.api.mvc.{Action, Controller}
/**
  * Created by mikepratt on 06/06/17.
  */
class WelcomeController @Inject() (greeter: GreetingService) extends Controller{
  def welcome() = Action {
    val greeting = greeter.greeting
    Ok(views.html.welcome(greeting))
  }


}
