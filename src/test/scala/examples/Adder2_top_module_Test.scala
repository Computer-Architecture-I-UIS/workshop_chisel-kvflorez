package examples

import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class Adder2_top_module_Test(c: top_module) extends PeekPokeTester(c) {
  val inputs = List( (50, 60), (20, 30) )
  val outputs = List( (110), (50))


  for (i<- 0 until 2) {
  	poke(c.io.A, inputs(i)._1)
  	poke(c.io.B, inputs(i)._2)
  	step(1)
  	expect(c.io.Sum, outputs(i))

  }

}

class Adder2_top_module_Tester extends ChiselFlatSpec {
  behavior of "top_module"

  backends foreach {backend =>
    it should s"test the basic top_module circuit" in {
      Driver(() => new top_module, backend)((c) => new Adder2_top_module_Test(c)) should be (true)
    }
  }
}
