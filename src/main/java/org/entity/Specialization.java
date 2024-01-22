package org.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SPECIALIZATION")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME_SPECIALIZATION")
    private String nameSpecialization;
    @Column(name = "DESCIPLINE_COUNT")
    private int disciplineCount;



    public Specialization(String nameSpecialization, int disciplineCount) {
        this.nameSpecialization = nameSpecialization;
        this.disciplineCount = disciplineCount;

    }



}
