package com.ru.studybuddy.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID>, CourseRepositoryCustom {


    @Query("select " +
            "c.id as id, " +
            "c.title as title, " +
            "c.description as description, " +
            "c.createdAt as createdAt, " +
            "c.updatedAt as updatedAt, " +
            "count(students) as studentsCount " +
            "from Course c " +
            "left join c.students students " +
            "group by c.id " +
            "order by c.updatedAt desc")
    List<CourseData> getCoursesData();

    @Query("select " +
            "c.id as id, " +
            "c.title as title, " +
            "c.description as description, " +
            "c.createdAt as createdAt, " +
            "c.updatedAt as updatedAt, " +
            "count(students) as studentsCount " +
            "from Course c " +
            "left join c.students students " +
            "where LOWER(c.title) like %?1% " +
            "group by c.id " +
            "order by c.updatedAt desc")
    List<CourseData> getCoursesData(String title);

    @Query("select " +
            "c.id as id, " +
            "c.title as title, " +
            "c.description as description, " +
            "c.createdAt as createdAt, " +
            "c.updatedAt as updatedAt, " +
            "m as body, " +
            "count(students) as studentsCount " +
            "from Course c " +
            "left join c.students students " +
            "left join Markdown m on c.id = m.course.id " +
            "where c.id = ?1 " +
            "group by c.id, c.title, c.description, c.createdAt, c.updatedAt, m")
    Optional<CourseData> getCourseData(UUID id);

    Optional<CourseDataWithBody> getIdAndTitleAndDescriptionAndCreatedAtAndUpdatedAtAndBodyById(UUID id);

}

