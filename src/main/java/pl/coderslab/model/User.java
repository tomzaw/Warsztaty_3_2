package pl.coderslab.model;

import java.time.LocalDateTime;


/**
 *
 * @author Tomek
 */
public class User {
    
    private String name;
    private String surname;
    private String email;
    private LocalDateTime birthDate;

    public User(String name, String surname, String email, LocalDateTime birthDate) {
        this.name = name;
        this.surname = surname;
        this.name = email;
        this.birthDate = birthDate;
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

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", surname=" + surname + ", birthDate=" + birthDate + '}';
    }
    
}
