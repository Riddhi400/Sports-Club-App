package com.example.sportsclub;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
    private final PaymentService service;
    public PaymentController(PaymentService service) { this.service = service; }

    @GetMapping public List<Payment> all() { return service.getAll(); }
    @GetMapping("/{id}") public Payment one(@PathVariable Long id) { return service.getOne(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Payment create(@RequestBody Payment p) { return service.create(p); }
}