package com.ru.studybuddy.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ru.studybuddy.department.Department;
import com.ru.studybuddy.speciality.Specialty;
import com.ru.studybuddy.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serial;
import java.io.Serializable;
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
@Table(name = "groups")
public class Group implements Serializable {

    @Serial
    private static final long serialVersionUID = 2405172041950251807L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int number;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Specialty specialty;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Department department;

    @OneToMany
    @JsonIgnore
    @ToString.Exclude
    private List<User> students;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<SubGroup> subgroups;


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy h ? h.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy h ? h.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Group group = (Group) o;
        return getId() != null && Objects.equals(getId(), group.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy h ? h.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
