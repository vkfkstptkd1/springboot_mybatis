package mybatisfirst.practice.service;

import lombok.RequiredArgsConstructor;
import mybatisfirst.practice.Dto.*;
import mybatisfirst.practice.controller.OrderSearch;
import mybatisfirst.practice.controller.mapper.DeliveryMapper;
import mybatisfirst.practice.controller.mapper.ItemMapper;
import mybatisfirst.practice.controller.mapper.MemberMapper;
import mybatisfirst.practice.controller.mapper.OrderMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final MemberMapper memberMapper;
    private final ItemMapper itemMapper;

    private final DeliveryMapper deliveryMapper;

    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        //조회
        MemberDto memberDto = memberMapper.findOne(memberId);
        ItemDto itemDto = itemMapper.findOne(itemId);

        //배송정보 생성
        DeliveryDto deliveryDto = new DeliveryDto();
        deliveryDto.setAddressDto(memberDto.getAddressDto());
        deliveryDto.setStatus(DeliveryStatus.READY);

        //System.out.println(deliveryDto.toString());
        deliveryMapper.save(deliveryDto);
        //System.out.println(deliveryDto.toString());

        //주문 생성
        OrderDto orderDto = new OrderDto(memberId, deliveryDto.getId(), LocalDateTime.now(), OrderStatus.ORDER);
        orderMapper.createOrder(orderDto);

//
        //주문상품 생성
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(orderDto.getId());
        orderItem.setItemId(itemDto.getId());
        orderItem.setOrderPrice(itemDto.getPrice());
        orderItem.setCount(count);

        //주문 하는 순간 재고 빼줌.
        itemDto.removeStock(count);

        orderMapper.createOrderItem(orderItem);



        return orderDto.getId();
    }

    public List<OrderDto> findOrders(OrderSearch orderSearch) {
        return orderMapper.findAll(orderSearch);
    }
}
