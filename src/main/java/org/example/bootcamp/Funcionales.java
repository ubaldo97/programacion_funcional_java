package org.example.bootcamp;

import java.util.function.Function;

public class Funcionales {
    //Ejemplo de Función de alto nivel y es de tipo declarativo
    private Function<String,String> toMayus = x -> x.toUpperCase();
    // la x entre parentesis es como el argumento de la función si fueran varios argumentos
    // se necesitarian a fuerzas los parentesis.
    private Function<Integer,Integer> sumador = (x) -> x.sum(x,x);

    //Como llamar una función de alto nivel y como pasarla como argumento dentro de un método
    //Esto se usa para encadenar la salida de una función con la entrada de otra
    public void saluda(Function<String,String> miFuncion, String nombre){
        miFuncion.apply(nombre);
    }
    public void pruebas(){
        System.out.println(toMayus.apply("Ubaldo"));
        System.out.println(sumador.apply(2));
    }

    //hace lo mismo que la primera pero es un método de tipo imperativo
    public static String toMayuscula(String nombre){
        return nombre.toUpperCase();
    }

}
