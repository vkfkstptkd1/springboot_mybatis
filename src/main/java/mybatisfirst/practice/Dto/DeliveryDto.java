package mybatisfirst.practice.Dto;

import lombok.Data;

@Data
public class DeliveryDto {

    private Long id;
    private OrderDto orderDto;
    private AddressDto addressDto;
    private DeliveryStatus status; //ENUM [READY(준비), COMP(배송)]

    @Override
    public String toString() {
        return "DeliveryDto{" +
                "id=" + id +
                ", orderDto=" + orderDto +
                ", addressDto=" + addressDto +
                ", status=" + status +
                '}';
    }
}
