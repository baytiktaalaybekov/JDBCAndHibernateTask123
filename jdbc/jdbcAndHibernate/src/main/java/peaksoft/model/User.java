package peaksoft.model;

import javax.persistence.*;
@Entity
@Table(name="users")
public class User {
    @Id
    private Long id;

    @Column
    private String Name;

    @Column
    private String lastName;

    @Column
    private Byte age;

    public User() {
    }

    public User(Long id, String name, String lastName, Byte age) {
        this.id = id;
        Name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User(String name, String lastName, byte age) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}