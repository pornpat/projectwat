package camt.se331.watduangdee.service;

import camt.se331.watduangdee.entity.Gallery;
import camt.se331.watduangdee.entity.Image;

import java.util.List;

/**
 * Created by Asus N46V on 18/5/2558.
 */
public interface GalleryService {

    List<Gallery> getGallerys();
    Gallery getGallery(Long id);
    Gallery addGallery(Gallery gallery);
    Gallery deleteGallery(Long id);
    Gallery updateGallery(Gallery gallery);
    List<Gallery> getGallerysByName(String name);

    Gallery addImage(Gallery gallery, Image image);

}
