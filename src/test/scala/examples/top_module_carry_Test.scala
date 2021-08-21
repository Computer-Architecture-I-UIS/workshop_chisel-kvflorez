package examples

import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class top_module_carry_Test(c: top_module_carry) extends PeekPokeTester(c) {
  val inputs = List( (50, 60), (20, 30) )
  val outputs = List(110, 50)

  //var i = 0
  for (i<- 0 until 2) {
  	poke(c.io.A, inputs(i)._1)
  	poke(c.io.B, inputs(i)._2)
  	step(1)
  	expect(c.io.Sum, outputs(i))
  }

}

class top_module_carry_Tester extends ChiselFlatSpec {
  behavior of "top_module_carry"

  backends foreach {backend =>
    it should s"test the basic top_module_carry circuit" in {
      Driver(() => new top_module_carry, backend)((c) => new top_module_carry_Test(c)) should be (true)
    }
  }
}
