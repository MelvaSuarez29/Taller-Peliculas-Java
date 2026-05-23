package Taller_Collections;

import java.util.Objects;

public class Pelicula {
    private String nombre;
    private String director;
    private String genero;
    private int duracion;
    private int anioEstreno;
    private double rating;

    public Pelicula(String nombre, String director, String genero, int duracion, int anioEstreno, double rating) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.anioEstreno = anioEstreno;
        this.rating = rating;
    }

    public String getNombre() { return nombre; }
    public String getDirector() { return director; }
    public String getGenero() { return genero; }
    public int getDuracion() { return duracion; }
    public int getAnioEstreno() { return anioEstreno; }
    public double getRating() { return rating; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDirector(String director) { this.director = director; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
    public void setAnioEstreno(int anioEstreno) { this.anioEstreno = anioEstreno; }
    public void setRating(double rating) { this.rating = rating; }

    @Override
    public String toString() {
        return "Pelicula \t" +
                "nombre='" + nombre +
                ", \tdirector='" + director +
                ", \tgenero='" + genero +
                ", \tduracion=" + duracion +
                ", \tanioEstreno=" + anioEstreno +
                ", \trating=" + rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return anioEstreno == pelicula.anioEstreno && Objects.equals(nombre, pelicula.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, anioEstreno);
    }
}