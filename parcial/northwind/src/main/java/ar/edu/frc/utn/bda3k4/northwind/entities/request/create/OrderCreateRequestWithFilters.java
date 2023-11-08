package ar.edu.frc.utn.bda3k4.northwind.entities.request.create;

import ar.edu.frc.utn.bda3k4.northwind.entities.Order;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderCreateRequestWithFilters {
    @NotBlank(message = "El campo supplierId no puede estar vacío")
    private Integer supplierId;
    @NotBlank(message = "El campo categoryId no puede estar vacío")
    private Integer categoryId;
    @NotBlank(message = "El campo requiredStock no puede estar vacío")
    private Integer requiredStock;
    @NotBlank(message = "El campo quantity no puede estar vacío")
    private String customerId; //Listo
    @NotBlank(message = "El campo employeeId no puede estar vacío")
    private Integer employeeId; //Listo
    @NotBlank(message = "El campo shipperId no puede estar vacío")
    private Integer shipperId; //Listo
    @NotBlank(message = "El campo minDuration no puede estar vacío")
    private Integer maxDuration; //Listo

    public Order toOrder() {
        LocalDate requiredDate = LocalDate.now().plusDays(this.maxDuration);
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setRequiredDate(requiredDate);
        order.setShippedDate(null);
        order.setFreight(0.0);
        return order;
    }
}
