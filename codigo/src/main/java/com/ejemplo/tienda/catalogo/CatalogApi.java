package com.ejemplo.tienda.catalogo;
public interface CatalogApi { ProductSummary find(long id); boolean reserveStock(long id,int cantidad); }
