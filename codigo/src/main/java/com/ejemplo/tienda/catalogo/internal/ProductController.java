package com.ejemplo.tienda.catalogo.internal;
import com.ejemplo.tienda.catalogo.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/productos") class ProductController { private final CatalogApi api; ProductController(CatalogApi api){this.api=api;} @GetMapping("/{id}") ProductSummary find(@PathVariable long id){return api.find(id);} @ExceptionHandler(IllegalArgumentException.class) @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST) String error(IllegalArgumentException e){return e.getMessage();} }
