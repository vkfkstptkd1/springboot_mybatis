package mybatisfirst.practice.controller.mapper;

import mybatisfirst.practice.Dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    //회원 가입
    void saveMember(MemberDto memberDto);

    //회원 조회
    //한명
    public MemberDto findOne(Long id);
    //전체
    List<MemberDto> findAll();
    //public List<MemberDto> findAll();

    //이름으로 찾기
}
