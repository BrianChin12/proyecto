package com.uabc.proyecto.proyecto.controller;

import com.uabc.proyecto.proyecto.model.Empleado;
import com.uabc.proyecto.proyecto.service.EmpleadoService;
import com.uabc.proyecto.proyecto.service.security.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmpleadoController {
    @Autowired
    private EmpleadoService service;
    @Autowired
    private UserServiceImpl service1;

    @GetMapping("/Empleado")
    public String index(Model model, Model model1){
        model.addAttribute("empleado", service.obtenerTodosEmpleado());
        model1.addAttribute("user", service1.actual());
        return "empleado";
    }
    @GetMapping("AgregarEmpleado")
    public String registrar(Empleado empleado, Model model1)
    {
        model1.addAttribute("user", service1.actual());
        return "add-empleado";

    }

    @PostMapping("/AddEmpleado")
    public String addEmpleado(Empleado empleado, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-empleado";
        }
        service.registrarEmpleado(empleado);
        return "redirect:/Empleado";
    }

    @GetMapping("EliminarEmpleado/{id}")
    public String eliminar(@PathVariable("id") long laID, Model model, Model model1){
        service.eliminarEmpleado(laID);
        model1.addAttribute("user", service1.actual());
        model.addAttribute("empleado",service.obtenerTodosEmpleado());
        return"redirect:/Empleado";
    }

    @PostMapping("/ActualizarEmpleado/{id}")
    public String actualizarEmpleado(@PathVariable("id")long id, Empleado empleado, BindingResult result, Model model){
        if(result.hasErrors()) {
            empleado.setId(id);
            return "update-empleado";
        }
        service.actualizarEmpleado(empleado);
        // model.addAttribute("users", service.obtenerTodosUsuario());
        //return "redirect:/index";

        return "redirect:/Empleado";
    }

    @GetMapping("/EditarEmpleado/{id}")
    public String editarEmpleado(@PathVariable("id")long id, Model model, Model model1){
        model1.addAttribute("user", service1.actual());
        Empleado empleado = service.obtenerEmpleadoPorID(id);
        model.addAttribute("empleado", empleado);
        return "update-empleado";


    }
}

