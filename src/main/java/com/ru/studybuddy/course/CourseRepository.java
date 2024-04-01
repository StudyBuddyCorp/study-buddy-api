package com.ru.studybuddy.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {



    @Query("select c.id as id, c.title as title, c.description as description, c.createdAt as createdAt, c.updatedAt as updatedAt, count(students) as studentsCount FROM Course c LEFT JOIN c.students students GROUP BY c.id")
    List<CourseData> getCoursesData();



}
