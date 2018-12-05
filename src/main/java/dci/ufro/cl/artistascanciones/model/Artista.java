package dci.ufro.cl.artistascanciones.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Artista {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private  String nombre;

    @ManyToOne
    private Estilo estilo;

    @OneToMany
    @JoinColumn(name = "artista_id")
    private List<Cancion> canciones = new ArrayList<Cancion>();

    public Artista() {
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

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estilo=" + estilo +
                ", canciones=" + canciones +
                '}';
    }
}
