package ru.ibs.test.springBoot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gear {

    @Id
    @GeneratedValue
    private Long id;

    private Long gearSize;

    @ManyToOne
    @JoinColumn(name = "ENGINE_ID", referencedColumnName = "ID")
    private Engine engine;
}
