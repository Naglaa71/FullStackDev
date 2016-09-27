package com.fullstackdev.backend.persistence.domain.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by nagla on 9/27/2016.
 */
@Entity
public class Plan implements Serializable{
   /** the serial version uid for serializable classess **/
   private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String name;

    /** defualt constractor     **/
    public Plan(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        return id == plan.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
