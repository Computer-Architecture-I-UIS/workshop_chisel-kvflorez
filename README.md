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
#### Set project organization and name in build.sbt

The cleanup workflow will have attempted to provide sensible defaults for `ThisBuild / organization` and `name` in the `build.sbt`.
Feel free to use your text editor of choice to change them as you see fit.

#### Clean up the README.md file

Again, use you editor of choice to make the README specific to your project.

#### Add a LICENSE file

It is important to have a LICENSE for open source (or closed source) code.
This template repository has the Unlicense in order to allow users to add any license they want to derivative code.
The Unlicense is stripped when creating a repository from this template so that users do not accidentally unlicense their own work.

For more information about a license, check out the [Github Docs](https://docs.github.com/en/free-pro-team@latest/github/building-a-strong-community/adding-a-license-to-a-repository).

#### Commit your changes
```sh
git commit -m 'Starting workshop_chisel-kvflorez'
git push origin main
```

### Did it work?

You should now have a working Chisel3 project.

You can run the included test with:
```sh
sbt test
```

You should see a whole bunch of output that ends with something like the following lines
```
[info] Tests: succeeded 1, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 5 s, completed Dec 16, 2020 12:18:44 PM
```
If you see the above then...

### It worked!

You are ready to go. We have a few recommended practices and things to do.

* Use packages and following conventions for [structure](https://www.scala-sbt.org/1.x/docs/Directories.html) and [naming](http://docs.scala-lang.org/style/naming-conventions.html)
* Package names should be clearly reflected in the testing hierarchy
* Build tests for all your work
* Read more about testing in SBT in the [SBT docs](https://www.scala-sbt.org/1.x/docs/Testing.html)
* This template includes a [test dependency](https://www.scala-sbt.org/1.x/docs/Library-Dependencies.html#Per-configuration+dependencies) on [chiseltest](https://github.com/ucb-bar/chisel-testers2), this is a reasonable starting point for most tests
  * You can remove this dependency in the build.sbt file if you want to
* Change the name of your project in the build.sbt file
* Change your README.md

## Problems? Questions?

Check out the [Chisel Users Community](https://www.chisel-lang.org/community.html) page for links to get in contact!
