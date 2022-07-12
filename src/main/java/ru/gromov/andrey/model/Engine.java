package ru.gromov.andrey.model;

import javax.persistence.*;

@Entity
@Table(name = "engines")
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Engine() {
    }
}
