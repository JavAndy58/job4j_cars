package ru.gromov.andrey.model;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Driver() {
    }
}
