/*
 * Java Web Programming
 * Modul 6: Klijentsko programiranje
 * Assignment:  Kreiranje web prodavnice    
 */

package model;

/**
 *
 * @author Aleksandar Stosic / ita16.aleksandarstosic
 * 
 */

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

    @Id
    private int id_category;
    private String name;

    public Category() {
    }

    public Category(int id_category, String name) {
        this.id_category = id_category;
        this.name = name;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" + "id_category=" + id_category + ", name=" + name + '}';
    }

}
