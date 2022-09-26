package mybatisfirst.practice.controller;

import lombok.RequiredArgsConstructor;
import mybatisfirst.practice.Dto.BookDto;
import mybatisfirst.practice.Dto.ItemDto;
import mybatisfirst.practice.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/items/new")
    public String createForm(Model model){
        model.addAttribute("form",new ItemForm());
        return "items/createItemForm";
    }

    //상품 생성
    @PostMapping("/items/new")
    public String create(ItemForm form){

        ItemDto item = new ItemDto();
        item.setDtype("B");
        item.setName(form.getName());
        item.setPrice(form.getPrice());
        item.setStockQuantity(form.getStockQuantity());

        itemService.saveItem(item);
        return "redirect:/";
    }


    //상품 목록 조회.
    @GetMapping("/items")
    public String list(Model model){
        List<ItemDto> items = itemService.findItems();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    //상품 수정
    @GetMapping("items/{itemId}/edit")
    public String updateItemForm(@PathVariable("itemId") Long itemId, Model
            model) {
        ItemDto item = itemService.findOne(itemId);
        ItemForm form = new ItemForm();
        form.setId(item.getId());
        form.setName(item.getName());
        form.setPrice(item.getPrice());
        form.setStockQuantity(item.getStockQuantity());
        model.addAttribute("form", form);

        return "items/updateItemForm";
    }


    @PostMapping(value = "/items/{itemId}/edit")
    public String updateItem(@PathVariable Long itemId,@ModelAttribute("form") ItemForm form) {

        ItemDto itemDto=new ItemDto();
        itemDto.setId(form.getId());
        itemDto.setName(form.getName());
        itemDto.setPrice(form.getPrice());
        itemDto.setStockQuantity(form.getStockQuantity());

        System.out.println(itemId + form.getName() + form.getPrice() + form.getStockQuantity());
        //itemService.saveItem(itemDto);
        itemService.updateItem(itemDto);


        return "redirect:/items";
    }
}
