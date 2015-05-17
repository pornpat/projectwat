package camt.se331.watduangdee.service;

import camt.se331.watduangdee.dao.GalleryDao;
import camt.se331.watduangdee.entity.Gallery;
import camt.se331.watduangdee.entity.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Asus N46V on 18/5/2558.
 */

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    GalleryDao galleryDao;

    @Override
    public List<Gallery> getGallerys() {
        return galleryDao.getGallerys();
    }

    @Override
    public Gallery getGallery(Long id) {
        return galleryDao.getGallery(id);
    }

    @Override
    public Gallery addGallery(Gallery gallery) {
        return galleryDao.addGallery(gallery);
    }

    @Override
    public Gallery deleteGallery(Long id) {
        Gallery gallery = getGallery(id);
        return galleryDao.deleteGallery(gallery);
    }

    @Override
    public Gallery updateGallery(Gallery gallery) {
        gallery.setImages(galleryDao.getGallery(gallery.getId()).getImages());
        return galleryDao.updateGallery(gallery);
    }

    @Override
    public List<Gallery> getGallerysByName(String name) {
        return null;
    }

    @Override
    public Gallery addImage(Gallery gallery, Image image) {
        gallery.getImages().add(image);
        galleryDao.updateGallery(gallery);
        return gallery;
    }
}
