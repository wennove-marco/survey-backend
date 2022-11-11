package com.survey.model;

import javax.persistence.*;

@Entity
@Table(name = "submitted_survey")
public class Submitted_Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_survey")
    private long id_survey;

    @Column(name = "id_mail")
    private String id_mail;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_survey", nullable = false, insertable = false, updatable = false)
    private Survey_Table survey;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_mail", nullable = false, insertable = false, updatable = false)
    private User user;

    public Submitted_Survey () { }
    public Submitted_Survey(long id_survey, String id_mail) {
        this.id_survey = id_survey;
        this.id_mail = id_mail;
    }
    public long getId () { return this.id; }
    public long getId_survey () { return this.id_survey; }
    public String getId_mail () { return this.id_mail; }
    public void setId_survey (long id_survey) { this.id_survey = id_survey; }
    public void setId_mail (String id_mail) { this.id_mail = id_mail; }
}
