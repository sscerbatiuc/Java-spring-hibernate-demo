package edu.step.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee", schema = "app")
public class Employee implements Serializable {

    private static final long serialVersionUID = 123L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "name", unique = false, length = 100)
    private String name;
    @Column(name = "address", unique = false, length = 100)
    private String address;
    @Column(name = "phoneno", unique = false, length = 100)
    private String phoneno;

    public Employee() {
    }

    public Employee(String name, String address, String phoneno) {
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
    }

    public Employee(Integer id, String name, String address, String phoneno) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneno = phoneno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
