package controllers
import javax.inject.Inject
//default execution context https://www.playframework.com/documentation/2.5.x/ScalaAsync
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import Services.SandwichService
import play.api.mvc.{Action, Controller}
/**
  * Created by mikepratt on 07/06/17.
  */
class SandwichController @Inject()(sandwichService: SandwichService) extends Controller {
  def sandwiches() = Action.async {
    val sandwiches = sandwichService.sandwiches
    sandwiches.map { listOfSarnies =>

      Ok(views.html.sandwiches(listOfSarnies))
    }
  }
}
