package example.StudentDB.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student implements Serializable {
    private static final long serialVersionUID = 4912517094299765463L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private Long id;
    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "middlename", nullable = false)
    private String middleName;
    @Column(name = "lastname", nullable = false)
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birthdate", nullable = false)
    private LocalDate birthDate;
    @Column(name = "_group_", nullable = false)
    private String group;

    public Student() {
    }

    public Student(Long id, String firstName, String middleName, String lastName, LocalDate birthDate, String group) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", group='" + group + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id.equals(student.id) && firstName.equals(student.firstName) && middleName.equals(student.middleName) && lastName.equals(student.lastName) && birthDate.equals(student.birthDate) && group.equals(student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, birthDate, group);
    }
}
