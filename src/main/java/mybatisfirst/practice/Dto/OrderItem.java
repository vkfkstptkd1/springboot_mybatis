package mybatisfirst.practice.Dto;

import lombok.Data;

@Data
public class OrderItem {

    private Long id;
    private Long orderId;
    private Long itemId;
    private int orderPrice;     //주문 당시 가격
    private int count;          //주문 수량

   /* public static OrderItem createOrderItem(ItemDto item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItemDto(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        //주문 하는 순간 재고 빼줌.
        item.removeStock(count);
        return orderItem;
    }*/

}
