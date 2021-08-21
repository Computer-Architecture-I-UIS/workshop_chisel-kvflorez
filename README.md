Workshop Chisel
=======================

El ejercicio consiste en describir en Chisel los bloques Adder 2, Carry select adder y Adder substractor de la plataforma [HDLbits](https://hdlbits.01xz.net/wiki/Module_fadd)

## Bloque Adder 2

### Descripción bloque
El bloque Adder 2 consiste en 3 módulos, el módulo `add1.scala` es un full adder de 1 bit, el cual realiza la suma y "carry-out" de las entradas "a", "b" y "cin", el módulo `add16.scala` es un full adder de 16 bit descrito a partir del `add1.scala`, cuya entrada "cin" es igual a 0 y su salida cout se ignora en la descripción del módulo `top_module.scala`. Este módulo realiza la suma binaria de "a"y "b" ambas entadas de 32 bits, y cuenta con una salida "sum" también de 32 bits.

> El bloque se muestra a continuación

![](https://github.com/Computer-Architecture-I-UIS/workshop_chisel-kvflorez/blob/main/adder2.png)
### Descripción test



### ¿Cómo ejecutar la simulación?

1. Clonar el repositorio `workshop_chisel-kvflorez`
2. Dentro de la carpeta abrir un terminal y ejecutar el siguiente comando
```sh
./run-examples.sh top_module
```
>La simulación funciona si en el terminal puede leer las palabras "Success" y el número de ciclos probados.
aqui va la foto

3. Si quiere crear un archivo .v a partir del .scala utilice el siguiente comando
```sh
./run-examples.sh top_module --backend-name verilator

```
4. Para observar la simulación en gtkwave utilice el siguiente comando
```sh
gtkwave test_run_dir/examples/top_module/top_module.vcdr

```
## Bloque Carry select adder

### Descripción bloque
El bloque Carry select adder consiste en 3 módulos, el módulo `add1.scala` es un full adder de 1 bit, el cual realiza la suma y "carry-out" de las entradas "a", "b" y "cin", el módulo `add16.scala` es un full adder de 16 bit descrito a partir del `add1.scala`. El módulo `top_module_carry` tiene una mejora respecto al `top_module.scala` ya que la segunda etapa del sumador se duplica, y la entrada "cin" de uno es 0 y del otro 1. Las salidas de estos dos módulos se conectan a un MUX2-1 lo cual permite que la suma sea más rápida, y obtener la salida "sum" del módulo `top_module_carry` sin retraso.

> El bloque se muestra a continuación

![](https://github.com/Computer-Architecture-I-UIS/workshop_chisel-kvflorez/blob/main/carry.png)
### Descripción test



### ¿Cómo ejecutar la simulación?

1. Clonar el repositorio `workshop_chisel-kvflorez`
2. Dentro de la carpeta abrir un terminal y ejecutar el siguiente comando
```sh
./run-examples.sh top_module_carry
```
>La simulación funciona si en el terminal puede leer las palabras "Success" y el número de ciclos probados.
aqui va la foto

3. Si quiere crear un archivo .v a partir del .scala utilice el siguiente comando
```sh
./run-examples.sh top_module_carry --backend-name verilator

```
4. Para observar la simulación en gtkwave utilice el siguiente comando
```sh
gtkwave test_run_dir/examples/top_module_carry/top_module.vcdr

```
## Bloque Adder substractor

### Descripción bloque
El bloque Adder substractor consiste en 3 módulos, el módulo `add1.scala` es un full adder de 1 bit, el cual realiza la suma y "carry-out" de las entradas "a", "b" y "cin", el módulo `add16.scala` es un full adder de 16 bit descrito a partir del `add1.scala`. El módulo `top_module_addsub` permite realizar tanto suma o resta de las entradas al añadir una compuerta XOR al módulo `top_module.scala`, la cual tiene como entradas "b" de 32 bits y "sub" de 1 bit, y su salida se conecta a la entrada "b" de cada uno de los bloques `add16.scala`.

> El bloque se muestra a continuación

![](https://github.com/Computer-Architecture-I-UIS/workshop_chisel-kvflorez/blob/main/addsub.png)
### Descripción test



### ¿Cómo ejecutar la simulación?

1. Clonar el repositorio `workshop_chisel-kvflorez`
2. Dentro de la carpeta abrir un terminal y ejecutar el siguiente comando
```sh
./run-examples.sh top_module_addsub
```
>La simulación funciona si en el terminal puede leer las palabras "Success" y el número de ciclos probados.
aqui va la foto

3. Si quiere crear un archivo .v a partir del .scala utilice el siguiente comando
```sh
./run-examples.sh top_module_addsub--backend-name verilator

```
4. Para observar la simulación en gtkwave utilice el siguiente comando
```sh
gtkwave test_run_dir/examples/top_module_addsub/top_module.vcdr

```
