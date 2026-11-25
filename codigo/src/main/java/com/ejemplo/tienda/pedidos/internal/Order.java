package com.ejemplo.tienda.pedidos.internal;
import jakarta.persistence.*;
@Entity(name="PurchaseOrder") @Table(name="orders") public class Order { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; private String clienteId; private long productoId; private int cantidad; private String estado; private long total;
 protected Order(){} Order(String c,long p,int q,boolean ok,long t){clienteId=c;productoId=p;cantidad=q;estado=ok?"CONFIRMADO":"RECHAZADO";total=t;}
 public Long getId(){return id;} public String getClienteId(){return clienteId;} public long getProductoId(){return productoId;} public int getCantidad(){return cantidad;} public String getEstado(){return estado;} public long getTotal(){return total;}
}
