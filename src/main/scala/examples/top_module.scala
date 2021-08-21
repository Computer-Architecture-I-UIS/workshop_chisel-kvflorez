// See LICENSE.txt for license details.
package examples

import chisel3._
import chisel3.util._

//A 16-bit adder with carry in and carry out
class top_module extends Module {
  val io = IO(new Bundle {
    val A    = Input(UInt(32.W))
    val B    = Input(UInt(32.W))
    val Sum  = Output(UInt(32.W))
  })

   //Adder for bits 0-15
  val Adder015 = Module(new add16())
  Adder015.io.A := io.A(15,0)
  Adder015.io.B := io.B(15,0)
  Adder015.io.Cin := 0.U
  val s015 = Adder015.io.Sum
  
  //Adder for bits 16-31
  val Adder1631 = Module(new add16())
  Adder1631.io.A := io.A(31,16)
  Adder1631.io.B := io.B(31,16)
  Adder1631.io.Cin := 0.U
  io.Sum := Cat(Adder1631.io.Sum, s015).asUInt

}

