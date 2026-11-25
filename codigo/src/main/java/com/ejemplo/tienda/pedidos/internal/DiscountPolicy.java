package com.ejemplo.tienda.pedidos.internal;
import org.springframework.stereotype.Component;
@Component public class DiscountPolicy { public int porcentaje(int cantidad){return cantidad>=3?12:0;} public long total(long precio,int cantidad){return precio*cantidad*(100-porcentaje(cantidad))/100;} }
