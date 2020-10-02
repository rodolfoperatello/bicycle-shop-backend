package br.com.exactalabs.bicycleshop.service;

import br.com.exactalabs.bicycleshop.entity.Order;
import br.com.exactalabs.bicycleshop.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order){
        return this.orderRepository.save(order);
    }

    public Order updateOrder(Order order){
        return this.orderRepository.save(order);
    }

    public void deleteOrderById(Long id){
        this.orderRepository.deleteById(id);
    }

    public Order findOrderById(Long id){
        return this.orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order não encontrada"));
    }

    public Page<Order> findAllOrder(Integer pageNumber){
        var pageRequest = PageRequest.of(pageNumber, 30);
        return this.orderRepository.findAll(pageRequest);
    }


}
