package com.ejemplo.tienda.pedidos.internal;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class DiscountQ1Tests {
 @Test void boundaries(){var p=new DiscountPolicy();assertEquals(0,p.porcentaje(1));assertEquals(12,p.porcentaje(8));assertEquals(17,p.porcentaje(9));assertEquals(4482000,p.total(600000,9));assertEquals(4224000,p.total(600000,8));assertEquals(9462000,p.total(600000,19));}
}
