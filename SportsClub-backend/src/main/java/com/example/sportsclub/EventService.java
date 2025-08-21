package com.example.sportsclub;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class EventService {
    private final EventRepository repo;
    public EventService(EventRepository repo) { this.repo = repo; }

    public List<Event> getAll() { return repo.findAll(); }
    public Event getOne(Long id) { return repo.findById(id).orElseThrow(); }
    public Event create(Event e) { return repo.save(e); }
    public void delete(Long id) { repo.deleteById(id); }
}