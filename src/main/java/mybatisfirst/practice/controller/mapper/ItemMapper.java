package mybatisfirst.practice.controller.mapper;

import mybatisfirst.practice.Dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    //item 저장
    void save(ItemDto itemDto);

    //하나 조회
    ItemDto findOne(Long id);

    //전체조회
    List<ItemDto> findAll();

    //재고 수정
    void update(ItemDto itemDto);
}
