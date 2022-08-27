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

    @PostMapping("/ordercommand")
    public ResponseEntity<?> add(@RequestBody OrderDTO orderDTO){
        orderService.add(orderDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @PutMapping("/ordercommand/{orderNumber}")
    public ResponseEntity<?> update(@PathVariable("orderNumber") String orderNumber,@RequestBody OrderDTO orderDTO){
        orderService.update(orderNumber, orderDTO);
        return new ResponseEntity<>(orderDTO,HttpStatus.OK);
    }

    @DeleteMapping("/ordercommand/{orderNumber}")
    public ResponseEntity<?> delete(@PathVariable("orderNumber") String orderNumber){
        orderService.delete(orderNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
