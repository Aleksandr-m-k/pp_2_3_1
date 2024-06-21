package web.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    //@Column(name = "Id")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   // @Column(name = "Name")
    private String name;
    //@Column(name = "Surname")
    private String surname;
    //@Column(name = "Age")
    private int age;

    public User() {
    }

    public User(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}

