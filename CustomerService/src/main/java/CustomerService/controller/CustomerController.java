package CustomerService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import CustomerService.service.CustomerDTO;
import CustomerService.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<?> add(@RequestBody CustomerDTO customerDTO){
        customerService.add(customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @PutMapping("/customers/{customerNumber}")
    public ResponseEntity<?> update(@PathVariable("customerNumber") String customerNumber,@RequestBody CustomerDTO customerDTO){
        customerService.update(customerNumber, customerDTO);
        return new ResponseEntity<>(customerDTO,HttpStatus.OK);
    }

    @DeleteMapping("/customers/{customerNumber}")
    public ResponseEntity<?> delete(@PathVariable("customerNumber") String customerNumber){
        customerService.delete(customerNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping(value = "/customers/{customerNumber}")
    public ResponseEntity<?> get(@PathVariable("customerNumber") String customerNumber)
    {
        ResponseEntity<?> responseEntity;
        CustomerDTO customerDTO = customerService.get(customerNumber);
        if(customerDTO == null)
        {
            responseEntity = new ResponseEntity<>(new CustomError("Customer with the Id "+ customerNumber + " is not found."), HttpStatus.NOT_FOUND);

        }
        else {
            responseEntity = new ResponseEntity<>(customerDTO, HttpStatus.OK);
        }
        return responseEntity;
    }
}
