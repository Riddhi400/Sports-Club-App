package com.example.sportsclub;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController {
    private final EventService service;
    public EventController(EventService service) { this.service = service; }

    @GetMapping public List<Event> all() { return service.getAll(); }
    @GetMapping("/{id}") public Event one(@PathVariable Long id) { return service.getOne(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Event create(@RequestBody Event e) { return service.create(e); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}