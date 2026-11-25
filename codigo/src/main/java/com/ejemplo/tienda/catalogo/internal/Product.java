package com.ejemplo.tienda.catalogo.internal;
import jakarta.persistence.*;
@Entity @Table(name="products") public class Product {
 @Id Long id; String nombre; long precio; int stock;
 protected Product(){} Product(long id,String nombre,long precio,int stock){this.id=id;this.nombre=nombre;this.precio=precio;this.stock=stock;}
}
