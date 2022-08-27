package App.integration;

import App.DTO.PaymentChangeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaSender {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(PaymentChangeDTO paymentChangeDTO)  {

        ObjectMapper objectMapper = new ObjectMapper();
        try{
            String paymentChangeDtoString = objectMapper.writeValueAsString(paymentChangeDTO);
            System.out.println(paymentChangeDtoString);
            kafkaTemplate.send("paymentTopic", paymentChangeDtoString);

        }catch (Exception e)
        {
            e.printStackTrace();
        }



    }
}
