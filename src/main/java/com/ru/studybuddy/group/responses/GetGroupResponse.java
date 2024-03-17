package com.ru.studybuddy.group.responses;

import com.ru.studybuddy.group.GroupGroupAndId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetGroupResponse {
    private int status;
    private String message;
    private List<GroupGroupAndId> groups;
}
