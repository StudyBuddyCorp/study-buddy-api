package com.ru.studybuddy.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    Optional<Department> findByTitle(String title);
    @Query("select d.title from Department d order by d.title asc")
    List<Object> findAllOrderByTitleAsc();

}
