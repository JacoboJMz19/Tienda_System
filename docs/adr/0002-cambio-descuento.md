# ADR-0002 · Nuevo tramo de descuento
Variante: Q1 / fila 3
- Fecha: 2026-11-25 20:26:58
- Estado: propuesta para revisión
## Contexto
Desde nueve monitores el descuento pasa a 17%; entre tres y ocho sigue en 12%.
## Alternativas consideradas
- Cambiar OrderService: mezcla registro con cálculo.
- Motor configurable: complejidad innecesaria para tres tramos.
## Decisión
Modificar DiscountPolicy y agregar muestra y prueba independientes. Mantener la API de catálogo.
## Consecuencias
**Se gana:** no cambia OrderService ni la prueba original.
**Se pierde:** sigue siendo necesario recompilar y desplegar la aplicación completa para cambiar el porcentaje.
La predicción acertó sobre las clases Java, pero no anticipó el ajuste adicional de configuración H2 (DB_CLOSE_DELAY). La pérdida de despliegue independiente permanece por diseño; no se realizó una prueba de despliegue. Falta verificar Maven.
