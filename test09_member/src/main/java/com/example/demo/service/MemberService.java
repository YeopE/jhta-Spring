package com.example.demo.service;

import com.example.demo.dto.MemberDTO;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional //트랜잭션 처리
public class MemberService {
    @Autowired
    private MemberRepository mr;

    public MemberDTO insert(MemberDTO dto) {
        Member m = dto.toEntity();
        Member member = mr.save(m);
        mr.flush();
        MemberDTO memberDTO = new MemberDTO(member);
        return memberDTO;
    }

    //전체목록 반환하는 메소드
    public List<MemberDTO> list() {
        List<Member> mlist = mr.findAll();
//        기본코드
//        List<MemberDTO> dtoList = mlist.stream().map(m->{
//            return new MemberDTO(m);
//        }).toList();
//        람다식
//        List<MemberDTO> dtoList = mlist.stream().map(m->new MemberDTO(m)).toList();
//        메서드참조
        List<MemberDTO> dtoList = mlist.stream().map(MemberDTO::new).toList();
        return dtoList;
    }

    public void delete(String id) {
        mr.deleteById(id);
    }

    public MemberDTO select(String id) {
        Optional<Member> m = mr.findById(id);
        if(!m.isEmpty()) {
            return new MemberDTO(m.get());
        }else {
            return null;
        }
    }
    //수정메소드 완성해보세요. (비밀번호, 이메일, 나이)
    public MemberDTO update(MemberDTO dto) {
        Member m = dto.toEntity();
        Optional<Member> m1 = mr.findById(m.getId());
        if(!m1.isEmpty()) {
            Member m2 = m1.get();
            m2.setPwd(m.getPwd());
            m2.setEmail(m.getEmail());
            m2.setAge(m.getAge());
            mr.save(m2); //@Transactional 이 있으면 save를 하지 않아도 되지만, 없으면 save를 반드시 해줘야 한다.
            return new MemberDTO(m2);
        }
        return null;
    }
}
