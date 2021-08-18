// See LICENSE.txt for license details.
package examples

import chisel3._
import chisel3.util._

//A 16-bit adder with carry in and carry out
class top_module extends Module {
  val io = IO(new Bundle {
    val A    = Input(UInt(32.W))
    val B    = Input(UInt(32.W))
    val Sub  = Input(UInt(1.W))
    val Sum  = Output(UInt(32.W))
  })

  //XOR -> Opcion poco optima pero debe funcionar
  // val b_xor_sub32= io.B(32) ^ io.Sub //32 veces y se concatena
 
 
  //XOR
  val Sub32=Fill(32,Sub) //segun la cheatsheet esto funciona
  val b_xor_sub=io.B ^ Sub32

   //Adder for bits 0-15
  val Adder015 = Module(new add16())
  Adder015.io.A := io.A(15,0)
  Adder015.io.B := b_xor_sub(15,0)
  Adder015.io.Cin := io.Sub
  val s015 = Adder015.io.Sum
  
  //Adder for bits 16-31
  val Adder1631 = Module(new add16())
  Adder1631.io.A := io.A(31,16)
  Adder1631.io.B := b_xor_sub(31,16)
  Adder1631.io.Cin := Adder015.io.Cout
  io.Sum := Cat(Adder1631.io.Sum, s015).asUInt
}

