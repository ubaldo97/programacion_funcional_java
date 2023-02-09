package org.example.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //Funcionales funcionales = new Funcionales();
        //funcionales.pruebas();

        ArrayList<String> nombres = new ArrayList<String>();
        nombres.add("Juan");
        nombres.add("Pedro");
        nombres.add("Maria");
        nombres.add("Jose");

        //Recorrerlo de manera imperativa
       /* for (String nombre : nombres) {
            System.out.println(nombre);
        }*/

        //Recorrerlo de manera declarativa o funcional -- lo mismo pero con menos lineas
        //nombres.stream().forEach(x -> System.out.println(x));

        //Forma corta del lambda
        //nombres.stream().forEach(System.out::println);

        //Forma completa
       /* Stream<String> stream = nombres.stream()
                .map((x) -> {
                    return x.toUpperCase();
                });*/

        //map se usa para aplicar una función o tratamiento para cada dato del stream
        Stream<String> stream = nombres.stream()
                .map(x -> x.toUpperCase())
                //Filter se usa para filtrar datos del stream
                .filter(x -> x.startsWith("J"));
        //Una desventaja es que el stream se consume al usar forEach y no se puede volver a usar
        stream.forEach(x-> System.out.println(x));
        //La siguiente linea ya no es posible debido a que ya hicimos un forEach previamente
        //stream.forEach(x-> System.out.println(x));

        //Convertir un array en stream y utilizar programación funcional
        int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        IntStream stNums = Arrays.stream(numeros);
        int resultado = stNums
                .map(x -> x * 2)//aplicamos una funcion sobre cada elemento
                .filter(x -> x % 2 == 0)//filtramos en base a pares
                //Reduce aplica una funcion de reducción como una suma y retorna un unico valor
                //El 0 es el valor de la primera iteración
                //para el caso de String el valor inicial podria ser "" en lugar de 0 (por ejemplo)
                .reduce(0, (x, y) -> {
                    System.out.println("X es: " + x + " Y es: "+y);
                    return x + y;
                });
        System.out.println("La suma es " + resultado);


        //Forma imperativa
        int sumaTotal = 0;
        for(int numero:numeros){
            numero = numero*2;
            if(numero % 2 != 0){
                continue;
            }
            sumaTotal=sumaTotal+numero;
        }

        System.out.println("La suma de forma declarativa es " + resultado + " Y de forma imperativa es: "+sumaTotal);

    }
}
