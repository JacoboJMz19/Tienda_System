package com.ejemplo.tienda.catalogo.internal;
import org.springframework.data.jpa.repository.*; import org.springframework.data.repository.query.Param; import jakarta.persistence.LockModeType; import java.util.Optional;
interface ProductRepository extends JpaRepository<Product,Long>{ @Lock(LockModeType.PESSIMISTIC_WRITE) @Query("select p from Product p where p.id=:id") Optional<Product> locked(@Param("id") long id); }
