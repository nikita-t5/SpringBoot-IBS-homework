package ru.ibs.test.springBoot.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String manufacturerName;

    private String modelName;

    @OneToOne(cascade = CascadeType.ALL)
    private Engine engine;

    @OneToOne(cascade = CascadeType.ALL)
    private SteeringWheel steeringWheel;
}
