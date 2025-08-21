
package com.example.sportsclub;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberService {
    private final MemberRepository repo;
    public MemberService(MemberRepository repo) { this.repo = repo; }

    public List<Member> getAll() { return repo.findAll(); }
    public Member getOne(Long id) { return repo.findById(id).orElseThrow(); }
    public Member create(Member m) { return repo.save(m); }
    public Member update(Long id, Member m) {
        Member e = getOne(id);
        e.setName(m.getName());
        e.setEmail(m.getEmail());
        e.setPhone(m.getPhone());
        e.setMembershipType(m.getMembershipType());
        e.setJoinDate(m.getJoinDate());
        e.setStatus(m.getStatus());
        return repo.save(e);
    }
    public void delete(Long id) { repo.deleteById(id); }
}