package dci.ufro.cl.artistascanciones.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estilo {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String nombre;

    @OneToMany
    @JoinColumn(name = "estilo_id")
    private List<Artista> artistas = new ArrayList<Artista>();

    @OneToMany
    @JoinColumn(name = "estilo_id")
    private List<Cancion> canciones = new ArrayList<Cancion>();


    public Estilo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Estilo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", artistas=" + artistas +
                ", canciones=" + canciones +
                '}';
    }
}
