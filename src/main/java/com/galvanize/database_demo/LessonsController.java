package com.galvanize.database_demo;

import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/lessons")
public class LessonsController
{
   private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/list")
            public Iterable<Lesson> getAll()
    {
        return this.repository.findAll();

    }
    @PostMapping("/save")
    public Lesson create(@RequestBody Lesson lesson)
    {
        return this.repository.save(lesson);
    }
    @GetMapping("by-id")
    public Lesson byId(@RequestParam("id") long id)
    {
        return this.repository.findById(id);
    }
    @DeleteMapping("delete-id")
    public void DbyId(@RequestParam("id") long id)
    {
         this.repository.deleteById(id);
    }
    @PatchMapping("/id/{id}")
    public Lesson patch (@PathVariable Long id, @RequestBody Lesson lesson)
    {
       Lesson oldLesson = this.repository.findById(id).get();
       oldLesson.setTitle(lesson.getTitle());
       oldLesson.setDeliveredOn(lesson.getDeliveredOn());
       return this.repository.save(oldLesson);
    }
    @GetMapping("/lessons/find")
    public Lesson getLessonByTitle(@RequestParam(name = "title") String title)
    {
        return this.repository.findByTitle(title);
    }
    @GetMapping("lessons/between")
    public Iterable<Lesson> between(@RequestParam(name = "date") Date[] dates)
    {
        return this.repository.deliveredBetween(dates[0], dates[1]);
    }
}
