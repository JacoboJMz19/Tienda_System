package com.ejemplo.tienda.catalogo.internal;
import org.springframework.stereotype.Component; import jakarta.annotation.PostConstruct;
@Component class DataSeeder { private final ProductRepository repo; DataSeeder(ProductRepository repo){this.repo=repo;} @PostConstruct void seed(){if(repo.count()==0)repo.save(new Product(1,"Monitor",600000,24));} }
