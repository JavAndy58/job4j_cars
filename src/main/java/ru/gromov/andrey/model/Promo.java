package ru.gromov.andrey.model;

import javax.persistence.*;

@Entity
@Table(name = "promos")
public class Promo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;
    private String carBrand;
    private String carBody;
    private byte[] photo;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
