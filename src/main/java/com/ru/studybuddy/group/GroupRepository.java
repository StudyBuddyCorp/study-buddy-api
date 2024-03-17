package com.ru.studybuddy.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {

//    @Query("select g.group, g.id from Group g where g.department.title = ?1 and g.specialty.title = ?2")
    List<GroupGroupAndId> findByDepartment_TitleAndSpecialty_Title(String title, String title1);

}
