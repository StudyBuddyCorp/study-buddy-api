package com.ru.studybuddy.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
class ApiValidationError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

}