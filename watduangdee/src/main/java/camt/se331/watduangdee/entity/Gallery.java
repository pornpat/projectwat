package camt.se331.watduangdee.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Asus N46V on 18/5/2558.
 */

@Entity
public class Gallery {
    @Id
    @GeneratedValue
    Long id;

    @OneToMany(fetch= FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Image> images = new HashSet<>();

    public Gallery(){

    }

    public Gallery(Long id, Image image) {
        this.id = id;
        this.getImages().add(image);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
}
