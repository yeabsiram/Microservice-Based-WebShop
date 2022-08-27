package App.integration;

import App.DTO.OrderChangeDTO;
import App.domain.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaSender {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void send(OrderChangeDTO orderChangeDTO)
    {
        String orderChangeDtoString = objMapper(orderChangeDTO);
        kafkaTemplate.send("orderChangedTopic", orderChangeDtoString);
        System.out.println("Kafka sent successfully");
    }
    private String objMapper(OrderChangeDTO  orderChangeDTO)
    {
        String  orderChangeDtoString = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            orderChangeDtoString = objectMapper.writeValueAsString(orderChangeDTO);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return orderChangeDtoString;
    }

}
