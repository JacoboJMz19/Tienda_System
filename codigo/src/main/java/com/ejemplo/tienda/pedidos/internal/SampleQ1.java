package com.ejemplo.tienda.pedidos.internal;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Profile;
@Component @Profile("hoja2")
class SampleQ1 implements ApplicationRunner {
 private final OrderService service;
 SampleQ1(OrderService service){this.service=service;}
 public void run(ApplicationArguments args){
  int[] quantities={9,8,1};
  for(int i=0;i<quantities.length;i++){
   var o=service.create("C-00"+(i+1),1,quantities[i]);
   System.out.printf("PEDIDO %d %s total=%d%n",o.getId(),o.getEstado(),o.getTotal());
  }
 }
}
