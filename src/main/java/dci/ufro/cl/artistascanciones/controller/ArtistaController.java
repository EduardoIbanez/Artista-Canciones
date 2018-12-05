package dci.ufro.cl.artistascanciones.controller;

import dci.ufro.cl.artistascanciones.model.Artista;
import dci.ufro.cl.artistascanciones.model.Estilo;
import dci.ufro.cl.artistascanciones.model.data.ArtistaDAO;
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
@RequestMapping("artista")
public class ArtistaController {

    @Autowired
    private ArtistaDAO artistaDAO;

    @Autowired
    private EstiloDAO estiloDAO;

   @RequestMapping(value = "")
    public String index(Model modelo) {
        modelo.addAttribute("artistas", artistaDAO.findAll());
        modelo.addAttribute(new Artista());
        modelo.addAttribute("estilos", estiloDAO.findAll());
        return "artista/index";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String procesarFormularioPersona(@ModelAttribute Artista a,
                                            @RequestParam int estiloId,
                                            Model model) {

        Optional<Estilo> est = estiloDAO.findById(estiloId);
        a.setEstilo(est.get());
        artistaDAO.save(a);
        return "redirect:/artista";
    }
}
