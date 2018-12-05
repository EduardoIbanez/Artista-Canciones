package dci.ufro.cl.artistascanciones.controller;

import dci.ufro.cl.artistascanciones.model.Estilo;
import dci.ufro.cl.artistascanciones.model.data.EstiloDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("estilo")
public class EstiloController {

    @Autowired
    private EstiloDAO estiloDAO;

    @RequestMapping(value = "")
    public String index(Model modelo){

        modelo.addAttribute("estilos",estiloDAO.findAll());
        modelo.addAttribute("tituloTabla", "Listar Estilos");
        modelo.addAttribute("tituloFormulario", "Ingresar Estilo Musical");
        modelo.addAttribute(new Estilo());
        return "estilo/index";
    }

//    @RequestMapping(value = "add", method = RequestMethod.GET)
//    public String desplegarFormularioEstilo(Model modelo){
//
//        modelo.addAttribute("tituloFormulario", "Ingresar Estilo Musical");
//
//        return "estilo/index";
//    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String procesarFormularioEstilo(@ModelAttribute Estilo e){

        estiloDAO.save(e);
        return "redirect:/estilo";
    }
}
