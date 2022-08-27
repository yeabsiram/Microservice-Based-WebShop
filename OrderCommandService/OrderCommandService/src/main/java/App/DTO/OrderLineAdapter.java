package App.DTO;

import App.domain.OrderLine;

import java.util.ArrayList;
import java.util.List;

public class OrderLineAdapter {

    public static List<OrderLine> fromDto(List<OrderLineDTO> orderLineDTO)
    {
        List<OrderLine> orderLineList = new ArrayList<>();

        for(OrderLineDTO orderLineDTO1 : orderLineDTO)
        {
            OrderLine orderLine = new OrderLine(orderLineDTO1.getQuantity(), orderLineDTO1.getProduct());
            orderLineList.add(orderLine);
        }
        return orderLineList;
    }
}
