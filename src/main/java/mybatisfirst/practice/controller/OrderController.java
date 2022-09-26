package mybatisfirst.practice.controller;

import lombok.RequiredArgsConstructor;
import mybatisfirst.practice.Dto.ItemDto;
import mybatisfirst.practice.Dto.MemberDto;
import mybatisfirst.practice.Dto.OrderDto;
import mybatisfirst.practice.service.ItemService;
import mybatisfirst.practice.service.MemberService;
import mybatisfirst.practice.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class OrderController {

    private final MemberService memberService;
    private final ItemService itemService;

    private final OrderService orderService;

    @GetMapping(value = "/order")
    public String createForm(Model model) {
        List<MemberDto> members = memberService.findMembers();
        List<ItemDto> items = itemService.findItems();
        model.addAttribute("members", members);
        model.addAttribute("items", items);
        return "order/orderForm";
    }
    @PostMapping(value = "/order")

    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("itemId") Long itemId, @RequestParam("count") int count) {
        orderService.order(memberId, itemId, count);
        return "redirect:order/";
    }

    @GetMapping(value = "/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch
                                    orderSearch, Model model) {
        List<OrderDto> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

}

