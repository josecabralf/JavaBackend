package ar.edu.frc.utn.bda3k4.northwind.controllers;

import ar.edu.frc.utn.bda3k4.northwind.entities.Category;
import ar.edu.frc.utn.bda3k4.northwind.entities.Product;
import ar.edu.frc.utn.bda3k4.northwind.entities.Supplier;
import ar.edu.frc.utn.bda3k4.northwind.entities.request.ProductRequest;
import ar.edu.frc.utn.bda3k4.northwind.entities.response.ProductResponse;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.CategoryService;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.ProductService;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.SupplierService;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/product")
@RestController
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final SupplierService supplierService;
    public ProductController (ProductService productService, CategoryService categoryService, SupplierService supplierService){
        this.productService = productService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    @GetMapping("/all")
    public ResponseEntity<Object> findAll() {
        try {
            val products = productService.findAll()
                    .stream()
                    .map(ProductResponse::from)
                    .toList();
            return ResponseEntity.ok(products);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody ProductRequest aRequest) {
        try {
            Category category = categoryService.findById(aRequest.getCategoryId());
            Supplier supplier = null;
            if (aRequest.getSupplierId() != null) {supplier = supplierService.findById(aRequest.getSupplierId());}
            Product product = aRequest.toProduct();
            product.setCategory(category);
            product.setSupplier(supplier);
            product = productService.add(product);
            return ResponseEntity.ok(ProductResponse.from(product));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody ProductRequest aRequest) {
        try {
            Product product = aRequest.toProduct();
            Supplier supplier = null;
            if (aRequest.getSupplierId() != null) {supplier = supplierService.findById(aRequest.getSupplierId());}
            Category category = categoryService.findById(aRequest.getCategoryId());
            product.setCategory(category);
            product.setSupplier(supplier);
            product = productService.update(id, product);
            return ResponseEntity.accepted().body(ProductResponse.from(product));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Integer id) {
        try {
            Product product = productService.delete(id);
            return ResponseEntity.accepted().body(ProductResponse.from(product));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable Integer id) {
        try {
            Product product = productService.findById(id);
            return ResponseEntity.ok(ProductResponse.from(product));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<Object> findBySupplierCategoryStock(@RequestParam Integer supplierId,
                                                              @RequestParam Integer categoryId,@RequestParam Integer stock) {
        try {
            Supplier supplier = supplierService.findById(supplierId);
            Category category = categoryService.findById(categoryId);
            List<ProductResponse> products = productService.findBySupplierCategoryStock(category, supplier, stock)
                    .stream()
                    .map(ProductResponse::from)
                    .toList();
            if (products.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(products);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
