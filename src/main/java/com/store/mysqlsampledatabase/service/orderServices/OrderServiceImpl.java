package com.store.mysqlsampledatabase.service.orderServices;

import com.store.mysqlsampledatabase.model.Customer;
import com.store.mysqlsampledatabase.model.Order;
import com.store.mysqlsampledatabase.model.ResourceNotFoundException;
import com.store.mysqlsampledatabase.repository.CustomerRepository;
import com.store.mysqlsampledatabase.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Integer orderNumber) {
        return orderRepository.findById(orderNumber)
         .orElseThrow(() -> new RuntimeException("Product not found with ID: " + orderNumber));
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer orderNumber) {
        Order order = orderRepository.findById(orderNumber)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + orderNumber));
        orderRepository.delete(order);

    }

    @Override
    public Order updateOrder(Integer orderNumber, Map<String, Object> updates) {
        Order order = orderRepository.findById(orderNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + orderNumber));

        updates.forEach((key, value) -> {
            switch (key) {
                case "orderDate":
                    order.setOrderDate(LocalDate.parse((String) value));
                    break;
                case "requiredDate":
                    order.setRequiredDate(LocalDate.parse((String) value));
                    break;
                case "shippedDate":
                    order.setShippedDate(LocalDate.parse((String) value));
                    break;
                case "status":
                    order.setStatus((String) value);
                    break;
                case "comments":
                    order.setComments((String) value);
                    break;
                case "customer":
                    Map<String, Object> customerMap = (Map<String, Object>) value;
                    Integer customerNumber = (Integer) customerMap.get("customerNumber");
                    Customer customer = customerRepository.findById(customerNumber)
                            .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
                    order.setCustomer(customer);
                    break;

            }
        });

        return orderRepository.save(order);
    }


}
