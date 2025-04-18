package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor //생성자로 객체 주입
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberDTO join(MemberDTO dto) {
        Member member = dto.toEntity();
        Member m = memberRepository.save(member);
        return new MemberDTO(m);
    }

    //전체데이터를 리턴
    public List<MemberDTO> list() {
        List<Member> mList = memberRepository.findAll();
        List<MemberDTO> dtoList = mList.stream().map(MemberDTO::new).toList();
        return dtoList;
    }

    //삭제(delete)
    public void delete(String id) {
        memberRepository.deleteById(id);
    }

    //아이디로 조회(select)
    public MemberDTO selectId(String id) {
        Optional<Member> m = memberRepository.findById(id);
        if(m.isPresent()) {
            return new MemberDTO(m.get());
        }
        return null;
    }

    //수정(update)
    public MemberDTO update(MemberDTO dto) {
        Optional<Member> m = memberRepository.findById(dto.getId());
        if(m.isPresent()) {
            Member m2 = m.get();
            m2.setPwd(dto.getPwd());
            m2.setEmail(dto.getEmail());
            m2.setAge(dto.getAge());
//            memberRepository.save(m2);
            return new MemberDTO(m2);
        }
        return null;
    }

}
