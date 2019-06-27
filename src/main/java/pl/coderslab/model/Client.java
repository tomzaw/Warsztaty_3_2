package pl.coderslab.model;

/**
 *
 * @author Tomek
 */
public class Client {
    
    private int id;
    private String name;
    private String surname;
    private String address;
    private int phone;

    public Client(String name, String surname, String address, int phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    public Client() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", surname=" + surname + ", address=" + address + ", phone=" + phone + '}';
    }
}
