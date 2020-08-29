package com.uabc.proyecto.proyecto.controller;

import com.uabc.proyecto.proyecto.model.Producto;
import com.uabc.proyecto.proyecto.service.ProductoService;
import com.uabc.proyecto.proyecto.service.security.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


    @Controller
    public class ProductoController {
        @Autowired
        private ProductoService service;
        @Autowired
        private UserServiceImpl service1;

        @GetMapping("/Autoservicio")
        public String index(Model model, Model model1){
            model1.addAttribute("user", service1.actual());
            model.addAttribute("productos", service.obtenerTodosProducto());
            return "autoservicio";
        }

        @GetMapping("/AgregarAutoservicio")
        public String registrar(Producto producto, Model model1){
            model1.addAttribute("user", service1.actual());
            return "add-autoservicio";
        }

        @PostMapping("/AddAutoservicio")
        public String addUser(Producto producto, BindingResult result, Model model){
            if(result.hasErrors()){
                return "add-autoservicio";
            }
            service.registrarProducto(producto);
            return "redirect:/Autoservicio";
        }

        @GetMapping("EliminarAutoservicio/{id}")
        public String eliminar(@PathVariable("id") long laID, Model model, Model model1){
            service.eliminarProducto(laID);
            model.addAttribute("productos",service.obtenerTodosProducto());
            model1.addAttribute("user", service1.actual());
            return"redirect:/Autoservicio";
        }

        @PostMapping("/ActualizarAutoservicio/{id}")
        public String actualizarProducto(@PathVariable("id")long id, Producto producto, BindingResult result, Model model){
            if(result.hasErrors()) {
                producto.setId(id);
                return "update-autoservicio";
            }
            service.actualizarProducto(producto);
            // model.addAttribute("users", service.obtenerTodosUsuario());
            //return "redirect:/index";

            return "redirect:/Autoservicio";
        }

        @GetMapping("/EditarAutoservicio/{id}")
        public String editarProducto(@PathVariable("id")long id, Model model, Model model1){
            model1.addAttribute("user", service1.actual());
            Producto producto = service.obtenerProductoPorID(id);
            model.addAttribute("producto", producto);
            return "update-autoservicio";


        }
    }

