package com.galvanize.database_demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
public class LessonsController
{
   private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/all")
            public Iterable<Lesson> getAll()
    {
        return this.repository.findAll();

    }
    @PostMapping("/save")
    public Lesson create(@RequestBody Lesson lesson)
    {
        return this.repository.save(lesson);
    }
}
