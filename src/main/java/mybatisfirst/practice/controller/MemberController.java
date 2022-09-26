package mybatisfirst.practice.controller;

import lombok.RequiredArgsConstructor;
import mybatisfirst.practice.Dto.AddressDto;
import mybatisfirst.practice.Dto.MemberDto;
import mybatisfirst.practice.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm",new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result){
        MemberDto memberDto = new MemberDto();
        if (result.hasErrors()){
            return "members/createMemberForm";
        }

        AddressDto addressDto= new AddressDto(form.getCity(), form.getStreet(), form.getZipcode());

        memberDto.setName(form.getName());
        memberDto.setAddressDto(addressDto);

        memberService.join(memberDto);
        return "redirect:/"; // 홈으로 보내버림.
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<MemberDto> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

    }
