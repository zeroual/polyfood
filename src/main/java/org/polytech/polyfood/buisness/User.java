package org.polytech.polyfood.buisness;


import javax.persistence.*;

@Entity
@Table(name = "T_USERS")
public class User {

    @Id
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FIST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;


    @Column(name = "ENABLED")

    private boolean enabled = true;

    @OneToMany(cascade = CascadeType.ALL)

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
