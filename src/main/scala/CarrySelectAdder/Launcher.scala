// See LICENSE.txt for license details.
package examples

import chisel3.iotesters.{Driver, TesterOptionsManager}
import utils.TutorialRunner

object Launcher {
  val examples = Map(
      "Csel" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new Csel, manager) {
          (c) => new CselTests(c)
        }
      }
  )
  def main(args: Array[String]): Unit = {
    TutorialRunner("examples", examples, args)
  }
}

