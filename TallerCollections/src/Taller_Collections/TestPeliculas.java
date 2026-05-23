package Taller_Collections;

import java.util.*;

public class TestPeliculas {

    private static Scanner sc = new Scanner(System.in);
    private static List<Pelicula> listaPeliculas = new ArrayList<>();
    private static Set<Pelicula> setPeliculas = new HashSet<>();
    private static Map<String, List<Pelicula>> mapaPorGenero = new HashMap<>();

    public static void main(String[] args) {

        agregarPeliculaEjemplo("The Devil Wears Prada 2", "David Frankel", "Comedia", 112, 2026, 6.8);
        agregarPeliculaEjemplo("Inside Out 2", "Kesley Mann", "Animación", 96, 2024, 7.7);
        agregarPeliculaEjemplo("Moana 2", "David G. y Derrick Jr", "Animación", 100, 2024, 6.8);
        agregarPeliculaEjemplo("Lilo y Stitch", "Dean Fleischer Camp", "Fantasia", 112, 2025, 7.0);
        agregarPeliculaEjemplo("Terrifier 4", "Damien Leone", "Terror", 118, 2026, 6.5);

        agregarPeliculaEjemplo("Inside Out 2", "Kesley Mann", "Animación", 96, 2024, 7.7);

        int opcion = -1;

        while (opcion != 7) {
            System.out.println("\n-------- sistema de Películas ------");
            System.out.println("1. Lista de películas");
            System.out.println("2. Agregar nueva película ");
            System.out.println("3. Buscar película ");
            System.out.println("4. Ver películas por genero");
            System.out.println("5. Ordenar películas por duración");
            System.out.println("6. Ver películas ordenadas por nombre");
            System.out.println("7. salir");
            System.out.print("Ingrese una Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: verTodas(); break;
                case 2: agregarPeliculaScanner(); break;
                case 3: buscarPelicula(); break;
                case 4: verPorGenero(); break;
                case 5: ordenarPorDuracion(); break;
                case 6: verTreeSetOrdenado(); break;
                case 7: System.out.println("salir del sistema"); break;
                default: System.out.println("la opción no es valida");
            }
        } sc.close();
    }

    private static int numPeli = 0;

    private static void agregarPeliculaEjemplo(String nombre, String director, String genero, int duracion, int anio, double rating) {
        Pelicula p = new Pelicula(nombre, director, genero, duracion, anio, rating);

        if (setPeliculas.add(p)) {
            listaPeliculas.add(p);
            numPeli++;
            mapaPorGenero.computeIfAbsent(genero, k -> new ArrayList<>()).add(p);
            System.out.println("Película " + numPeli + ": " + nombre);
        } else {
            System.out.println("La película ingresada ya existe " + nombre);
        }
    }

    private static void agregarPeliculaScanner() {
        System.out.println("\n---------------------Nueva Película registrada------------------------");
        System.out.print("Ingrese el nombre de la Película: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese en nombre del Director: ");
        String director = sc.nextLine();
        System.out.print("Ingrese el Género de la película: ");
        String genero = sc.nextLine();
        System.out.print("Ingrese la Duración de la película minutos: ");
        int duracion = sc.nextInt();
        System.out.print("Año de estreno: ");
        int anio = sc.nextInt();
        System.out.println(" Rating Pelicula 1-10 (Ejem: 2,3) ");
        System.out.print("Ingresa el Rating: ");
        double rating = sc.nextDouble();
        sc.nextLine();

        Pelicula p = new Pelicula(nombre, director, genero, duracion, anio, rating);
        if (setPeliculas.add(p)) {
            listaPeliculas.add(p);
            mapaPorGenero.computeIfAbsent(genero, k -> new ArrayList<>()).add(p);
            System.out.println("La Película fue agregada correctamente");
        } else {
            System.out.println("La película no fue agregado a la Lista de Peliculas por que ya existe");
        }
    }

    private static void verTodas() {
        System.out.println("\n--------Películas Registradas-------");
        if (listaPeliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
        } else {
            for (Pelicula p : listaPeliculas) {
                System.out.println(" " + p);
            }
        }
    }

    private static void buscarPelicula() {
        System.out.println("--------------------Buscar Película------------------------------");
        System.out.print("\nIngrese el nombre de la película: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el año de estreno: ");
        int anio = sc.nextInt();
        sc.nextLine();

        boolean encontrada = false;
        for (Pelicula p : listaPeliculas) {
            if (p.getNombre().equalsIgnoreCase(nombre) && p.getAnioEstreno() == anio) {
                System.out.println("La película si existe en la Lista Películas" + p);
                encontrada = true;
            }
        }
        if (!encontrada) System.out.println("La película no existe en la lista");

        System.out.println("\nBúsqueda con Set");
        encontrada = false;
        for (Pelicula p : setPeliculas) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("La pelicula se encontro en el Set");
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("La pelicula no se encontro en el Set");
        }

        System.out.println("Busqueda con Map");
        encontrada = false;
        for (Map.Entry<String, List<Pelicula>> entry : mapaPorGenero.entrySet()) {
            for (Pelicula p : entry.getValue()) {
                if (p.getNombre().equalsIgnoreCase(nombre) && p.getAnioEstreno() == anio) {
                    System.out.println(" El genero fue encontrado '" + entry.getKey() + "': " + p);
                    encontrada = true;
                }
            }
        }
        if (!encontrada) System.out.println("No se encontró en el registro de Map");
    }

    private static void verPorGenero() {
        System.out.println("\nPelículas por genero:");
        if (mapaPorGenero.isEmpty()) {
            System.out.println("No hay películas registradas por genero");
        } else {
            for (Map.Entry<String, List<Pelicula>> entry : mapaPorGenero.entrySet()) {
                System.out.println("\n" + entry.getKey().toUpperCase());
                for (Pelicula p : entry.getValue()) {
                    System.out.println("  " + p);
                }
            }
        }
    }

    private static void ordenarPorDuracion() {
        listaPeliculas.sort(new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula p1, Pelicula p2) {
                return Integer.compare(p1.getDuracion(), p2.getDuracion());
            }
        });

        System.out.println("\nPelículas ordenadas por duración");
        for (Pelicula p : listaPeliculas) {
            System.out.println("   • " + p.getDuracion() + " min  " + p.getNombre());
        }
    }

    private static void verTreeSetOrdenado() {
        TreeSet<Pelicula> treeSet = new TreeSet<>(new Comparator<Pelicula>() {
            @Override
            public int compare(Pelicula p1, Pelicula p2) {
                return p1.getNombre().compareTo(p2.getNombre());
            }
        });

        treeSet.addAll(listaPeliculas);

        System.out.println("\nPelículas ordenadas por nombre");
        for (Pelicula p : treeSet) {
            System.out.println(" " + p.getNombre() + "\t" + p);
        }
    }
}