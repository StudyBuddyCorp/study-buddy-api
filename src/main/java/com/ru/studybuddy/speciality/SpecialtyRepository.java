package com.ru.studybuddy.speciality;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, String> {

    @Query("select s.title from Specialty s where s.department.title = ?1 order by s.title asc")
    List<Object> findByDepartment_TitleOrderByTitleAsc(String title);

    Optional<Specialty> findByTitle(String title);
}
