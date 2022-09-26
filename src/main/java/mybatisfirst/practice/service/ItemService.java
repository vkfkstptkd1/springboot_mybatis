package mybatisfirst.practice.service;

import lombok.RequiredArgsConstructor;
import mybatisfirst.practice.Dto.ItemDto;
import mybatisfirst.practice.controller.mapper.ItemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemMapper itemMapper;


    @Transactional
    //아이템 저장
    public void saveItem(ItemDto itemDto){
        itemMapper.save(itemDto);
    }

    //아이템 조회
    public List<ItemDto> findItems(){
        return itemMapper.findAll();
    }

    public ItemDto findOne(Long itemId){

        return itemMapper.findOne(itemId);
    }

    /**
     * 영속성 컨텍스트가 자동 변경
     */
    @Transactional
    public ItemDto updateItem(ItemDto itemDto) {
        //ItemDto itemDto=itemMapper.findOne(itemId);
        itemMapper.update(itemDto);
        return itemDto;
    }
}
