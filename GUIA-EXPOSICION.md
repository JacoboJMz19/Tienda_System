# Guía para exponer | Matías y Jacobo
Duración sugerida: 8 minutos.

## Matías (4 minutos): problema y arquitectura
1. Nuestra variante sale de 07 y 10: suma 17, módulo 4 igual a 1; diferencia 3, módulo 5 igual a 3. Q1 es modificabilidad y R3 es Monitor.
2. El monitor cuesta 600.000, tiene 24 unidades y desde tres unidades aplica 12%. El sistema valida cantidad y producto antes de crear el pedido; los rechazados por stock sí tienen identificador.
3. Elegimos monolito modular: un proceso, dos módulos. Catálogo administra producto y stock; pedidos registra compras y calcula descuentos. CatalogApi es la frontera pública. Una transacción permite reservar y guardar juntos.
4. H2 reemplaza PostgreSQL para facilitar la ejecución, opción permitida en el enunciado. No se necesita Docker. El costo es que los datos de demostración no sobreviven al reinicio.

## Jacobo (4 minutos): cambio, demostración y medición
1. Hoja 1: mostrar la secuencia 2, 3, 20, 19. Resultados esperados: 1200000, 1584000, 0, 10032000. El tercer pedido no consume stock.
2. Hoja 2: desde nueve unidades aplica 17%; entre tres y ocho sigue 12%. Muestra limpia 9, 8, 1: 4482000, 4224000, 600000. La última línea de la muestra anterior pasa a 9462000.
3. Mostrar DiscountPolicy, OrderService y ModularityTests. El servicio no cambia; la prueba estructural protege la frontera. Explicar la violación inducida y mostrar el resultado real cuando esté disponible.
4. Mostrar git diff: dos archivos creados y dos modificados. El ajuste H2 es adicional a la predicción. No afirmar que se ejecutaron pruebas hasta tener sus salidas.

## Preguntas de defensa
- ¿Por qué no hexagonal? También aislaría el descuento, pero para esta variante no necesitamos puertos de infraestructura adicionales.
- ¿Por qué no capas? Bastaría para un CRUD, pero Modulith verifica fronteras entre áreas de negocio.
- ¿Por qué no eventos? El cambio es de cálculo, no de reacciones asíncronas; una transacción local basta.
- ¿Qué diferencia hay entre error y rechazo? Error de validación no crea pedido ni id; rechazo por stock crea pedido con total cero.
- ¿Qué no detecta Modulith? Acceso SQL directo a tablas de otro módulo sin dependencia Java.
- ¿Qué se pierde? Despliegue y escalado independientes; H2 además es volátil.

Fuentes: Enunciado pp. 1–6, 8–12; Hoja-2-Cambio pp. 3–4; guía de monolito modular pp. 14–15. La exposición debe ajustarse a los resultados reales obtenidos por la pareja.
