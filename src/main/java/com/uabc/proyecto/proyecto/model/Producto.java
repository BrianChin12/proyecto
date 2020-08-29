package com.uabc.proyecto.proyecto.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="P_SEQ")
    @SequenceGenerator(name="P_SEQ", sequenceName="P_SEQ", allocationSize=1)
    private long id;
    private String categoria;
    private String nombre;
    private int precio;
    private int cantidad;

    public Producto(){}

    public Producto(long id, String categoria, String nombre, int precio, int cantidad){
        this.id = id;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;

    }

}
