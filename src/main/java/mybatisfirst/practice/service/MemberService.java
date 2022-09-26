package mybatisfirst.practice.service;

import lombok.RequiredArgsConstructor;
import mybatisfirst.practice.Dto.MemberDto;
import mybatisfirst.practice.controller.mapper.MemberMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;

    @Transactional
    public Long join(MemberDto memberDto)
    {
        //validateDuplicateMember(memberMapperDto); // 중복회원 검증
        //memberRepository.save(member);
        memberMapper.saveMember(memberDto);
        return memberDto.getId();
    }


    public List<MemberDto> findMembers() {
        for (MemberDto memberDto : memberMapper.findAll()) {
            System.out.println(memberDto.toString());
        }

        return memberMapper.findAll();
    }
}
