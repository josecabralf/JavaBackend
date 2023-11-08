package ar.edu.frc.utn.bda3k4.northwind.services.implementations;

import ar.edu.frc.utn.bda3k4.northwind.entities.*;
import ar.edu.frc.utn.bda3k4.northwind.repositories.*;
import ar.edu.frc.utn.bda3k4.northwind.services.interfaces.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final SupplierRepository supplierRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final OrderDetailRepository orderDetailRepository;

    public OrderServiceImpl(OrderRepository orderRepository, SupplierRepository supplierRepository,
                            CategoryRepository categoryRepository, ProductRepository productRepository,
                            OrderDetailRepository orderDetailRepository) {
        this.orderRepository = orderRepository;
        this.supplierRepository = supplierRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public Order add(Order entity) {
        return this.orderRepository.save(entity);
    }

    @Override
    public Order update(Integer id, Order entity) {
        Order order = this.orderRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Order not found"));
        order.update(entity);
        return this.orderRepository.save(order);
    }

    @Override
    public Order delete(Integer id) {
        Order order = this.orderRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Order not found"));
        this.orderRepository.delete(order);
        return order;
    }

    @Override
    public Order findById(Integer id) {
        return this.orderRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("Order not found"));
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = this.orderRepository.findAll();
        if(orders.isEmpty()){throw new IllegalArgumentException("No orders found");}
        return orders;
    }

    @Override
    public Order addDetails(Order order, Integer supplierId, Integer categoryId, Integer requiredStock) {
        Order order1 = orderRepository.save(order);
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(()-> new IllegalArgumentException("Category not found"));
        Supplier supplier = this.supplierRepository.findById(supplierId)
                .orElseThrow(()-> new IllegalArgumentException("Supplier not found"));
        List<Product> productList = this.productRepository
                .findByCategoryAndSupplierAndFutureUnitsInStockLessThan(category, supplier, requiredStock);
        if(productList.isEmpty()){return null;}
        List<OrderDetail> orderDetails = new ArrayList<>();
        for (Product product : productList) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order1.getId());
            orderDetail.setProductId(product.getId());
            orderDetail.setQuantity(requiredStock);
            if (requiredStock < 100) orderDetail.setDiscount(0.0);
            else orderDetail.setDiscount(0.1);
            orderDetail.setUnitPrice(product.getUnitPrice());
            orderDetail = addOrderDetail(orderDetail);
            orderDetails.add(orderDetail);
        }
        order.setOrderDetails(orderDetails);
        return orderRepository.save(order1);
    }

    public OrderDetail addOrderDetail(OrderDetail entity) {
        Optional<Order> order = this.orderRepository.findById(entity.getOrderId());
        Optional<Product> product = this.productRepository.findById(entity.getProductId());
        entity.setOrder(order.get());
        entity.setProduct(product.get());
        return this.orderDetailRepository.save(entity);
    }
}
