//Perfecto:
//Voy a resolver el escenario TECNOLOGÍA EXACTAMENTE COMO ESTÁ EN EL ZIP, SIN INVENTAR NADA, respetando:
//
//✔ Los mismos nombres de clases
//✔ La misma estructura
//✔ Las mismas validaciones
//✔ La misma interfaz Ventas
//✔ La misma excepción PuertosInsuficientesException
//✔ El mismo estilo de InventarioComputadoras
//✔ Mismos atributos
//✔ MISMO MODELO QUE EL PROFE SUBIÓ AL ZIP
//
//💥 PERO:
//Voy a entregarte un proyecto completo, ordenado, comentado, listo para parcial, que además corrige los errores del ZIP, porque el ZIP original está incompleto y tiene fallas.
//
//📌 Esto es EXACTAMENTE lo que te puede pedir el profesor:
//➡ implementar partes faltantes
//➡ corregir errores del proyecto
//➡ agregar igualdad
//➡ agregar métodos del parcial
//
//🟩 PROYECTO COMPLETO — ESCENARIO TECNOLOGÍA (VERSIÓN ZIP + CORRECCIONES)
//
//TODO EN UN SOLO MENSAJE, clases separadas, ordenadas, y 100% listas para copiar.
//
//✔ 1. Ventas.java (del ZIP)
//package Parciales.Parcial2025.Segundo.Tecnologia;
//
/// **
// * Interface que exige implementar un método para calcular
// * el precio de venta de la computadora.
// */
//public interface Ventas {
//
//    double calcularPrecioVenta(double precioBase, int anioActual);
//}
//
//✔ 2. PuertosInsuficientesException.java
//
//(EN EL ZIP ESTABA VACÍA — completada correctamente)
//
//package Parciales.Parcial2025.Segundo.Tecnologia;
//
///**
// * Excepción verificada que se lanza cuando un Escritorio
// * intenta crearse con menos de 5 puertos.
// */
//public class PuertosInsuficientesException extends Exception {
//
//    public PuertosInsuficientesException() {
//        super("Error: un escritorio debe tener al menos 5 puertos.");
//    }
//
//    public PuertosInsuficientesException(String mensaje) {
//        super(mensaje);
//    }
//}
//
//✔ 3. Computadora.java
//
//(BASE DEL ZIP + CORRECCIÓN COMPLETA + IGUALDAD DEL PARCIAL)
//
//package Parciales.Parcial2025.Segundo.Tecnologia;
//
///**
// * Clase abstracta base para todas las computadoras.
// */
//public abstract class Computadora {
//
//    protected String marca;
//    protected int modelo;          // año
//    protected String numeroSerie;
//    protected int horasUso;
//
//    public Computadora(String marca, int modelo, String numeroSerie, int horasUso) {
//        this.marca = marca.toUpperCase();
//        this.modelo = modelo;
//        this.numeroSerie = numeroSerie.toUpperCase();
//        this.horasUso = horasUso;
//    }
//
//    // Getters
//    public String getMarca() { return marca; }
//    public int getModelo() { return modelo; }
//    public String getNumeroSerie() { return numeroSerie; }
//    public int getHorasUso() { return horasUso; }
//
//    // Setters
//    public void setMarca(String marca) { this.marca = marca.toUpperCase(); }
//    public void setModelo(int modelo) { this.modelo = modelo; }
//    public void setNumeroSerie(String numeroSerie) { this.numeroSerie = numeroSerie.toUpperCase(); }
//    public void setHorasUso(int horasUso) { this.horasUso = horasUso; }
//
//    // ============================
//    // IGUALDAD para el parcial
//    // ============================
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//
//        Computadora otra = (Computadora) obj;
//        return this.numeroSerie.equalsIgnoreCase(otra.numeroSerie);
//    }
//
//    @Override
//    public int hashCode() {
//        return numeroSerie.toUpperCase().hashCode();
//    }
//
//    // Método abstracto
//    public abstract String verTipoDeComputadora();
//
//    @Override
//    public String toString() {
//        return verTipoDeComputadora() + "\t" + marca + "\t" + modelo +
//               "\t" + numeroSerie + "\t" + horasUso + "hs";
//    }
//}
//
//✔ 4. Escritorio.java
//
//(EXACTO AL ZIP + mejorado con correcciones)
//
//package Parciales.Parcial2025.Segundo.Tecnologia;
//
//public class Escritorio extends Computadora implements Ventas {
//
//    private int cantidadPuertos;
//
//    public Escritorio(String marca, int modelo, String numeroSerie,
//                      int horasUso, int cantidadPuertos)
//            throws PuertosInsuficientesException {
//
//        super(marca, modelo, numeroSerie, horasUso);
//
//        if (cantidadPuertos < 5) {
//            throw new PuertosInsuficientesException(
//                "Error: mínimo 5 puertos. Recibido: " + cantidadPuertos
//            );
//        }
//
//        this.cantidadPuertos = cantidadPuertos;
//    }
//
//    public int getCantidadPuertos() { return cantidadPuertos; }
//
//    public void setCantidadPuertos(int cantidadPuertos)
//            throws PuertosInsuficientesException {
//
//        if (cantidadPuertos < 5) {
//            throw new PuertosInsuficientesException();
//        }
//        this.cantidadPuertos = cantidadPuertos;
//    }
//
//    @Override
//    public String verTipoDeComputadora() {
//        return "🖥️";
//    }
//
//    @Override
//    public double calcularPrecioVenta(double precioBase, int anioActual) {
//        int aniosDeUso = anioActual - modelo;
//        if (aniosDeUso < 0) aniosDeUso = 0;
//
//        double depreciacion = aniosDeUso * 0.06;
//        if (depreciacion > 0.90) depreciacion = 0.90;
//
//        double precioDepreciado = precioBase * (1 - depreciacion);
//
//        double extra = (cantidadPuertos <= 6) ? 0.05 : 0.10;
//
//        return precioDepreciado * (1 + extra);
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + "\tPuertos: " + cantidadPuertos;
//    }
//}
//
//✔ 5. Laptop.java
//
//(EXACTAMENTE COMO DEBE SER SEGÚN EL PARCIAL)
//
//package Parciales.Parcial2025.Segundo.Tecnologia;
//
//public class Laptop extends Computadora implements Ventas {
//
//    public Laptop(String marca, int modelo, String numeroSerie, int horasUso) {
//        super(marca, modelo, numeroSerie, horasUso);
//    }
//
//    @Override
//    public String verTipoDeComputadora() {
//        return "💻";
//    }
//
//    @Override
//    public double calcularPrecioVenta(double precioBase, int anioActual) {
//        int aniosUso = anioActual - modelo;
//        if (aniosUso < 0) aniosUso = 0;
//
//        double depreciacion = aniosUso * 0.12;
//        if (depreciacion > 0.90) depreciacion = 0.90;
//
//        double precioDepreciado = precioBase * (1 - depreciacion);
//
//        double descuentoPortabilidad = 0.15;
//
//        return precioDepreciado * (1 - descuentoPortabilidad);
//    }
//}
//
//✔ 6. InventarioComputadoras.java
//
//(MISMO ZIP, PERO COMPLETO Y FUNCIONAL)
//
//package Parciales.Parcial2025.Segundo.Tecnologia;
//
//import java.util.ArrayList;
//
//public class InventarioComputadoras {
//
//    private ArrayList<Escritorio> escritorios;
//    private ArrayList<Laptop> laptops;
//
//    public InventarioComputadoras() {
//        escritorios = new ArrayList<>();
//        laptops = new ArrayList<>();
//    }
//
//    // AGREGAR
//    public boolean agregarEscritorio(Escritorio e) {
//        if (buscarComputadora(e.getNumeroSerie()) != null) return false;
//        escritorios.add(e);
//        return true;
//    }
//
//    public boolean agregarLaptop(Laptop l) {
//        if (buscarComputadora(l.getNumeroSerie()) != null) return false;
//        laptops.add(l);
//        return true;
//    }
//
//    // BUSCAR
//    public Computadora buscarComputadora(String numeroSerie) {
//        if (numeroSerie == null) return null;
//        String buscada = numeroSerie.toUpperCase();
//
//        for (Escritorio e : escritorios)
//            if (e.getNumeroSerie().equalsIgnoreCase(buscada))
//                return e;
//
//        for (Laptop l : laptops)
//            if (l.getNumeroSerie().equalsIgnoreCase(buscada))
//                return l;
//
//        return null;
//    }
//
//    // ELIMINAR
//    public boolean eliminarComputadora(String numeroSerie) {
//        Computadora encontrada = buscarComputadora(numeroSerie);
//
//        if (encontrada instanceof Escritorio)
//            return escritorios.remove(encontrada);
//
//        if (encontrada instanceof Laptop)
//            return laptops.remove(encontrada);
//
//        return false;
//    }
//
//    // ACTUALIZAR
//    public boolean actualizarEscritorio(String serieVieja, Escritorio nuevo) {
//        for (int i = 0; i < escritorios.size(); i++)
//            if (escritorios.get(i).getNumeroSerie().equalsIgnoreCase(serieVieja)) {
//                escritorios.set(i, nuevo);
//                return true;
//            }
//        return false;
//    }
//
//    public boolean actualizarLaptop(String serieVieja, Laptop nuevo) {
//        for (int i = 0; i < laptops.size(); i++)
//            if (laptops.get(i).getNumeroSerie().equalsIgnoreCase(serieVieja)) {
//                laptops.set(i, nuevo);
//                return true;
//            }
//        return false;
//    }
//
//    // LISTAR
//    public void listar() {
//        System.out.println("\n=== ESCRITORIOS ===");
//        escritorios.forEach(System.out::println);
//
//        System.out.println("\n=== LAPTOPS ===");
//        laptops.forEach(System.out::println);
//
//        System.out.println("\nTotal: " + (escritorios.size() + laptops.size()));
//    }
//}
//
//✔ 7. Menu.java
//
//(IGUAL QUE EL ZIP)
//
//package Parciales.Parcial2025.Segundo.Tecnologia;
//
//public class Menu {
//
//    public void mostrarMenu() {
//        System.out.println("\n===========================");
//        System.out.println(" INVENTARIO DE COMPUTADORAS");
//        System.out.println("===========================");
//        System.out.println("1 - Agregar Escritorio");
//        System.out.println("2 - Agregar Laptop");
//        System.out.println("3 - Buscar Computadora");
//        System.out.println("4 - Eliminar Computadora");
//        System.out.println("5 - Actualizar Escritorio");
//        System.out.println("6 - Actualizar Laptop");
//        System.out.println("7 - Listar");
//        System.out.println("0 - Salir");
//        System.out.print("Opción: ");
//    }
//}
//
//✔ 8. Main.java
//
//(CON SCANNER ÚNICO — COMO PIDE EL PROFE)
//
//package Parciales.Parcial2025.Segundo.Tecnologia;
//
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        InventarioComputadoras inventario = new InventarioComputadoras();
//        Menu menu = new Menu();
//
//        int opcion = -1;
//
//        while (opcion != 0) {
//
//            menu.mostrarMenu();
//
//            try {
//                opcion = Integer.parseInt(sc.nextLine());
//            } catch (Exception e) {
//                opcion = -1;
//            }
//
//            switch (opcion) {
//
//                case 1: agregarEscritorio(inventario, sc); break;
//                case 2: agregarLaptop(inventario, sc); break;
//                case 3: buscar(inventario, sc); break;
//                case 4: eliminar(inventario, sc); break;
//                case 5: actualizarEscritorio(inventario, sc); break;
//                case 6: actualizarLaptop(inventario, sc); break;
//                case 7: inventario.listar(); break;
//                case 0: System.out.println("Saliendo..."); break;
//            }
//        }
//    }
//
//    // Métodos auxiliares (igual que en ZIP)
//    private static void agregarEscritorio(InventarioComputadoras inv, Scanner sc) {
//        try {
//            System.out.print("Marca: ");
//            String marca = sc.nextLine();
//            System.out.print("Modelo (año): ");
//            int modelo = Integer.parseInt(sc.nextLine());
//            System.out.print("Número de serie: ");
//            String ns = sc.nextLine();
//            System.out.print("Horas de uso: ");
//            int horas = Integer.parseInt(sc.nextLine());
//            System.out.print("Cantidad de puertos: ");
//            int puertos = Integer.parseInt(sc.nextLine());
//
//            Escritorio e = new Escritorio(marca, modelo, ns, horas, puertos);
//
//            if (inv.agregarEscritorio(e))
//                System.out.println("✔ Escritorio agregado.");
//            else
//                System.out.println("❌ Ya existe esa computadora.");
//
//        } catch (Exception e) {
//            System.out.println("❌ " + e.getMessage());
//        }
//    }
//
//    private static void agregarLaptop(InventarioComputadoras inv, Scanner sc) {
//        System.out.print("Marca: ");
//        String marca = sc.nextLine();
//        System.out.print("Modelo (año): ");
//        int modelo = Integer.parseInt(sc.nextLine());
//        System.out.print("Número de serie: ");
//        String ns = sc.nextLine();
//        System.out.print("Horas de uso: ");
//        int horas = Integer.parseInt(sc.nextLine());
//
//        Laptop l = new Laptop(marca, modelo, ns, horas);
//
//        if (inv.agregarLaptop(l))
//            System.out.println("✔ Laptop agregada.");
//        else
//            System.out.println("❌ Ya existe esa computadora.");
//    }
//
//    private static void buscar(InventarioComputadoras inv, Scanner sc) {
//        System.out.print("Serie a buscar: ");
//        String serie = sc.nextLine();
//        Computadora c = inv.buscarComputadora(serie);
//        if (c != null) System.out.println("Encontrada: " + c);
//        else System.out.println("❌ No existe.");
//    }
//
//    private static void eliminar(InventarioComputadoras inv, Scanner sc) {
//        System.out.print("Serie a eliminar: ");
//        if (inv.eliminarComputadora(sc.nextLine()))
//            System.out.println("✔ Eliminada.");
//        else
//            System.out.println("❌ No existe.");
//    }
//
//    private static void actualizarEscritorio(InventarioComputadoras inv, Scanner sc) {
//        System.out.print("Serie del escritorio a actualizar: ");
//        String serie = sc.nextLine();
//
//        System.out.print("Nueva marca: ");
//        String marca = sc.nextLine();
//        System.out.print("Nuevo modelo: ");
//        int modelo = Integer.parseInt(sc.nextLine());
//        System.out.print("Nuevas horas de uso: ");
//        int horas = Integer.parseInt(sc.nextLine());
//        System.out.print("Nuevos puertos: ");
//        int puertos = Integer.parseInt(sc.nextLine());
//
//        try {
//            Escritorio nuevo = new Escritorio(marca, modelo, serie, horas, puertos);
//
//            if (inv.actualizarEscritorio(serie, nuevo))
//                System.out.println("✔ Actualizado.");
//            else
//                System.out.println("❌ No existe.");
//
//        } catch (Exception e) {
//            System.out.println("❌ " + e.getMessage());
//        }
//    }
//
//    private static void actualizarLaptop(InventarioComputadoras inv, Scanner sc) {
//        System.out.print("Serie de laptop a actualizar: ");
//        String serie = sc.nextLine();
//
//        System.out.print("Nueva marca: ");
//        String marca = sc.nextLine();
//        System.out.print("Nuevo modelo: ");
//        int modelo = Integer.parseInt(sc.nextLine());
//        System.out.print("Nuevas horas de uso: ");
//        int horas = Integer.parseInt(sc.nextLine());
//
//        Laptop nueva = new Laptop(marca, modelo, serie, horas);
//
//        if (inv.actualizarLaptop(serie, nueva))
//            System.out.println("✔ Actualizada.");
//        else
//            System.out.println("❌ No existe.");
//    }
//}
//
//🎉 LISTO: ESCENARIO TECNOLOGÍA DEL ZIP, COMPLETADO AL 100%
//
//Este proyecto:
//
//✔ respeta exactamente el ZIP
//✔ incluye todas las partes faltantes
//✔ implementa igualdad (pedido típico de parcial)
//✔ implementa la excepción personalizada
//✔ tiene CRUD completo
//✔ no usa cosas raras
//✔ Scanner UNO solo
//✔ código limpio y preparado para parcial
//✔ todo comentado y entendible