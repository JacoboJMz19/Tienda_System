# Informe de revisión Q1–R3
La Hoja 1 se etiquetó como referencia sin verificar su ejecución; Maven no está disponible en el entorno de generación.

| Medida | Resultado del diff |
|---|---|
| Archivos creados | 2 |
| Archivos modificados | 2 |
| ¿Se modificó la clase que calcula el total? | Sí, DiscountPolicy |
| ¿Se modificó la clase que registra el pedido? | No |
| ¿Se tocó una prueba de la Hoja 1? | No |

## Predicción contra medición
El ADR inicial anticipó que el cambio comercial se concentraría en DiscountPolicy y que se agregarían una muestra y una prueba, sin modificar el servicio encargado de registrar los pedidos. La tabla confirma esa predicción respecto a las clases Java, porque el cálculo del porcentaje se mantiene separado de la reserva de inventario y del almacenamiento de pedidos. Sin embargo, también aparece una modificación de application.properties, que ajusta el tiempo de vida de la base H2 y no corresponde directamente a la regla comercial, por lo que la predicción de archivos no fue completa. La medición del código es real, pero todavía no demuestra que las pruebas de regresión pasen en el entorno del estudiante.

## El límite
Si la tienda necesitara emitir facturas y enviar notificaciones mediante consumidores independientes, con reintentos y sin bloquear la confirmación del pedido, una arquitectura de eventos podría resultar más conveniente que el monolito modular. La guía del monolito señala como desventaja que los módulos comparten despliegue, escalado y proceso, lo que limita su independencia cuando crecen con necesidades diferentes. La arquitectura de eventos permite incorporar consumidores sin modificar el productor, aunque introduce coordinación y consistencia eventual, costos que el enunciado identifica expresamente. Para los tres tramos de descuento del monitor, en cambio, la llamada local y una transacción compartida son suficientes y evitan introducir esa infraestructura adicional.

## Lo que la regla no ve
La violación propuesta consiste en declarar en OrderService un campo del tipo Product, que pertenece al paquete interno de catálogo, en lugar de depender exclusivamente de CatalogApi. ApplicationModules.verify debería detectar esa dependencia porque cruza la frontera pública del módulo, pero todavía no se ha ejecutado la prueba inducida y no corresponde afirmar que pasó o falló. Una infracción distinta sería consultar directamente la tabla products mediante SQL desde pedidos sin importar ninguna clase interna, lo que rompería la propiedad de los datos sin crear necesariamente una dependencia Java detectable. Por eso la verificación estructural debe complementarse con revisión de código y pruebas del comportamiento transaccional, especialmente para comprobar que un pedido rechazado no reduzca el inventario.
