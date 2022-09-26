package mybatisfirst.practice.controller.mapper;

import mybatisfirst.practice.Dto.*;
import mybatisfirst.practice.controller.OrderSearch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;

import java.util.List;

@Mapper
public interface OrderMapper {
    void save(OrderDto orderDto);
    void createOrderItem(OrderItem orderItem);
    void createOrder(OrderDto orderDto);

    List<OrderDto> findAll(OrderSearch orderSearch);
}
