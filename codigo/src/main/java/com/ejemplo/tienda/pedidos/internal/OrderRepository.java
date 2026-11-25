package com.ejemplo.tienda.pedidos.internal;
import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param;
interface OrderRepository extends JpaRepository<Order,Long>{ @Query("select coalesce(sum(o.total),0) from PurchaseOrder o where o.clienteId=:cliente and o.estado='CONFIRMADO'") long totalCliente(@Param("cliente") String cliente); }
