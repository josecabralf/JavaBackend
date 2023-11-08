package ar.edu.frc.utn.bda3k4.northwind.repositories;

import ar.edu.frc.utn.bda3k4.northwind.entities.Category;
import ar.edu.frc.utn.bda3k4.northwind.entities.Product;
import ar.edu.frc.utn.bda3k4.northwind.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.category = ?1 AND p.supplier = ?2 AND (p.unitsInStock + p.unitsOnOrder) < ?3")
    List<Product> findByCategoryAndSupplierAndFutureUnitsInStockLessThan(Category category, Supplier supplier, Integer unitsInStock);

    @Query("SELECT p FROM Product p WHERE p.category = ?1 AND p.supplier = ?2 AND p.unitsInStock > ?3")
    List<Product> findBySupplierCategoryStock(Category category, Supplier supplier, Integer unitsInStock);
}
