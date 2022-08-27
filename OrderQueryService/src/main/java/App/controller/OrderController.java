package App.controller;

import App.DTO.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import App.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orderquery/{orderNr}")
    public ResponseEntity<?> get(@PathVariable("orderNr") String orderNr){
        OrderDTO orderDTO = orderService.get(orderNr);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

}
