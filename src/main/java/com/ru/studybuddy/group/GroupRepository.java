package com.ru.studybuddy.group;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, UUID> {

    List<GroupIdAndNumber> findByDepartment_TitleAndSpecialty_Title(String department, String specialty);

}
