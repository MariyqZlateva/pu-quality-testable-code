package com.mariazlateva.puqualitytestablecode.kindergarden.domain;

import com.mariazlateva.puqualitytestablecode.kindergarden.basemodel.BasePerson;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
public class Administrator implements BasePerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }
}
