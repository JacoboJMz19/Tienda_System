package com.ejemplo.tienda.catalogo.internal;
import com.ejemplo.tienda.catalogo.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
@Service class ProductService implements CatalogApi {
 private final ProductRepository repo; ProductService(ProductRepository repo){this.repo=repo;}
 @Transactional(readOnly=true) public ProductSummary find(long id){var p=repo.findById(id).orElseThrow(()->new IllegalArgumentException("Producto inexistente"));return new ProductSummary(p.id,p.nombre,p.precio,p.stock);}
 @Transactional public boolean reserveStock(long id,int cantidad){if(cantidad<=0)throw new IllegalArgumentException("Cantidad inválida");var p=repo.locked(id).orElseThrow(()->new IllegalArgumentException("Producto inexistente"));if(p.stock<cantidad)return false;p.stock-=cantidad;return true;}
}
