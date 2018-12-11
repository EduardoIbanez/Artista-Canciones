package dci.ufro.cl.artistascanciones.controller;

import dci.ufro.cl.artistascanciones.model.Artista;
import dci.ufro.cl.artistascanciones.model.Estilo;
import dci.ufro.cl.artistascanciones.model.data.ArtistaDAO;
import dci.ufro.cl.artistascanciones.model.data.EstiloDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("artista")
public class ArtistaController {

    @Autowired
    private ArtistaDAO artistaDAO;

    @Autowired
    private EstiloDAO estiloDAO;

   @RequestMapping(value = "")// muesta lista de artistas
    public String index(Model modelo) {

       modelo.addAttribute("artistas", artistaDAO.findAll()); //carga artistas
       modelo.addAttribute(new Artista()); // guarda datos para nuevo artista submit
       modelo.addAttribute("estilos", estiloDAO.findAll()); // carga estilos
       return "artista/index";
    }


    @RequestMapping(value = "", method = RequestMethod.POST) // agregar artistas
    public String agregarArtistas(@ModelAttribute Artista a,
                                            @RequestParam int estilo) {

        Optional<Estilo> est = estiloDAO.findById(estilo);
        a.setEstilo(est.get());
        artistaDAO.save(a);
        return "redirect:/artista";
    }

    @RequestMapping(value = "borrar/{id}", method = RequestMethod.GET)
    public String eliminarArtista(@PathVariable("id") int id){

        artistaDAO.deleteById(id);
        return "redirect:/artista";
    }
//
//    @RequestMapping(value = "editar/{id}", method = RequestMethod.)
//    public String editarArtista(){
//
//
//       return "redirect:/artista";
//    }


}
