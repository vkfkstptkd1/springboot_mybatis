package mybatisfirst.practice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private Long memberId;
    private Long deliveryId;

    private LocalDateTime orderDate; //주문 시간
    private OrderStatus status; //주문 상태 CANCEL, ORDER

    public OrderDto(Long memberId, Long deliveryId, LocalDateTime orderDate, OrderStatus status) {
        this.memberId = memberId;
        this.deliveryId  =deliveryId;
        this.orderDate = orderDate;
        this.status = status;
    }
}
