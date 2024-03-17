package com.ru.studybuddy.speciality;

import com.ru.studybuddy.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, String> {

    @Query("select s.title from Speciality s where s.department.title = ?1 order by s.title asc")
    List<Object> findByDepartment_TitleOrderByTitleAsc(String title);



    Optional<Speciality> findByTitle(String title);
}
