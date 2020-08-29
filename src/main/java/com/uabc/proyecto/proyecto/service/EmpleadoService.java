package com.uabc.proyecto.proyecto.service;

import com.uabc.proyecto.proyecto.model.Empleado;
import com.uabc.proyecto.proyecto.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository repo;

    /**
     * Permite registrar Empleados
     * @return Empleado registrado
     * @param Empleado Empleado a registrar
     */

    public Empleado registrarEmpleado(Empleado empleado){
        Empleado empleadoSaved=repo.save(empleado);
        return empleadoSaved;
    }
    //PROVIENE DE UN LISTADO
    public void actualizarEmpleado(long id){
        Empleado empleado = repo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invelid producto Id:" + id));
        //TODO ENVIAR A LA VISTA HTML EL OBJETO A EDITAR CON UN MODEL
    }


    //ESTE USUARIO PROVIENE DE UN FORMULARIO DE EDICION
    public void actualizarEmpleado(Empleado empleado){
        repo.save(empleado);
    }

    public void eliminarEmpleado(long id) {
        Empleado empleado = repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Invalid producto Id:" + id));
        repo.delete(empleado);
    }
    public List<Empleado> obtenerTodosEmpleado(){
        List<Empleado> actualList = new ArrayList<Empleado>();
        repo.findAll().forEach(actualList::add);
        return actualList;
    }
    public Empleado obtenerEmpleadoPorID(long id){
        return repo.findById(id).get();
    }
}
