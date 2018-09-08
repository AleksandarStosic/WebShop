/*
 * Java Web Programming
 * Modul 6: Klijentsko programiranje
 * Assignment:  Kreiranje web prodavnice    
 */

package model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Aleksandar Stosic / ita16.aleksandarstosic
 * 
 */

@Entity
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_product;
    private String name;
    private double price;
    private int barcode;
    private String author; 
    private String description;
    private String image;
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "id_category")
    private Category category;
    private int quantity;
    
    
    public Product() {
    }

    public Product(int id_product, String name, double price, int barcode, String author, String description,  String image, Category category, int quantity) {
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.barcode = barcode;
        this.author = author;
        this.description = description;
        this.category = category;
        this.quantity = quantity;
        this.image = image;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "id_product=" + id_product + ", name=" + name + ", price=" + price + ", barcode=" + barcode + ", author=" + author + ", description=" + description + ", image=" + image + ", category=" + category + ", quantity=" + quantity + '}';
    }

    
    
    

    

  
  
   
}
