package mybatisfirst.practice.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
public class AddressDto {
    private String city;
    private String street;
    private String zipcode;

    protected AddressDto(){}//jpa는 이거 생성해둬야함. 무슨 기술 사용할 때 생성자 필요하다는데 .. 몬말이야
    public AddressDto(String city,String street,String zipcode){
        this.city=city;
        this.street=street;
        this.zipcode=zipcode;
    }
}
