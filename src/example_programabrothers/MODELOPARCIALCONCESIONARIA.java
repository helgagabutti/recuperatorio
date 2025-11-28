//Buenísimo, vamos a resolver el modelo de parcial usando el tema Concesionaria de vehículos, como pide el enunciado del PDF.
//
//Modelo del 2do Examen Parcial d…
//
//Te dejo un mini–proyecto completo, con todas las cosas que exige el modelo:
//
//CRUD por consola con ArrayList<Vehiculo>
//
//Vehiculo con atributos privados + getters/setters
//
//equals y hashCode por patente
//
//Constructor parametrizado
//
//Interfaces (Identificable, Mantenible)
//
//Excepción PatenteInvalidaException
//
//Recursividad (contar vehículos con km mayor a X)
//
//Lambdas: forEach, stream().filter(), removeIf, anyMatch
//
//Uso de if / else, switch, for, while, do-while, break, continue
//
//Uso de length(), toUpperCase(), contains()
//
//Sobrecarga en Vehiculo y sobreescritura en las subclases
//
//Voy a usar el package de concesionaria:
//
//package Parciales.Parcial2025.Segundo.Concesionario;
//
//1️⃣ Interface Identificable
//package Parciales.Parcial2025.Segundo.Concesionario;
//
/// **
// * Un objeto identificable por un String único (en este caso, la patente).
// */
//public interface Identificable {
//    String getIdentificador();   // acá será la patente
//}
//
//2️⃣ Interface Mantenible (costo de mantenimiento)
//package Parciales.Parcial2025.Segundo.Concesionario;
//
//public interface Mantenible {
//    double calcularCostoMantenimiento(double costoBase);
//}
//
//3️⃣ Excepción PatenteInvalidaException
//package Parciales.Parcial2025.Segundo.Concesionario;
//
///**
// * Se lanza cuando la patente no cumple un formato mínimo.
// * (Ejemplo: longitud incorrecta, caracteres inválidos, etc.)
// */
//public class PatenteInvalidaException extends Exception {
//
//    public PatenteInvalidaException() {
//        super("Patente inválida. Debe tener entre 6 y 7 caracteres alfanuméricos.");
//    }
//
//    public PatenteInvalidaException(String mensaje) {
//        super(mensaje);
//    }
//}
//
//4️⃣ Clase abstracta Vehiculo
//package Parciales.Parcial2025.Segundo.Concesionario;
//
//import java.util.Objects;
//
///**
// * Contexto:
// * Sistema de Administración de Vehículos para una Concesionaria.
// * La concesionaria registra autos, motos y colectivos para su venta y mantenimiento.
// */
//public abstract class Vehiculo implements Identificable, Mantenible {
//
//    private String marca;
//    private int modelo;
//    private String patente;
//    private int tipo;          // 1=Auto, 2=Moto, 3=Colectivo
//    private int kilometraje;
//
//    // Constructor parametrizado
//    public Vehiculo(String marca, int modelo, String patente, int tipo, int kilometraje)
//            throws PatenteInvalidaException {
//
//        setMarca(marca);
//        setModelo(modelo);
//        setPatente(patente);   // valida y normaliza dentro del setter
//        this.tipo = tipo;
//        this.kilometraje = kilometraje;
//    }
//
//    // ===== Getters / Setters (encapsulamiento) =====
//    public String getMarca() { return marca; }
//    public int getModelo() { return modelo; }
//    public String getPatente() { return patente; }
//    public int getTipo() { return tipo; }
//    public int getKilometraje() { return kilometraje; }
//
//    public void setMarca(String marca) {
//        if (marca == null) marca = "";
//        this.marca = marca.toUpperCase();
//    }
//
//    public void setModelo(int modelo) { this.modelo = modelo; }
//
//    public void setPatente(String patente) throws PatenteInvalidaException {
//        if (patente == null) throw new PatenteInvalidaException("La patente no puede ser null");
//
//        String limpia = patente.trim().toUpperCase();
//
//        // Ejemplo simple de validación: longitud 6 o 7 y solo letras/números
//        if (limpia.length() < 6 || limpia.length() > 7 || !limpia.matches("[A-Z0-9]+")) {
//            throw new PatenteInvalidaException(
//                    "Patente inválida: " + patente + ". Debe tener 6 o 7 caracteres alfanuméricos.");
//        }
//        this.patente = limpia;
//    }
//
//    public void setTipo(int tipo) { this.tipo = tipo; }
//    public void setKilometraje(int kilometraje) { this.kilometraje = kilometraje; }
//
//    // Implementación de Identificable
//    @Override
//    public String getIdentificador() {
//        return patente;
//    }
//
//    // ====== Sobrecarga en la clase Vehiculo ======
//    // Versión base
//    @Override
//    public double calcularCostoMantenimiento(double costoBase) {
//        // costo base + 1% por cada 10.000 km
//        double factor = 1 + (kilometraje / 10000) * 0.01;
//        return costoBase * factor;
//    }
//
//    // Sobrecarga: mismo nombre, distinto parámetro
//    public double calcularCostoMantenimiento(double costoBase, double recargoExtra) {
//        return calcularCostoMantenimiento(costoBase) + recargoExtra;
//    }
//
//    // Método abstracto a sobreescribir en subclases
//    public abstract String verTipo();
//
//    // ====== equals y hashCode POR PATENTE ======
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Vehiculo vehiculo = (Vehiculo) o;
//        return patente.equalsIgnoreCase(vehiculo.patente);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(patente.toUpperCase());
//    }
//
//    @Override
//    public String toString() {
//        return verTipo() + "\t" + marca + "\t" + modelo + "\t" +
//               patente + "\t" + kilometraje + " Km";
//    }
//}
//
//5️⃣ Subclase Auto
//package Parciales.Parcial2025.Segundo.Concesionario;
//
//public class Auto extends Vehiculo {
//
//    private int cantPuertas;
//
//    public Auto(String marca, int modelo, String patente,
//                int kilometraje, int cantPuertas)
//            throws PatenteInvalidaException {
//
//        super(marca, modelo, patente, 1, kilometraje);
//        this.cantPuertas = cantPuertas;
//    }
//
//    public int getCantPuertas() { return cantPuertas; }
//    public void setCantPuertas(int cantPuertas) { this.cantPuertas = cantPuertas; }
//
//    @Override
//    public String verTipo() {
//        return "AUTO";
//    }
//
//    // Sobrescritura: redefine el cálculo de mantenimiento
//    @Override
//    public double calcularCostoMantenimiento(double costoBase) {
//        double base = super.calcularCostoMantenimiento(costoBase);
//        // Autos con más de 4 puertas → pequeño recargo
//        if (cantPuertas > 4) {
//            base *= 1.05; // +5%
//        }
//        return base;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + "\t" + cantPuertas + " puertas";
//    }
//}
//
//6️⃣ Subclase Moto
//package Parciales.Parcial2025.Segundo.Concesionario;
//
//public class Moto extends Vehiculo {
//
//    public Moto(String marca, int modelo, String patente, int kilometraje)
//            throws PatenteInvalidaException {
//
//        super(marca, modelo, patente, 2, kilometraje);
//    }
//
//    @Override
//    public String verTipo() {
//        return "MOTO";
//    }
//
//    @Override
//    public double calcularCostoMantenimiento(double costoBase) {
//        double base = super.calcularCostoMantenimiento(costoBase);
//        // Las motos suelen tener mantenimiento algo más barato
//        return base * 0.9; // 10% descuento
//    }
//}
//
//7️⃣ Subclase Colectivo
//package Parciales.Parcial2025.Segundo.Concesionario;
//
//public class Colectivo extends Vehiculo {
//
//    private int cantAsientos;
//
//    public Colectivo(String marca, int modelo, String patente,
//                     int kilometraje, int cantAsientos)
//            throws PatenteInvalidaException {
//
//        super(marca, modelo, patente, 3, kilometraje);
//        this.cantAsientos = cantAsientos;
//    }
//
//    public int getCantAsientos() { return cantAsientos; }
//    public void setCantAsientos(int cantAsientos) { this.cantAsientos = cantAsientos; }
//
//    @Override
//    public String verTipo() {
//        return "COLECTIVO";
//    }
//
//    @Override
//    public double calcularCostoMantenimiento(double costoBase) {
//        double base = super.calcularCostoMantenimiento(costoBase);
//        // A más asientos, más caro el mantenimiento
//        if (cantAsientos > 30) {
//            base *= 1.10; // +10%
//        }
//        return base;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + "\t" + cantAsientos + " asientos";
//    }
//}
//
//8️⃣ Clase InventarioVehiculos (CRUD + recursividad + lambdas)
//package Parciales.Parcial2025.Segundo.Concesionario;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class InventarioVehiculos {
//
//    // Variable "global" principal, justificada: almacena todos los vehículos
//    private static final List<Vehiculo> vehiculos = new ArrayList<>();
//
//    // ---------- CREAR ----------
//    public boolean agregarVehiculo(Vehiculo v) {
//        // Uso de anyMatch (lambda)
//        boolean existe = vehiculos.stream()
//                .anyMatch(veh -> veh.getPatente().equalsIgnoreCase(v.getPatente()));
//
//        if (existe) return false;
//
//        vehiculos.add(v);
//        return true;
//    }
//
//    // ---------- BUSCAR (ITERATIVO) ----------
//    public Vehiculo buscarPorPatente(String patente) {
//        if (patente == null) return null;
//        String buscada = patente.toUpperCase();
//
//        for (Vehiculo v : vehiculos) {
//            if (v.getPatente().equalsIgnoreCase(buscada)) {
//                return v;
//            }
//        }
//        return null;
//    }
//
//    // ---------- BUSCAR (RECURSIVO) ----------
//    public Vehiculo buscarPorPatenteRecursivo(String patente) {
//        if (patente == null) return null;
//        return buscarRec(patente.toUpperCase(), 0);
//    }
//
//    private Vehiculo buscarRec(String patente, int indice) {
//        if (indice >= vehiculos.size()) return null;
//        Vehiculo actual = vehiculos.get(indice);
//        if (actual.getPatente().equalsIgnoreCase(patente)) {
//            return actual;
//        }
//        return buscarRec(patente, indice + 1);
//    }
//
//    // ---------- ELIMINAR ----------
//    public boolean eliminarVehiculo(String patente) {
//        if (patente == null) return false;
//        String buscada = patente.toUpperCase();
//
//        // removeIf con lambda
//        return vehiculos.removeIf(v -> v.getPatente().equalsIgnoreCase(buscada));
//    }
//
//    // ---------- ACTUALIZAR ----------
//    public boolean actualizarKilometraje(String patente, int nuevoKm) {
//        Vehiculo v = buscarPorPatente(patente);
//        if (v == null) return false;
//        v.setKilometraje(nuevoKm);
//        return true;
//    }
//
//    // ---------- LISTAR ----------
//    public void listarVehiculos() {
//        if (vehiculos.isEmpty()) {
//            System.out.println("No hay vehículos cargados.");
//            return;
//        }
//
//        // forEach con lambda
//        vehiculos.forEach(System.out::println);
//    }
//
//    // ---------- RECURSIVIDAD: contar vehículos con km > limite ----------
//    public int contarConKmMayorA(int limite) {
//        return contarKmRec(limite, 0);
//    }
//
//    private int contarKmRec(int limite, int indice) {
//        if (indice >= vehiculos.size()) return 0;
//
//        Vehiculo v = vehiculos.get(indice);
//        int suma = (v.getKilometraje() > limite) ? 1 : 0;
//
//        return suma + contarKmRec(limite, indice + 1);
//    }
//
//    public int getCantidadVehiculos() {
//        return vehiculos.size();
//    }
//
//    // Filtro con stream (otra lambda)
//    public void listarVehiculosConMarca(String fragmentoMarca) {
//        String frag = fragmentoMarca.toUpperCase();
//        vehiculos.stream()
//                .filter(v -> v.getMarca().contains(frag)) // uso de contains()
//                .forEach(System.out::println);
//    }
//}
//
//9️⃣ Clase Menu (solo imprimir opciones)
//package Parciales.Parcial2025.Segundo.Concesionario;
//
//public class Menu {
//
//    public void mostrarMenu() {
//        System.out.println("\n===== CONCESIONARIA - SISTEMA DE VEHÍCULOS =====");
//        System.out.println("1. Agregar vehículo");
//        System.out.println("2. Listar vehículos");
//        System.out.println("3. Buscar vehículo por patente");
//        System.out.println("4. Eliminar vehículo");
//        System.out.println("5. Actualizar kilometraje");
//        System.out.println("6. Contar vehículos con km mayor a X (recursivo)");
//        System.out.println("7. Listar vehículos por fragmento de marca");
//        System.out.println("0. Salir");
//        System.out.print("Opción: ");
//    }
//}
//
//🔟 Clase Main (CRUD por consola + estructuras pedidas)
//package Parciales.Parcial2025.Segundo.Concesionario;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        InventarioVehiculos inventario = new InventarioVehiculos();
//        Menu menu = new Menu();
//        Scanner sc = new Scanner(System.in);
//
//        int opcion;
//
//        // do-while obligatorio
//        do {
//            menu.mostrarMenu();
//
//            try {
//                opcion = Integer.parseInt(sc.nextLine());
//            } catch (NumberFormatException e) {
//                System.out.println("Ingreso inválido. Saliendo...");
//                break;
//            }
//
//            switch (opcion) {
//                case 1 -> agregarVehiculo(inventario, sc);
//                case 2 -> inventario.listarVehiculos();
//                case 3 -> buscarVehiculo(inventario, sc);
//                case 4 -> eliminarVehiculo(inventario, sc);
//                case 5 -> actualizarKilometraje(inventario, sc);
//                case 6 -> contarVehiculosConKm(inventario, sc);
//                case 7 -> listarPorMarca(inventario, sc);
//                case 0 -> System.out.println("👋 Fin del sistema.");
//                default -> System.out.println("Opción no válida.");
//            }
//
//        } while (true);
//
//        sc.close();
//    }
//
//    private static void agregarVehiculo(InventarioVehiculos inventario, Scanner sc) {
//        System.out.println("\nTipo de vehículo: 1-Auto | 2-Moto | 3-Colectivo");
//        int tipo;
//        try {
//            tipo = Integer.parseInt(sc.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Tipo inválido.");
//            return;
//        }
//
//        System.out.print("Marca: ");
//        String marca = sc.nextLine();
//
//        System.out.print("Modelo (año): ");
//        int modelo;
//        try {
//            modelo = Integer.parseInt(sc.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Modelo inválido.");
//            return;
//        }
//
//        System.out.print("Patente: ");
//        String patente = sc.nextLine();
//
//        System.out.print("Kilometraje: ");
//        int km;
//        try {
//            km = Integer.parseInt(sc.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Kilometraje inválido.");
//            return;
//        }
//
//        try {
//            Vehiculo v;
//            if (tipo == 1) {
//                System.out.print("Cantidad de puertas: ");
//                int puertas = Integer.parseInt(sc.nextLine());
//                v = new Auto(marca, modelo, patente, km, puertas);
//            } else if (tipo == 2) {
//                v = new Moto(marca, modelo, patente, km);
//            } else if (tipo == 3) {
//                System.out.print("Cantidad de asientos: ");
//                int asientos = Integer.parseInt(sc.nextLine());
//                v = new Colectivo(marca, modelo, patente, km, asientos);
//            } else {
//                System.out.println("Tipo no válido.");
//                return;
//            }
//
//            if (inventario.agregarVehiculo(v)) {
//                System.out.println("Vehículo agregado correctamente.");
//            } else {
//                System.out.println("Ya existe un vehículo con esa patente.");
//            }
//
//        } catch (PatenteInvalidaException e) {
//            System.out.println("Error en la patente: " + e.getMessage());
//        } catch (NumberFormatException e) {
//            System.out.println("Valor numérico inválido.");
//        }
//    }
//
//    private static void buscarVehiculo(InventarioVehiculos inventario, Scanner sc) {
//        System.out.print("Patente a buscar: ");
//        String patente = sc.nextLine();
//
//        Vehiculo v = inventario.buscarPorPatenteRecursivo(patente); // uso de función recursiva
//
//        if (v != null) {
//            System.out.println("Encontrado: " + v);
//            double costo = v.calcularCostoMantenimiento(10000);
//            System.out.printf("Costo estimado de mantenimiento: $%.2f%n", costo);
//        } else {
//            System.out.println("No se encontró vehículo con esa patente.");
//        }
//    }
//
//    private static void eliminarVehiculo(InventarioVehiculos inventario, Scanner sc) {
//        System.out.print("Patente a eliminar: ");
//        String patente = sc.nextLine();
//
//        if (inventario.eliminarVehiculo(patente)) {
//            System.out.println("Vehículo eliminado.");
//        } else {
//            System.out.println("No se encontró esa patente.");
//        }
//    }
//
//    private static void actualizarKilometraje(InventarioVehiculos inventario, Scanner sc) {
//        System.out.print("Patente a actualizar: ");
//        String patente = sc.nextLine();
//
//        System.out.print("Nuevo kilometraje: ");
//        try {
//            int km = Integer.parseInt(sc.nextLine());
//            if (inventario.actualizarKilometraje(patente, km)) {
//                System.out.println("Kilometraje actualizado.");
//            } else {
//                System.out.println("No se encontró esa patente.");
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Kilometraje inválido.");
//        }
//    }
//
//    private static void contarVehiculosConKm(InventarioVehiculos inventario, Scanner sc) {
//        System.out.print("Contar vehículos con km mayor a: ");
//        try {
//            int limite = Integer.parseInt(sc.nextLine());
//            int cantidad = inventario.contarConKmMayorA(limite);
//            System.out.println("Cantidad de vehículos con km > " + limite + ": " + cantidad);
//        } catch (NumberFormatException e) {
//            System.out.println("Valor inválido.");
//        }
//    }
//
//    private static void listarPorMarca(InventarioVehiculos inventario, Scanner sc) {
//        System.out.print("Fragmento de marca a buscar: ");
//        String frag = sc.nextLine();
//        inventario.listarVehiculosConMarca(frag);
//    }
//}