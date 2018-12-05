package dci.ufro.cl.artistascanciones.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Cancion {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String titulo;

    @NotNull
    private double duracion;

    @ManyToOne
    private Artista artista;

    @ManyToOne
    private Estilo estilo;


    public Cancion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", artista=" + artista +
                ", estilo=" + estilo +
                '}';
    }
}
