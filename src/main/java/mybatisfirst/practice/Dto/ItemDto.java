package mybatisfirst.practice.Dto;

import lombok.*;
import mybatisfirst.practice.Exception.NotEnoughStockException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ItemDto {

    private String dtype;
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    public ItemDto(Long id, String name, int price, int stockQuantity) {
        this.dtype = "B";
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }
    //    stock 감소
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock<0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
