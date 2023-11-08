package ar.edu.frc.utn.bda3k4.northwind.services.interfaces;

import ar.edu.frc.utn.bda3k4.northwind.entities.Category;
import ar.edu.frc.utn.bda3k4.northwind.entities.Product;
import ar.edu.frc.utn.bda3k4.northwind.entities.Supplier;

import java.util.List;

public interface ProductService extends Service<Product, Integer>{
    List<Product> findBySupplierCategoryStock(Category category, Supplier supplier, Integer unitsInStock);
}
