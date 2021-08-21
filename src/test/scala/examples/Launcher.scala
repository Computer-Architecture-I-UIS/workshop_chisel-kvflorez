// See LICENSE.txt for license details.
package examples

import chisel3.iotesters.{Driver, TesterOptionsManager}
import utils.TutorialRunner

object Launcher {
  val examples = Map(
      "top_module" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new top_module(), manager) {
          (c) => new Adder2_top_module_Test(c)
        }
      },
      "top_module_carry" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new top_module_carry(), manager) {
          (c) => new top_module_carry_Test(c)
        }
      },
      "top_module_addsub" -> { (manager: TesterOptionsManager) =>
        Driver.execute(() => new top_module_addsub(), manager) {
          (c) => new top_module_addsub_Test(c)
        }
      }
  )
  def main(args: Array[String]): Unit = {
    TutorialRunner("examples", examples, args)
  }
}

