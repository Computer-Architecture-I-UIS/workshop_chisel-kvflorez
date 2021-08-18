// See LICENSE.txt for license details.
package examples

import chisel3.iotesters.{Driver, TesterOptionsManager}
import utils.TutorialRunner

object Launcher {
  val examples = Map(
      "top_module_carry" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new top_module_carry(), manager) {
          (c) => new top_module_carry_Test(c)
        }
      }
  )
  def main(args: Array[String]): Unit = {
    TutorialRunner("examples", examples, args)
  }
}

