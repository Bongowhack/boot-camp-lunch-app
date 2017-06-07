package Services

import models.Sandwich
import com.google.inject.ImplementedBy
/**
  * Created by mikepratt on 07/06/17.
  */

class RealSandwichService extends SandwichService {
  //just an empty list
  override def sandwiches(): List[Sandwich] = List()
}

@ImplementedBy(classOf[RealSandwichService])
trait SandwichService {
  def sandwiches() : List[Sandwich]
}