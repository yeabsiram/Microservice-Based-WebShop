package App.integration;


import App.DTO.CustomerChangeDTO;
import App.DTO.PaymentChangeDTO;
import App.DTO.ProductChangeDTO;
import App.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class KafkaListeners {
    @Autowired
    OrderService orderService;

    @KafkaListener(topics = {"productChangedTopic"})
    public void productChangeListener(@Payload String productChangeDTOString)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            ProductChangeDTO productChangeDTO = objectMapper.readValue(productChangeDTOString, ProductChangeDTO.class);
            orderService.handle(productChangeDTO);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @KafkaListener(topics = {"paymentTopic"})
    public void paymentChangeListener(@Payload String paymentChange)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            PaymentChangeDTO paymentChangeDTO = objectMapper.readValue(paymentChange, PaymentChangeDTO.class);
            orderService.handle(paymentChangeDTO);

        }catch (Exception e)
        {
            e.printStackTrace();
        }
//        System.out.println(paymentChange);
//        orderService.handle(paymentChangeDTO);
    }

    @KafkaListener(topics = {"customerChangeTopic"})
    public void customerChangeListener(@Payload String customerChangeDTOString)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            CustomerChangeDTO customerChangeDTO = objectMapper.readValue(customerChangeDTOString, CustomerChangeDTO.class);
            orderService.handle(customerChangeDTO);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
