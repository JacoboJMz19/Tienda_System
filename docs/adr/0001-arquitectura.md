# ADR-0001 · Monolito modular
Variante: Q1 / fila 3
- Fecha: 2026-11-25 20:26
- Estado: propuesta para revisión de la pareja
## Contexto
Monitor de $600000, stock 24, umbral 3 y descuento 12%. Se requiere localizar cambios comerciales.
## Alternativas consideradas
- Capas: separación técnica, pero no impone fronteras entre catálogo y pedidos.
- Hexagonal: permite aislar reglas, pero añade puertos y adaptadores para un cambio de porcentaje sin cambio de infraestructura.
- Eventos: añade coordinación y consistencia eventual para una reserva que puede ser transaccional.
## Decisión
Monolito modular, H2 en memoria permitido por el enunciado, descuento aislado en DiscountPolicy. Pedidos solo accede a CatalogApi.
## Consecuencias
**Se gana:** cambios localizados y transacción única.
**Se pierde:** catálogo y pedidos no se despliegan independientemente.
**Predicción del costo de la Hoja 2:** modificar DiscountPolicy; crear muestra y prueba del tramo nuevo. Se toca el cálculo del total en su clase, no OrderService ni las pruebas iniciales.
