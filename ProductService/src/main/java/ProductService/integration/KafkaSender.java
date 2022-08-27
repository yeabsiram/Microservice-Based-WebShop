package ProductService.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ProductService.service.ProductChangeEventDTO;

@Component
public class KafkaSender {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(ProductChangeEventDTO productChangeEventDTO)  {
        String productChangeString = objMapper(productChangeEventDTO);
        kafkaTemplate.send("productChangedTopic", productChangeString);
        System.out.println("Writing to kafka");
    }
    private String objMapper(ProductChangeEventDTO  productChangeEventDTO)
    {
        String  orderChangeDtoString = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            orderChangeDtoString = objectMapper.writeValueAsString(productChangeEventDTO);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return orderChangeDtoString;
    }
}
