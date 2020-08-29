package com.uabc.proyecto.proyecto.controller;

import com.uabc.proyecto.proyecto.model.Fproducto;
import com.uabc.proyecto.proyecto.service.FarmaciaService;
import com.uabc.proyecto.proyecto.service.security.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FarmaciaController {
    @Autowired
    private FarmaciaService service;
    @Autowired
    private UserServiceImpl service1;

    @GetMapping("/")
    public String index(Model model, Model model1){
        model.addAttribute("fproductos", service.obtenerTodosFproducto());
        model1.addAttribute("user", service1.actual());
        return "farmacia";
    }
    @GetMapping("AgregarFarmacia")
    public String registrar(Fproducto fproducto, Model model1){
        model1.addAttribute("user", service1.actual());
        return "add-farmacia";
    }

    @PostMapping("/AddFarmacia")
    public String addUser(Fproducto fproducto, BindingResult result, Model model){

        if(result.hasErrors()){
            return "add-farmacia";
        }
        service.registrarFproducto(fproducto);
        return "redirect:/";
    }

    @GetMapping("EliminarFarmacia/{id}")
    public String eliminar(@PathVariable("id") long laID, Model model, Model model1){
        service.eliminarFproducto(laID);
        model1.addAttribute("user", service1.actual());
        model.addAttribute("fproductos",service.obtenerTodosFproducto());
        return"redirect:/";
    }

    @PostMapping("/ActualizarFarmacia/{id}")
    public String actualizarFproducto(@PathVariable("id")long id, Fproducto fproducto, BindingResult result, Model model){
        if(result.hasErrors()) {
            fproducto.setId(id);
            return "update-farmacia";
        }
        service.actualizarFproducto(fproducto);
        // model.addAttribute("users", service.obtenerTodosUsuario());
        //return "redirect:/index";

        return "redirect:/";
    }

    @GetMapping("/EditarFarmacia/{id}")
    public String editarFproducto(@PathVariable("id")long id, Model model, Model model1){
        model1.addAttribute("user", service1.actual());
        Fproducto fproducto = service.obtenerFproductoPorID(id);
        model.addAttribute("fproducto", fproducto);
        return "update-farmacia";


    }
}

