package com.survey.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "mail", unique=true)
    private String mail;

    @Column(name = "pass")
    private String pass;

    @Column(name = "is_admin")
    private long isAdmin;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "submitted_survey",
            joinColumns        = { @JoinColumn(name = "id_mail") },
            inverseJoinColumns = { @JoinColumn(name = "id_survey") })
    private List<Survey_Table> surveys = new ArrayList<>();

    public User () { }
    public User (String mail, String pass, long isAdmin) {
        this.mail    = mail;
        this.pass    = pass;
        this.isAdmin = isAdmin;
    }
    public String getMail () {
        return this.mail;
    }
    public void setMail (String mail) {
        this.mail = mail;
    }
    public String getPass () {
        return this.pass;
    }
    public void setPass (String pass) {
        this.pass = pass;
    }
    public long getIsAdmin () {
        return this.isAdmin;
    }
    public void setIsAdmin (long isAdmin) {
        this.isAdmin = isAdmin;
    }
    public List<Survey_Table> getSurveys () { return this.surveys; }
    @Override
    public String toString () {
        return "User [mail=" + mail + ", pass=" + pass + ", isAdmin=" + isAdmin + "]";
    }
}