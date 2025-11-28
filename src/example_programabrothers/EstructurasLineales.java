package org.example;

public class EstructurasLineales {

    //COLA

    //package main.java.com.frre.tsp.estructuralineales;
    //
    ///**
    // * Clase cola.
    // */
    //public class Cola {
    //
    //    private Nodo primero;
    //    private Nodo ultimo;
    //    private int tamaño;
    //
    //    public Cola() {
    //        this.primero = null;
    //        this.ultimo = null;
    //        this.tamaño = 0;
    //    }
    //
    //    public boolean vacia() {
    //        return this.primero == null;
    //    }
    //
    //    // enqueue
    //    public void encolar(String valor) {
    //
    //        Nodo nuevo = new Nodo(valor);
    //
    //        if (vacia()) {
    //            this.primero = nuevo;
    //            this.ultimo = nuevo;
    //        } else {
    //
    //            this.ultimo.siguiente = nuevo;
    //            this.ultimo = nuevo;
    //        }
    //        this.tamaño++;
    //    }
    //
    //    // dequeue
    //    public String desencolar() {
    //
    //        if (vacia()) {
    //            return "Cola vacía";
    //        } else {
    //
    //            String aux = this.primero.valor;
    //            this.primero = this.primero.siguiente;
    //            this.tamaño--;
    //
    //            return aux;
    //        }
    //    }
    //
    //    public void imprimir() {
    //        if (vacia()) {
    //            System.out.println("Cola vacia");
    //        } else {
    //
    //            Nodo aux = this.primero;
    //            for(int i = 0; i<this.tamaño; i++) {
    //                System.out.println(aux.valor);
    //                aux = aux.siguiente;
    //            }
    //        }
    //    }
    //}



    //LISTA CIRCULAR
    //package main.java.com.frre.tsp.estructuralineales;
    //
    ///**
    // * Clase Lista enlazada circular.
    // */
    //public class ListaCircular {
    //
    //    private Nodo primero;
    //    private Nodo ultimo;
    //    public int tamaño;
    //
    //    public void Lista() {
    //        this.primero = null;
    //        this.ultimo = null;
    //        this.tamaño = 0;
    //    }
    //
    //    public boolean vacia() {
    //        return this.primero == null;
    //    }
    //
    //    public void agregar(String valor) {
    //
    //        Nodo nuevo = new Nodo(valor);
    //
    //        if (vacia()) {
    //            // agregamos el primer nodo
    //            this.primero = nuevo;
    //            this.ultimo = nuevo;
    //            this.ultimo.siguiente = this.primero;
    //        } else {
    //            // usa los puntores a "primero" y "ultimo"
    //            this.ultimo.siguiente = nuevo;
    //            nuevo.siguiente = this.primero;
    //            ultimo = nuevo;
    //        }
    //        this.tamaño++;
    //    }
    //
    //    public void eliminarUltimo() {
    //        if (vacia()) {
    //            System.out.println("Lista vacia");
    //        } else {
    //            // se tiene que recorrer la lista hasta llegar al ultimo nodo
    //            Nodo aux = primero;
    //
    //            while (aux.siguiente != null) {
    //                aux = aux.siguiente;
    //            }
    //            aux = null;
    //
    //            this.tamaño--;
    //        }
    //    }
    //
    //    public void imprimir() {
    //        if (vacia()) {
    //            System.out.println("Lista vacia");
    //        } else {
    //            Nodo aux = this.primero;
    //            for(int i = 0; i<this.tamaño; i++) {
    //                System.out.println(aux.valor);
    //                aux = aux.siguiente;
    //            }
    //        }
    //    }
    //}

    //LISTA DOBLE
    //package main.java.com.frre.tsp.estructuralineales;
    //
    ///**
    // * Lista doblemente enlazada
    // */
    //public class ListaDoble {
    //
    //    private NodoDoble primero;
    //    private NodoDoble ultimo;
    //    private int tamaño;
    //
    //    public ListaDoble() {
    //        this.primero = null;
    //        this.ultimo = null;
    //        this.tamaño = 0;
    //    }
    //
    //    public boolean vacia() {
    //        return this.primero == null;
    //    }
    //
    //    public void agregar(String valor) {
    //
    //        NodoDoble nuevo = new NodoDoble(valor);
    //
    //        if (vacia()) {
    //            this.primero = nuevo;
    //            this.ultimo = nuevo;
    //        } else {
    //
    //            // se tiene que recorrer la lista hasta llegar al ultimo nodo
    //            NodoDoble aux = primero;
    //
    //            while (aux.siguiente != null) {
    //                aux = aux.siguiente;
    //            }
    //
    //            // asigna primero y ultimo
    //            aux.siguiente = nuevo;
    //            nuevo.anterior = aux;
    //            this.ultimo = nuevo;
    //        }
    //
    //        this.tamaño++;
    //    }
    //
    //    public void agregarInicio(String valor){
    //        NodoDoble nuevo = new NodoDoble(valor);
    //
    //        if(vacia()){
    //            this.primero=nuevo;
    //        } else {
    //            nuevo.siguiente = this.primero;
    //            this.primero.anterior = nuevo;
    //            this.primero = nuevo;
    //        }
    //    }
    //
    //    public void eliminarUltimo() {
    //        if (vacia()) {
    //            System.out.println("Lista vacia");
    //        } else {
    //            // se tiene que recorrer la lista hasta llegar al ultimo nodo
    //            NodoDoble aux = primero;
    //            NodoDoble nodoAnterior = aux;
    //
    //            while (aux.siguiente != null) {
    //                nodoAnterior = aux;
    //                aux = aux.siguiente;
    //            }
    //
    //            // Verifico si realmente avanzó en la lista hasta llegar al
    //            // último nodo que sea distinto del primero.
    //            // Si estoy en el primero, entonces hago primero y ultimo null para indicar que la lista esta vacia.
    //            if (aux == this.primero) {
    //                this.primero = null;
    //                this.ultimo = null;
    //            } else {
    //                this.ultimo = nodoAnterior;
    //                nodoAnterior.siguiente = null;
    //                aux.anterior = null;
    //            }
    //
    //            this.tamaño--;
    //        }
    //    }
    //
    //    public void imprimir() {
    //        if (vacia()) {
    //            System.out.println("Lista vacia");
    //        } else {
    //
    //            NodoDoble aux = primero;
    //
    //            for(int i=0;i<this.tamaño;i++){
    //                System.out.println(aux.valor);
    //                aux = aux.siguiente;
    //            }
    //        }
    //    }
    //
    //    public void imprimirInverso() {
    //        if (vacia()) {
    //            System.out.println("Lista vacia");
    //        } else {
    //
    //            NodoDoble aux = ultimo;
    //
    //            for(int i=0;i<this.tamaño;i++){
    //                System.out.println(aux.valor);
    //                aux = aux.anterior;
    //            }
    //        }
    //    }
    //}

    //LISTA SIMPLE
    //package main.java.com.frre.tsp.estructuralineales;
    //
    ///**
    // * Clase Lista simplemente enlazada.
    // */
    //public class ListaSimple {
    //
    //    private Nodo primero;
    //    public int tamaño;
    //
    //    public ListaSimple() {
    //        this.primero = null;
    //        this.tamaño = 0;
    //    }
    //
    //    public boolean vacia() {
    //        return this.primero == null;
    //    }
    //
    //    public void agregar(String valor) {
    //
    //        Nodo nuevo = new Nodo(valor);
    //
    //        if (vacia()) {
    //            // agregamos el primer nodo
    //            this.primero = nuevo;
    //        } else {
    //            // se tiene que recorrer la lista hasta llegar al ultimo nodo
    //            Nodo aux = this.primero;
    //
    //            while (aux.siguiente != null) {
    //                aux = aux.siguiente;
    //            }
    //            aux.siguiente = nuevo;
    //        }
    //        this.tamaño++;
    //    }
    //
    //    public void eliminarUltimo() {
    //        if (vacia()) {
    //            System.out.println("Lista vacia");
    //        } else {
    //            // se tiene que recorrer la lista hasta llegar al ultimo nodo
    //            Nodo aux = primero;
    //            Nodo nodoAnterior = aux;
    //
    //            while (aux.siguiente != null) {
    //                nodoAnterior = aux;
    //                aux = aux.siguiente;
    //            }
    //
    //            // Verifico si realmente avanzó en la lista hasta llegar al
    //            // último nodo que sea distinto del primero.
    //            // Si estoy en el primero, entonces lo hago null para indicar que la lista esta vacia.
    //            if (aux == this.primero) {
    //                this.primero = null;
    //            } else {
    //                // Le indico al nodo anterior que no apunte más al nodo a eliminar "aux".
    //                nodoAnterior.siguiente = null;
    //            }
    //
    //            // Decremento el tamaño
    //            this.tamaño--;
    //        }
    //    }
    //
    //    public void imprimir() {
    //        if (vacia()) {
    //            System.out.println("Lista vacia");
    //        } else {
    //            Nodo aux = this.primero;
    //            for(int i = 0; i<this.tamaño; i++) {
    //                System.out.println(aux.valor);
    //                aux = aux.siguiente;
    //            }
    //        }
    //    }
    //}

    //NODO
    //package main.java.com.frre.tsp.estructuralineales;
    //
    ///**
    // * Clase Nodo.
    // */
    //public class Nodo {
    //
    //    public String valor;
    //    public Nodo siguiente;
    //
    //    public Nodo(String valor) {
    //        this.valor = valor;
    //        this.siguiente = null;
    //    }
    //
    //    // toString() retorna el valor del nodo.
    //    @Override
    //    public String toString() {
    //        return this.valor;
    //    }
    //}

    //NODO DOBLE
    //package main.java.com.frre.tsp.estructuralineales;
    //
    ///**
    // * Clase Nodo doble enlazado.
    // */
    //public class NodoDoble {
    //
    //    public NodoDoble anterior;
    //    public NodoDoble siguiente;
    //    public String valor;
    //
    //    public NodoDoble(String valor) {
    //        this.valor = valor;
    //        this.anterior = null;
    //        this.siguiente = null;
    //    }
    //
    //    // toString() retorna el valor del nodo.
    //    @Override
    //    public String toString() {
    //        return this.valor;
    //    }
    //}

    //PILA
    //package main.java.com.frre.tsp.estructuralineales;
    //
    ///**
    // *  Clase pila.
    // */
    //public class Pila {
    //
    //    private Nodo ultimo;
    //    private int tamaño;
    //
    //    public Pila() {
    //        this.tamaño = 0;
    //        this.ultimo = null;
    //    }
    //
    //    public boolean vacia() {
    //        return this.ultimo == null;
    //    }
    //
    //    // push
    //    public void apilar(String valor) {
    //
    //        Nodo nuevo = new Nodo(valor);
    //
    //        if (vacia()) {
    //
    //            this.ultimo = nuevo;
    //
    //        } else {
    //
    //            nuevo.siguiente = this.ultimo;
    //            this.ultimo = nuevo;
    //        }
    //
    //        this.tamaño++;
    //    }
    //
    //    // pop
    //    public String desapilar() {
    //        if (vacia()) {
    //            return "Pila vacia";
    //        } else {
    //
    //            //String aux = this.ultimo.valor;
    //            Nodo aux = new Nodo(this.ultimo.valor);
    //
    //            this.ultimo = this.ultimo.siguiente;
    //            this.tamaño--;
    //
    //            return aux.valor;
    //        }
    //    }
    //
    //    public void imprimir() {
    //        if (vacia()) {
    //            System.out.println("Pila vacia");
    //        } else {
    //            Nodo aux = this.ultimo;
    //            for(int i = 0; i<this.tamaño; i++) {
    //                System.out.println(aux.valor);
    //                aux = aux.siguiente;
    //            }
    //        }
    //    }
    //}



}
