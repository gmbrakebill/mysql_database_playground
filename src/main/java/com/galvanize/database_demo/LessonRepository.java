package com.galvanize.database_demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson,Long>
{
 @Query(value = "SELECT * FROM lessons WHERE id = :id", nativeQuery = true)
    Lesson findById(long id);

}
