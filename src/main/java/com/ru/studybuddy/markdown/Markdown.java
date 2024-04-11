package com.ru.studybuddy.markdown;

import com.ru.studybuddy.course.Course;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
public class Markdown {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Lob
    @Column(columnDefinition = "text")
    private String body;


    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private int order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    Course course;
}
