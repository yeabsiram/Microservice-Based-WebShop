package CustomerService.integration;

import CustomerService.service.CustomerChangeEventDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaSender {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(CustomerChangeEventDTO customerChangeEventDTO)  {

        String customerChange = objMapper(customerChangeEventDTO);
        kafkaTemplate.send("customerChangeTopic", customerChange);
    }
    private String objMapper(CustomerChangeEventDTO  customerChangeEventDTO)
    {
        String  orderChangeDtoString = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            orderChangeDtoString = objectMapper.writeValueAsString(customerChangeEventDTO);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return orderChangeDtoString;
    }
}
