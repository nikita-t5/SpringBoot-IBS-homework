package ru.ibs.test.springBoot.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Engine {

    @Id
    @GeneratedValue
    private Long id;

    private String type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "engine")
    private List<Gear> gears;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Manual> manuals;
}
