package controllers
import javax.inject.Inject

import Services.SandwichService
import play.api.mvc.{Action, Controller}
/**
  * Created by mikepratt on 07/06/17.
  */
class SandwichController @Inject() (sandwichService: SandwichService) extends Controller {
  def sandwiches() = Action {
    val sandwiches = sandwichService.sandwiches
    Ok(views.html.sandwiches(sandwiches))
  }
}
