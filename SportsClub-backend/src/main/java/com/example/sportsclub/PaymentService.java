package com.example.sportsclub;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentService {
    private final PaymentRepository repo;
    public PaymentService(PaymentRepository repo) { this.repo = repo; }

    public List<Payment> getAll() { return repo.findAll(); }
    public Payment getOne(Long id) { return repo.findById(id).orElseThrow(); }
    public Payment create(Payment p) { return repo.save(p); }
}