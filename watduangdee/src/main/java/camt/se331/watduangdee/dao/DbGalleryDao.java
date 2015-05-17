package camt.se331.watduangdee.dao;

import camt.se331.watduangdee.entity.Gallery;
import camt.se331.watduangdee.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Asus N46V on 18/5/2558.
 */

@Repository
public class DbGalleryDao implements GalleryDao  {

    @Autowired
    GalleryRepository galleryRepository;

    @Override
    public List<Gallery> getGallerys() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery getGallery(Long id) {
        return galleryRepository.findOne(id);
    }

    @Override
    public Gallery addGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Override
    public Gallery deleteGallery(Gallery gallery) {
        galleryRepository.delete(gallery);
        gallery.setId(null);
        return gallery;
    }

    @Override
    public Gallery updateGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }
}