package dci.ufro.cl.artistascanciones.controller;

import dci.ufro.cl.artistascanciones.model.Artista;
import dci.ufro.cl.artistascanciones.model.Cancion;
import dci.ufro.cl.artistascanciones.model.Estilo;
import dci.ufro.cl.artistascanciones.model.data.ArtistaDAO;
import dci.ufro.cl.artistascanciones.model.data.CancionDAO;
import dci.ufro.cl.artistascanciones.model.data.EstiloDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("cancion")
public class CancionController {

    @Autowired
    private CancionDAO cancionDAO;

    @Autowired
    private ArtistaDAO artistaDAO;

    @Autowired
    private EstiloDAO estiloDAO;

    @RequestMapping(value = "")
    public String index(Model modelo) {

        modelo.addAttribute("tituloTabla", "Lista de Canciones");
        modelo.addAttribute("canciones", cancionDAO.findAll());
        return "cancion/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String mostrarFormularioCancion(Model modelo) {

        modelo.addAttribute("tituloFormulario", "Ingreso de Canciones");
        modelo.addAttribute("estilos", estiloDAO.findAll() );
        modelo.addAttribute(new Cancion());
        return "cancion/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String procesarFormularioCancion(@ModelAttribute Cancion c,
                                            @RequestParam int estilo) {

        Optional<Estilo> est = estiloDAO.findById(estilo);
        c.setEstilo(est.get());
        cancionDAO.save(c);
        return "redirect:";
    }
}
