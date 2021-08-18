// See LICENSE.txt for license details.
package examples

import chisel3._
import chisel3.util._

//A 16-bit adder with carry in and carry out
class add16 extends Module {
  val io = IO(new Bundle {
    val A    = Input(UInt(16.W))
    val B    = Input(UInt(16.W))
    val Cin  = Input(UInt(1.W))
    val Sum  = Output(UInt(16.W))
    val Cout = Output(UInt(1.W))
  })
  //Adder for bit 0
  val Adder0 = Module(new add1())
  Adder0.io.a := io.A(0)
  Adder0.io.b := io.B(0)
  Adder0.io.cin := io.Cin
  val s0 = Adder0.io.sum
  //Adder for bit 1
  val Adder1 = Module(new add1())
  Adder1.io.a := io.A(1)
  Adder1.io.b := io.B(1)
  Adder1.io.cin := Adder0.io.cout
  val s1 = Cat(Adder1.io.sum, s0)
  //Adder for bit 2
  val Adder2 = Module(new add1())
  Adder2.io.a := io.A(2)
  Adder2.io.b := io.B(2)
  Adder2.io.cin := Adder1.io.cout
  val s2 = Cat(Adder2.io.sum, s1)
  //Adder for bit 3
  val Adder3 = Module(new add1())
  Adder3.io.a := io.A(3)
  Adder3.io.b := io.B(3)
  Adder3.io.cin := Adder2.io.cout
  val s3 = Cat(Adder3.io.sum, s2)
  //Adder for bit 4
  val Adder4 = Module(new add1())
  Adder4.io.a := io.A(4)
  Adder4.io.b := io.B(4)
  Adder4.io.cin := Adder3.io.cout
  val s4 = Cat(Adder4.io.sum, s3)
  //Adder for bit 5
  val Adder5 = Module(new add1())
  Adder5.io.a := io.A(5)
  Adder5.io.b := io.B(5)
  Adder5.io.cin := Adder4.io.cout
  val s5 = Cat(Adder5.io.sum, s4)
  //Adder for bit 6
  val Adder6 = Module(new add1())
  Adder6.io.a := io.A(6)
  Adder6.io.b := io.B(6)
  Adder6.io.cin := Adder5.io.cout
  val s6 = Cat(Adder6.io.sum, s5)
  //Adder for bit 7
  val Adder7 = Module(new add1())
  Adder7.io.a := io.A(7)
  Adder7.io.b := io.B(7)
  Adder7.io.cin := Adder6.io.cout
  val s7 = Cat(Adder7.io.sum, s6)
  //Adder for bit 8
  val Adder8 = Module(new add1())
  Adder8.io.a := io.A(8)
  Adder8.io.b := io.B(8)
  Adder8.io.cin := Adder7.io.cout
  val s8 = Cat(Adder8.io.sum, s7)
  //Adder for bit 9
  val Adder9 = Module(new add1())
  Adder9.io.a := io.A(9)
  Adder9.io.b := io.B(9)
  Adder9.io.cin := Adder8.io.cout
  val s9 = Cat(Adder9.io.sum, s8)
  //Adder for bit 10
  val Adder10 = Module(new add1())
  Adder10.io.a := io.A(10)
  Adder10.io.b := io.B(10)
  Adder10.io.cin := Adder9.io.cout
  val s10 = Cat(Adder10.io.sum, s9)
  //Adder for bit 11
  val Adder11 = Module(new add1())
  Adder11.io.a := io.A(11)
  Adder11.io.b := io.B(11)
  Adder11.io.cin := Adder10.io.cout
  val s11 = Cat(Adder11.io.sum, s10)
  //Adder for bit 12
  val Adder12 = Module(new add1())
  Adder12.io.a := io.A(12)
  Adder12.io.b := io.B(12)
  Adder12.io.cin := Adder11.io.cout
  val s12 = Cat(Adder12.io.sum, s11)
  //Adder for bit 13
  val Adder13 = Module(new add1())
  Adder13.io.a := io.A(13)
  Adder13.io.b := io.B(13)
  Adder13.io.cin := Adder12.io.cout
  val s13 = Cat(Adder13.io.sum, s12)
   //Adder for bit 14
  val Adder14 = Module(new add1())
  Adder14.io.a := io.A(14)
  Adder14.io.b := io.B(14)
  Adder14.io.cin := Adder13.io.cout
  val s14 = Cat(Adder14.io.sum, s13)
  //Adder for bit 15
  val Adder15 = Module(new add1())
  Adder15.io.a := io.A(15)
  Adder15.io.b := io.B(15)
  Adder15.io.cin := Adder14.io.cout
  io.Sum := Cat(Adder15.io.sum, s14).asUInt
  io.Cout := Adder15.io.cout
  }
