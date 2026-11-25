package com.ejemplo.tienda.pedidos.internal;
import com.ejemplo.tienda.catalogo.CatalogApi; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
@Service public class OrderService { private final CatalogApi catalog; private final OrderRepository repo; private final DiscountPolicy policy;
 OrderService(CatalogApi catalog,OrderRepository repo,DiscountPolicy policy){this.catalog=catalog;this.repo=repo;this.policy=policy;}
 @Transactional public Order create(String cliente,long producto,int cantidad){if(cantidad<=0||cliente==null||cliente.isBlank())throw new IllegalArgumentException("Solicitud inválida");var p=catalog.find(producto);boolean ok=catalog.reserveStock(producto,cantidad);return repo.save(new Order(cliente,producto,cantidad,ok,ok?policy.total(p.precio(),cantidad):0));}
 @Transactional(readOnly=true) public Order find(long id){return repo.findById(id).orElseThrow(()->new IllegalArgumentException("Pedido inexistente"));}
 @Transactional(readOnly=true) public long totalCliente(String cliente){return repo.totalCliente(cliente);}
}
