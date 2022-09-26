package mybatisfirst.practice.controller;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ItemForm {

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
}
