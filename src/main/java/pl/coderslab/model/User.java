package pl.coderslab.model;

import java.time.LocalDate;


/**
 *
 * @author Tomek
 */
public class User {
    
    private int id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;

    public User(String name, String surname, String email, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.name = email;
        this.birthDate = birthDate;
    }

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", surname=" + surname + ", birthDate=" + birthDate + '}';
    }
}
