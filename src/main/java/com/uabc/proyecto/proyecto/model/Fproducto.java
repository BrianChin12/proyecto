package com.uabc.proyecto.proyecto.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Fproducto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="P_SEQ")
    @SequenceGenerator(name="P_SEQ", sequenceName="P_SEQ", allocationSize=1)
    private long id;
    private String nombre;
    private String categoria;
    private int precio;
    private int cantidad;
    private String receta;

    public Fproducto(){}

    public Fproducto(long id, String nombre, String categoria, int precio, int cantidad, String receta){
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
        this.receta = receta;
    }

}
