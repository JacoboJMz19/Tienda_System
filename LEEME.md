# Tienda Q1–R3 | paquete de revisión
Java 21, Maven, Spring Boot 4.1.1, Modulith 2.1.1 y H2. No requiere Docker. Extraer en una carpeta nueva, no mezclar con Spring Initializr. El historial incluido es de preparación por el asistente, no de los estudiantes. Las etiquetas son estados de referencia sin ejecución verificada.

Desde la raíz, en PowerShell:
```powershell
cd codigo
mvn clean test
```
Muestra inicial (desde la raíz, guardar cambios propios antes de cambiar de versión):
```powershell
git switch --detach hoja-1
cd codigo
mvn spring-boot:run '-Dspring-boot.run.profiles=hoja1' '-Dspring-boot.run.arguments=--spring.main.web-application-type=none'
```
Muestra final (desde la raíz):
```powershell
git switch --detach final
cd codigo
mvn spring-boot:run '-Dspring-boot.run.profiles=hoja2' '-Dspring-boot.run.arguments=--spring.main.web-application-type=none'
```
Volver a la rama de preparación: `git switch master` (o consultar `git branch`). Para API, desde codigo: `mvn spring-boot:run`. GET /productos/1, POST /pedidos con JSON {"clienteId":"C-001","productoId":1,"cantidad":9}, GET /pedidos/1, GET /pedidos/cliente/C-001. Cada arranque reinicia H2.

## Evidencias
Desde codigo ejecutar `mvn -Dtest=ModularityTests test`. Para inducir una violación, agregar temporalmente dentro de OrderService un campo `private com.ejemplo.tienda.catalogo.internal.Product violacion;`, ejecutar la misma prueba y guardar la salida; restaurar con `git restore src/main/java/com/ejemplo/tienda/pedidos/internal/OrderService.java` (solo si no hay cambios propios en ese archivo). Ejecutar ambas muestras y copiar sus salidas literales. Desde raíz ejecutar `git diff --name-status hoja-1 final` y `git log --format="%h %ad %an%d %s" --date=iso`. No sustituir resultados reales por los esperados. Los integrantes deben revisar, aprobar y registrar sus propias contribuciones; consultar al profesor si acepta la reconstrucción sin carpeta original.
