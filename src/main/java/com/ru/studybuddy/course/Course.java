package com.ru.studybuddy.course;

import com.ru.studybuddy.markdown.Markdown;
import com.ru.studybuddy.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = 2405172041950251807L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "text")
    @Builder.Default
    private String title = "";

    @Column(columnDefinition = "text")
    @Builder.Default
    private String description = "";

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    List<Markdown> body = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<User> students;

    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<User> teachers;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy h ? h.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy h ? h.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Course course = (Course) o;
        return getId() != null && Objects.equals(getId(), course.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy h ? h.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
