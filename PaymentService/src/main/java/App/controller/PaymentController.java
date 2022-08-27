package App.controller;

import App.service.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import App.service.PaymentService;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payments")
    public ResponseEntity<?> add(@RequestBody PaymentDTO paymentDTO){
        System.out.println(paymentDTO + " COntroller");
        paymentService.add(paymentDTO);

        return new ResponseEntity<>(paymentDTO, HttpStatus.OK);
    }

    @PutMapping("/payments/{paymentNumber}")
    public ResponseEntity<?> update(@PathVariable("paymentNumber") String paymentNumber,@RequestBody PaymentDTO paymentDTO){
        paymentService.update(paymentNumber, paymentDTO);
        return new ResponseEntity<>(paymentDTO,HttpStatus.OK);
    }

    @DeleteMapping("/payments/{paymentNumber}")
    public ResponseEntity<?> delete(@PathVariable("paymentNumber") String paymentNumber){
        paymentService.delete(paymentNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(value = "/payments/{paymentNumber}")
    public ResponseEntity<?> get(@PathVariable("paymentNumber") String paymentNumber)
    {
        ResponseEntity<?> responseEntity;
        PaymentDTO paymentDTO = paymentService.get(paymentNumber);
        if(paymentDTO == null)
        {
            responseEntity = new ResponseEntity<>(new CustomError("Payment with the payment number "+ paymentNumber + " is not found."), HttpStatus.NOT_FOUND);

        }
        else {
            responseEntity = new ResponseEntity<>(paymentDTO, HttpStatus.OK);
        }
        return responseEntity;
    }
}
