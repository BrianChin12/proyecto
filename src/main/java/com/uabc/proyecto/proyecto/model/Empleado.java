package com.uabc.proyecto.proyecto.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Empleado {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SEQ")
    @SequenceGenerator(name="EMP_SEQ", sequenceName="EMP_SEQ", allocationSize=1)
    private long id;
    private String nombre;
    private String fecha_n;
    private String correo;
    private long telefono;
    private String puesto;
    private String sueldo;
    private String genero;

    public Empleado(){}

    public Empleado(long id, String nombre, String fecha_n, String correo, long telefono, String puesto, String sueldo, String genero ){
        this.id = id;
        this.nombre = nombre;
        this.fecha_n = fecha_n;
        this.correo = correo;
        this.telefono = telefono;
        this.puesto = puesto;
        this.sueldo = sueldo;
        this.genero = genero;

    }

}
