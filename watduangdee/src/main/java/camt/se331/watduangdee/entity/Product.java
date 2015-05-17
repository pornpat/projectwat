package camt.se331.watduangdee.entity;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dto on 2/7/2015.
 */
@Entity
public class Product implements Comparable{
    @Id
    @GeneratedValue
    Long id;
    String name;
    String description;
    String date;

    @OneToMany(fetch= FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Image> images = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product(){

    };

    public Product(Long id,String name, String description, String date,Image image) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.id = id;
        this.getImages().add(image);
    }

    public Product(Long id,String name, String description, String date) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(Object o) {

        return (int) (this.getId() - ((Product)o).getId());
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (getId() != null ? !getId().equals(product.getId()) : product.getId() != null) return false;
        if (getName() != null ? !getName().equals(product.getName()) : product.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(product.getDescription()) : product.getDescription() != null)
            return false;
        if (getDate() != null ? !getDate().equals(product.getDate()) : product.getDate() != null)
            return false;
        return !(getImages() != null ? !getImages().equals(product.getImages()) : product.getImages() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getImages() != null ? getImages().hashCode() : 0);
        return result;
    }
}
