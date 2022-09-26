package mybatisfirst.practice.controller;

import lombok.Getter;
import lombok.Setter;
import mybatisfirst.practice.Dto.OrderStatus;

@Getter@Setter
public class OrderSearch {

    private String memberName; //회원 이름
    private OrderStatus orderStatus;//주문 상태[ORDER, CANCEL]

}
