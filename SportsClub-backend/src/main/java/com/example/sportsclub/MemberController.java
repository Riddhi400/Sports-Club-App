package com.example.sportsclub;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "http://localhost:4200")
public class MemberController {
    private final MemberService service;
    public MemberController(MemberService service) { this.service = service; }

    @GetMapping public List<Member> all() { return service.getAll(); }
    @GetMapping("/{id}") public Member one(@PathVariable Long id) { return service.getOne(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Member create(@RequestBody Member m) { return service.create(m); }
    @PutMapping("/{id}") public Member update(@PathVariable Long id, @RequestBody Member m) { return service.update(id, m); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}