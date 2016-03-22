/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.Humans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author lenfer
 */
public class Human implements Serializable {
    private String name;
    private Date dateOfBirth;
    public enum Gender { MALE, FEMALE };
    private Gender gender;

    public Human(final String name,
            final Date dateOfBirth,
            final Gender gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final Date getDateOfBirth() {
        return dateOfBirth;
    }

    public final void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public final Gender getGender() {
        return gender;
    }

    public final void setGender(final Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human{" + "name=" + name + ", dateOfBirth=" 
                + dateOfBirth + ", gender=" + gender + '}';
    }
    
}
