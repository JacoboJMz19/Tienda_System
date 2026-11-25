# Tienda Q1-R3 — etapa Hoja 1
Java 21 y Maven. No requiere Docker. Reconstrucción mínima a partir de los PDF, no copia del repositorio original.
Desde codigo:
```powershell
mvn clean test
mvn spring-boot:run '-Dspring-boot.run.profiles=hoja1' '-Dspring-boot.run.arguments=--spring.main.web-application-type=none'
```
Para API: `mvn spring-boot:run`. POST /pedidos con JSON {"clienteId":"C-001","productoId":1,"cantidad":2}; GET /productos/1, /pedidos/1, /pedidos/cliente/C-001.
Antes de avanzar, completar fecha ADR, ejecutar pruebas y muestra, registrar salidas reales y crear etiqueta hoja-1. La Hoja 2 no está incluida todavía para respetar el orden exigido. No se ha compilado en el entorno de generación (Maven no disponible).
