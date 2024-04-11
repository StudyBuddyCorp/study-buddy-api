package com.ru.studybuddy.speciality;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ru.studybuddy.department.Department;
import com.ru.studybuddy.group.Group;
import com.ru.studybuddy.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Specialty implements Serializable {

    @Serial
    private static final long serialVersionUID = 2405172041950251807L;

    @Id
    @Column(columnDefinition = "text")
    private String title;

    @OneToMany
    @JsonIgnore
    @ToString.Exclude
    private List<Group> groups;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Department department;

    @OneToMany
    @JsonIgnore
    @ToString.Exclude
    private List<User> users;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy h ? h.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy h ? h.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Specialty that = (Specialty) o;
        return getTitle() != null && Objects.equals(getTitle(), that.getTitle());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy h ? h.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
