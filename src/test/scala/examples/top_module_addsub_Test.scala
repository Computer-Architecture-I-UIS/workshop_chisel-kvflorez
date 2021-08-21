package examples

import chisel3._
import chisel3.util._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

class top_module_addsub_Test(c: top_module_addsub) extends PeekPokeTester(c) {
  val inputs = List( (150, 50, 1), (150, 50, 0) )
  val outputs = List( 100, 200)

  //var i = 0
  for (i<- 0 until 2) {
  	poke(c.io.A, inputs(i)._1)
  	poke(c.io.B, inputs(i)._2)
  	poke(c.io.Sub, inputs(i)._3)
  	step(1)
  	expect(c.io.Sum, outputs(i))
  }

}

class top_module_addsub_Tester extends ChiselFlatSpec {
  behavior of "top_module_addsub"

  backends foreach {backend =>
    it should s"test the basic top_module_addsub circuit" in {
      Driver(() => new top_module_addsub, backend)((c) => new top_module_addsub_Test(c)) should be (true)
    }
  }
}
