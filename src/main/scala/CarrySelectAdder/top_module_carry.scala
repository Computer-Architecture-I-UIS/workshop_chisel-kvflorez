package examples

import chisel3._
import chisel3.util._

class top_module_carry extends Module {
  val io = IO(new Bundle {
    val A    = Input(UInt(32.W))
    val B    = Input(UInt(32.W))
    val Sum  = Output(UInt(32.W))
  })

  // Adder bits 0-15
  val Adder0 = Module(new add16())
  Adder0.io.A   := io.A(15,0)
  Adder0.io.B   := io.B(15,0)
  Adder0.io.Cin := 0.U
  val s0 = Adder0.io.Sum
  val sel= Adder0.io.Cout.asBool
  // Adder bits 16-31 input 0
  val Adder1 = Module(new add16())
  Adder1.io.A   := io.A(31,16)
  Adder1.io.B   := io.B(31,16)
  Adder1.io.Cin := 0.U
  val s1 = Adder1.io.Sum
  // Adder bits 16-31 input 1
  val Adder2 = Module(new add16())
  Adder2.io.A   := io.A(31,16)
  Adder2.io.B   := io.B(31,16)
  Adder2.io.Cin := 1.U
  val s2 = Adder2.io.Sum
  
  // Mux
  val OutMux = Mux(sel, s2, s1)
  io.Sum := Cat(OutMux, s0).asUInt
}
