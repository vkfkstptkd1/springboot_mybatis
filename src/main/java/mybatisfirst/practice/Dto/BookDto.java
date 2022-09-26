package mybatisfirst.practice.Dto;

import lombok.Data;

@Data
public class BookDto extends ItemDto {
    private String author;
    private String isbn;
}
