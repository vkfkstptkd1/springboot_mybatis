package mybatisfirst.practice.controller.mapper;

import mybatisfirst.practice.Dto.DeliveryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeliveryMapper {
    void save(DeliveryDto deliveryDto);
}
