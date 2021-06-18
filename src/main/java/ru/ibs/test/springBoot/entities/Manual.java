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
public class Manual {
    @Id
    @GeneratedValue
    private Long id;

    private String type;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "manuals")
    List<Engine> engines;
}
