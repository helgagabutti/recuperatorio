//Perfecto, hacemos ahora el mismo modelo de parcial, pero con el tema VETERINARIA, como si fuera otro “tema” del ZIP, igual a Concesionaria pero con mascotas.
//
//Te dejo un mini–proyecto completo en Java con:
//
//Animal (abstracta)
//
//Perro y Gato (subclases)
//
//Interface Atencion (costo de consulta)
//
//Excepción EdadInvalidaException (checked)
//
//ClinicaVeterinaria (inventario con ArrayList)
//
//Menu y Main con CRUD por consola
//
//Recursividad, lambdas, equals/hashCode, validaciones, etc.
//
//Package usado:
//
//package Parciales.Parcial2025.Segundo.Veterinaria;
//
//1️⃣ Interface Atencion
//package Parciales.Parcial2025.Segundo.Veterinaria;
//
/// **
// * Define operaciones de atención veterinaria.
// */
//public interface Atencion {
//
//    /**
//     * Calcula el costo de la atención/consulta de la mascota.
//     *
//     * @param costoBase costo base de la consulta
//     * @return costo final calculado
//     */
//    double calcularCostoAtencion(double costoBase);
//}
//
//2️⃣ Excepción EdadInvalidaException
//package Parciales.Parcial2025.Segundo.Veterinaria;
//
///**
// * Excepción verificada que se lanza cuando se intenta crear
// * una mascota con una edad no válida.
// */
//public class EdadInvalidaException extends Exception {
//
//    public EdadInvalidaException() {
//        super("Edad inválida: la mascota debe tener entre 0 y 30 años.");
//    }
//
//    public EdadInvalidaException(String mensaje) {
//        super(mensaje);
//    }
//}
//
//3️⃣ Clase abstracta Animal
//package Parciales.Parcial2025.Segundo.Veterinaria;
//
//import java.util.Objects;
//
///**
// * Contexto:
// * Sistema de administración de pacientes para una clínica veterinaria.
// * Cada Animal es un paciente registrado con una historia clínica.
// */
//public abstract class Animal implements Atencion {
//
//    private String codigo;   // identificador único (ej: nro historia clínica)
//    private String nombre;
//    private String especie;  // "Perro", "Gato", etc.
//    private int    edad;     // en años
//    private double peso;     // en kg
//
//    public Animal(String codigo, String nombre, String especie,
//                  int edad, double peso) throws EdadInvalidaException {
//
//        setCodigo(codigo);
//        setNombre(nombre);
//        setEspecie(especie);
//        setEdad(edad);
//        setPeso(peso);
//    }
//
//    // ===== Getters / Setters =====
//
//    public String getCodigo() { return codigo; }
//    public String getNombre() { return nombre; }
//    public String getEspecie() { return especie; }
//    public int getEdad() { return edad; }
//    public double getPeso() { return peso; }
//
//    public void setCodigo(String codigo) {
//        if (codigo == null) codigo = "";
//        this.codigo = codigo.trim().toUpperCase();
//    }
//
//    public void setNombre(String nombre) {
//        if (nombre == null) nombre = "";
//        this.nombre = nombre.trim();
//    }
//
//    public void setEspecie(String especie) {
//        if (especie == null) especie = "";
//        this.especie = especie.trim();
//    }
//
//    public void setEdad(int edad) throws EdadInvalidaException {
//        if (edad < 0 || edad > 30) {
//            throw new EdadInvalidaException("Edad inválida: " + edad + " años.");
//        }
//        this.edad = edad;
//    }
//
//    public void setPeso(double peso) {
//        if (peso < 0) peso = 0;
//        this.peso = peso;
//    }
//
//    // Método abstracto que las subclases deben implementar
//    public abstract String verTipo();
//
//    // ====== equals y hashCode por codigo (historia clínica) ======
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Animal animal = (Animal) o;
//        return codigo.equalsIgnoreCase(animal.codigo);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(codigo.toUpperCase());
//    }
//
//    @Override
//    public String toString() {
//        return verTipo() + "\t" + codigo + "\t" + nombre + "\t" +
//               especie + "\t" + edad + " años\t" + peso + " Kg";
//    }
//
//    // ===== Sobrecarga de método (mismo nombre, distinto parámetro) =====
//    public double calcularCostoAtencion(double costoBase, double recargoExtra) {
//        return calcularCostoAtencion(costoBase) + recargoExtra;
//    }
//}
//
//4️⃣ Subclase Perro
//package Parciales.Parcial2025.Segundo.Veterinaria;
//
//public class Perro extends Animal {
//
//    private boolean esDeRaza;
//
//    public Perro(String codigo, String nombre, int edad,
//                 double peso, boolean esDeRaza)
//            throws EdadInvalidaException {
//
//        super(codigo, nombre, "Perro", edad, peso);
//        this.esDeRaza = esDeRaza;
//    }
//
//    public boolean isEsDeRaza() { return esDeRaza; }
//    public void setEsDeRaza(boolean esDeRaza) { this.esDeRaza = esDeRaza; }
//
//    @Override
//    public String verTipo() {
//        return "PERRO";
//    }
//
//    // Sobrescritura del método de la interface Atencion
//    @Override
//    public double calcularCostoAtencion(double costoBase) {
//        double costo = costoBase;
//
//        // Perros mayores tienen controles más caros
//        if (getEdad() > 10) {
//            costo *= 1.20; // +20%
//        }
//
//        // Si es de raza, un pequeño extra
//        if (esDeRaza) {
//            costo *= 1.10; // +10%
//        }
//
//        return costo;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + "\t" + (esDeRaza ? "Raza" : "Mestizo");
//    }
//}
//
//5️⃣ Subclase Gato
//package Parciales.Parcial2025.Segundo.Veterinaria;
//
//public class Gato extends Animal {
//
//    private boolean viveDentroDeCasa;
//
//    public Gato(String codigo, String nombre, int edad,
//                double peso, boolean viveDentroDeCasa)
//            throws EdadInvalidaException {
//
//        super(codigo, nombre, "Gato", edad, peso);
//        this.viveDentroDeCasa = viveDentroDeCasa;
//    }
//
//    public boolean isViveDentroDeCasa() { return viveDentroDeCasa; }
//    public void setViveDentroDeCasa(boolean v) { this.viveDentroDeCasa = v; }
//
//    @Override
//    public String verTipo() {
//        return "GATO";
//    }
//
//    @Override
//    public double calcularCostoAtencion(double costoBase) {
//        double costo = costoBase;
//
//        // Gatos de interior suelen tener menos riesgos → leve descuento
//        if (viveDentroDeCasa) {
//            costo *= 0.9; // -10%
//        }
//
//        // Gatos muy viejos pueden tener chequeos más caros
//        if (getEdad() > 12) {
//            costo *= 1.15; // +15%
//        }
//
//        return costo;
//    }
//
//    @Override
//    public String toString() {
//        return super.toString() + "\t" +
//               (viveDentroDeCasa ? "Interior" : "Exterior");
//    }
//}
//
//6️⃣ Clase ClinicaVeterinaria (Inventario + Recursividad + Lambdas)
//package Parciales.Parcial2025.Segundo.Veterinaria;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ClinicaVeterinaria {
//
//    // "Variables globales" de la clase: listas de pacientes por tipo
//    private List<Perro> perros;
//    private List<Gato> gatos;
//
//    public ClinicaVeterinaria() {
//        perros = new ArrayList<>();
//        gatos  = new ArrayList<>();
//    }
//
//    // ================= ALTAS =================
//
//    public boolean agregarPerro(Perro p) {
//        if (existeAnimal(p.getCodigo())) return false;
//        perros.add(p);
//        return true;
//    }
//
//    public boolean agregarGato(Gato g) {
//        if (existeAnimal(g.getCodigo())) return false;
//        gatos.add(g);
//        return true;
//    }
//
//    // =============== BUSCAR (tipo modelo parcial) ===============
//
//    public Animal buscarAnimal(String codigo) {
//        if (codigo == null) return null;
//        String buscado = codigo.toUpperCase();
//
//        // Primero buscar en perros
//        for (Perro p : perros) {
//            if (p.getCodigo().equalsIgnoreCase(buscado)) {
//                return p;
//            }
//        }
//
//        // Luego buscar en gatos
//        for (Gato g : gatos) {
//            if (g.getCodigo().equalsIgnoreCase(buscado)) {
//                return g;
//            }
//        }
//
//        return null;
//    }
//
//    // Versión recursiva de búsqueda
//    public Animal buscarAnimalRecursivo(String codigo) {
//        if (codigo == null) return null;
//        String buscado = codigo.toUpperCase();
//
//        // Unificamos ambas listas en una solo para la recursión
//        ArrayList<Animal> todos = new ArrayList<>();
//        todos.addAll(perros);
//        todos.addAll(gatos);
//
//        return buscarRec(buscado, todos, 0);
//    }
//
//    private Animal buscarRec(String codigo, ArrayList<Animal> lista, int i) {
//        if (i >= lista.size()) return null;
//        Animal actual = lista.get(i);
//        if (actual.getCodigo().equalsIgnoreCase(codigo)) {
//            return actual;
//        }
//        return buscarRec(codigo, lista, i + 1);
//    }
//
//    // =============== ELIMINAR ===============
//
//    public boolean eliminarAnimal(String codigo) {
//        if (codigo == null) return false;
//        String buscado = codigo.toUpperCase();
//
//        boolean elimPerro = perros.removeIf(p -> p.getCodigo().equalsIgnoreCase(buscado));
//        boolean elimGato  = gatos.removeIf(g -> g.getCodigo().equalsIgnoreCase(buscado));
//
//        return elimPerro || elimGato;
//    }
//
//    // =============== ACTUALIZAR ===============
//
//    public boolean actualizarPerro(String codigo, Perro actualizado) {
//        if (codigo == null) return false;
//        String buscado = codigo.toUpperCase();
//
//        for (int i = 0; i < perros.size(); i++) {
//            if (perros.get(i).getCodigo().equalsIgnoreCase(buscado)) {
//                perros.set(i, actualizado);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public boolean actualizarGato(String codigo, Gato actualizado) {
//        if (codigo == null) return false;
//        String buscado = codigo.toUpperCase();
//
//        for (int i = 0; i < gatos.size(); i++) {
//            if (gatos.get(i).getCodigo().equalsIgnoreCase(buscado)) {
//                gatos.set(i, actualizado);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    // =============== CONSULTAS / ESTADÍSTICAS ===============
//
//    public int getCantidadTotalAnimales() {
//        return perros.size() + gatos.size();
//    }
//
//    public boolean existeAnimal(String codigo) {
//        return buscarAnimal(codigo) != null;
//    }
//
//    // Recursividad: contar mascotas mayores a cierta edad
//    public int contarMayoresQue(int edadMin) {
//        ArrayList<Animal> todos = new ArrayList<>();
//        todos.addAll(perros);
//        todos.addAll(gatos);
//        return contarMayoresRec(todos, edadMin, 0);
//    }
//
//    private int contarMayoresRec(ArrayList<Animal> lista, int edadMin, int i) {
//        if (i >= lista.size()) return 0;
//        int suma = (lista.get(i).getEdad() > edadMin) ? 1 : 0;
//        return suma + contarMayoresRec(lista, edadMin, i + 1);
//    }
//
//    // Listar usando forEach y lambdas
//    public void listarAnimales() {
//        System.out.println("\n=== PERROS (" + perros.size() + ") ===");
//        perros.forEach(System.out::println);
//
//        System.out.println("\n=== GATOS (" + gatos.size() + ") ===");
//        gatos.forEach(System.out::println);
//
//        System.out.println("\nTotal de animales: " + getCantidadTotalAnimales());
//    }
//
//    // Ejemplo de uso de stream + filter + contains()
//    public void listarPorNombreContiene(String fragmento) {
//        String frag = fragmento.toLowerCase();
//
//        ArrayList<Animal> todos = new ArrayList<>();
//        todos.addAll(perros);
//        todos.addAll(gatos);
//
//        System.out.println("\nMascotas cuyo nombre contiene \"" + fragmento + "\":");
//
//        todos.stream()
//                .filter(a -> a.getNombre().toLowerCase().contains(frag))
//                .forEach(System.out::println);
//    }
//}
//
//7️⃣ Clase Menu
//package Parciales.Parcial2025.Segundo.Veterinaria;
//
//public class Menu {
//
//    public void mostrarMenuPrincipal() {
//        System.out.println("\n===== CLÍNICA VETERINARIA =====");
//        System.out.println("1. Agregar Perro");
//        System.out.println("2. Agregar Gato");
//        System.out.println("3. Listar todas las mascotas");
//        System.out.println("4. Buscar mascota por código");
//        System.out.println("5. Eliminar mascota");
//        System.out.println("6. Actualizar Perro");
//        System.out.println("7. Actualizar Gato");
//        System.out.println("8. Contar mascotas mayores a X años (recursivo)");
//        System.out.println("9. Listar por fragmento de nombre");
//        System.out.println("0. Salir");
//        System.out.print("Opción: ");
//    }
//}
//
//8️⃣ Clase Main (consola + CRUD + recursividad)
//package Parciales.Parcial2025.Segundo.Veterinaria;
//
//import java.util.Scanner;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        ClinicaVeterinaria clinica = new ClinicaVeterinaria();
//        Menu menu = new Menu();
//        Scanner sc = new Scanner(System.in);
//
//        int opcion;
//
//        do {
//            menu.mostrarMenuPrincipal();
//            String input = sc.nextLine();
//
//            try {
//                opcion = Integer.parseInt(input);
//            } catch (NumberFormatException e) {
//                System.out.println("Entrada inválida. Saliendo...");
//                break;
//            }
//
//            switch (opcion) {
//                case 1 -> agregarPerro(clinica, sc);
//                case 2 -> agregarGato(clinica, sc);
//                case 3 -> clinica.listarAnimales();
//                case 4 -> buscarMascota(clinica, sc);
//                case 5 -> eliminarMascota(clinica, sc);
//                case 6 -> actualizarPerro(clinica, sc);
//                case 7 -> actualizarGato(clinica, sc);
//                case 8 -> contarMayores(clinica, sc);
//                case 9 -> listarPorNombre(clinica, sc);
//                case 0 -> System.out.println("👋 Fin del sistema.");
//                default -> System.out.println("Opción no válida.");
//            }
//
//            if (opcion != 0) {
//                System.out.println("\nPresione Enter para continuar...");
//                sc.nextLine();
//            }
//
//        } while (opcion != 0);
//
//        sc.close();
//    }
//
//    // ================= MÉTODOS PRIVADOS =================
//
//    private static void agregarPerro(ClinicaVeterinaria clinica, Scanner sc) {
//        try {
//            System.out.println("\n--- Nuevo Perro ---");
//            System.out.print("Código: ");
//            String codigo = sc.nextLine();
//            System.out.print("Nombre: ");
//            String nombre = sc.nextLine();
//            System.out.print("Edad: ");
//            int edad = Integer.parseInt(sc.nextLine());
//            System.out.print("Peso (kg): ");
//            double peso = Double.parseDouble(sc.nextLine());
//            System.out.print("Es de raza? (s/n): ");
//            boolean esDeRaza = sc.nextLine().trim().equalsIgnoreCase("s");
//
//            Perro p = new Perro(codigo, nombre, edad, peso, esDeRaza);
//
//            if (clinica.agregarPerro(p)) {
//                System.out.println("✅ Perro agregado correctamente.");
//            } else {
//                System.out.println("❌ Ya existe una mascota con ese código.");
//            }
//
//        } catch (EdadInvalidaException e) {
//            System.out.println("❌ Error de edad: " + e.getMessage());
//        } catch (NumberFormatException e) {
//            System.out.println("❌ Error de formato numérico.");
//        }
//    }
//
//    private static void agregarGato(ClinicaVeterinaria clinica, Scanner sc) {
//        try {
//            System.out.println("\n--- Nuevo Gato ---");
//            System.out.print("Código: ");
//            String codigo = sc.nextLine();
//            System.out.print("Nombre: ");
//            String nombre = sc.nextLine();
//            System.out.print("Edad: ");
//            int edad = Integer.parseInt(sc.nextLine());
//            System.out.print("Peso (kg): ");
//            double peso = Double.parseDouble(sc.nextLine());
//            System.out.print("Vive dentro de casa? (s/n): ");
//            boolean interior = sc.nextLine().trim().equalsIgnoreCase("s");
//
//            Gato g = new Gato(codigo, nombre, edad, peso, interior);
//
//            if (clinica.agregarGato(g)) {
//                System.out.println("✅ Gato agregado correctamente.");
//            } else {
//                System.out.println("❌ Ya existe una mascota con ese código.");
//            }
//
//        } catch (EdadInvalidaException e) {
//            System.out.println("❌ Error de edad: " + e.getMessage());
//        } catch (NumberFormatException e) {
//            System.out.println("❌ Error de formato numérico.");
//        }
//    }
//
//    private static void buscarMascota(ClinicaVeterinaria clinica, Scanner sc) {
//        System.out.print("\nCódigo a buscar: ");
//        String codigo = sc.nextLine();
//
//        Animal a = clinica.buscarAnimalRecursivo(codigo); // usamos versión recursiva
//
//        if (a != null) {
//            System.out.println("✅ Mascota encontrada:");
//            System.out.println(a);
//            double costo = a.calcularCostoAtencion(5000);
//            System.out.printf("Costo estimado de atención: $%.2f%n", costo);
//        } else {
//            System.out.println("❌ No se encontró mascota con ese código.");
//        }
//    }
//
//    private static void eliminarMascota(ClinicaVeterinaria clinica, Scanner sc) {
//        System.out.print("\nCódigo a eliminar: ");
//        String codigo = sc.nextLine();
//
//        if (clinica.eliminarAnimal(codigo)) {
//            System.out.println("✅ Mascota eliminada.");
//        } else {
//            System.out.println("❌ No se encontró mascota con ese código.");
//        }
//    }
//
//    private static void actualizarPerro(ClinicaVeterinaria clinica, Scanner sc) {
//        System.out.print("\nCódigo del Perro a actualizar: ");
//        String codigo = sc.nextLine();
//
//        Animal existe = clinica.buscarAnimal(codigo);
//        if (!(existe instanceof Perro)) {
//            System.out.println("❌ No se encontró un perro con ese código.");
//            return;
//        }
//
//        try {
//            System.out.println("Nuevos datos del perro:");
//            System.out.print("Nombre: ");
//            String nombre = sc.nextLine();
//            System.out.print("Edad: ");
//            int edad = Integer.parseInt(sc.nextLine());
//            System.out.print("Peso (kg): ");
//            double peso = Double.parseDouble(sc.nextLine());
//            System.out.print("Es de raza? (s/n): ");
//            boolean esDeRaza = sc.nextLine().trim().equalsIgnoreCase("s");
//
//            Perro actualizado = new Perro(codigo, nombre, edad, peso, esDeRaza);
//
//            if (clinica.actualizarPerro(codigo, actualizado)) {
//                System.out.println("✅ Perro actualizado.");
//            } else {
//                System.out.println("❌ Error al actualizar el perro.");
//            }
//
//        } catch (EdadInvalidaException | NumberFormatException e) {
//            System.out.println("❌ Error: " + e.getMessage());
//        }
//    }
//
//    private static void actualizarGato(ClinicaVeterinaria clinica, Scanner sc) {
//        System.out.print("\nCódigo del Gato a actualizar: ");
//        String codigo = sc.nextLine();
//
//        Animal existe = clinica.buscarAnimal(codigo);
//        if (!(existe instanceof Gato)) {
//            System.out.println("❌ No se encontró un gato con ese código.");
//            return;
//        }
//
//        try {
//            System.out.println("Nuevos datos del gato:");
//            System.out.print("Nombre: ");
//            String nombre = sc.nextLine();
//            System.out.print("Edad: ");
//            int edad = Integer.parseInt(sc.nextLine());
//            System.out.print("Peso (kg): ");
//            double peso = Double.parseDouble(sc.nextLine());
//            System.out.print("Vive dentro de casa? (s/n): ");
//            boolean interior = sc.nextLine().trim().equalsIgnoreCase("s");
//
//            Gato actualizado = new Gato(codigo, nombre, edad, peso, interior);
//
//            if (clinica.actualizarGato(codigo, actualizado)) {
//                System.out.println("✅ Gato actualizado.");
//            } else {
//                System.out.println("❌ Error al actualizar el gato.");
//            }
//
//        } catch (EdadInvalidaException | NumberFormatException e) {
//            System.out.println("❌ Error: " + e.getMessage());
//        }
//    }
//
//    private static void contarMayores(ClinicaVeterinaria clinica, Scanner sc) {
//        System.out.print("\nContar mascotas con edad mayor a: ");
//        try {
//            int edad = Integer.parseInt(sc.nextLine());
//            int cant = clinica.contarMayoresQue(edad);
//            System.out.println("Hay " + cant +
//                    " mascotas con edad > " + edad + " años.");
//        } catch (NumberFormatException e) {
//            System.out.println("❌ Valor de edad inválido.");
//        }
//    }
//
//    private static void listarPorNombre(ClinicaVeterinaria clinica, Scanner sc) {
//        System.out.print("\nFragmento de nombre a buscar: ");
//        String frag = sc.nextLine();
//        clinica.listarPorNombreContiene(frag);
//    }
//}
//
//
//Con esto tenés el modelo de parcial resuelto con el tema Veterinaria, siguiendo la misma lógica y nivel de complejidad que el de Concesionaria y lo que piden en el PDF del modelo.
//
//Si querés, después te hago un resumen tipo “chuleta” donde te marco:
//
//qué parte del código responde a recursividad,
//
//qué parte es POO (herencia, polimorfismo, sobrecarga),
//
//qué parte es excepciones,
//
//qué parte es colecciones + lambdas,
//
//para que puedas defenderlo en el parcial.
