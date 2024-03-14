package com.ru.studybuddy.user.rest;

import com.ru.studybuddy.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentResponse {

   private String message;
   private int status;
   private User user;
}
