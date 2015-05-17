package camt.se331.watduangdee.dao;

import camt.se331.watduangdee.entity.Gallery;

import java.util.List;

/**
 * Created by Asus N46V on 18/5/2558.
 */
public interface GalleryDao {
    List<Gallery> getGallerys();
    Gallery getGallery(Long id);
    Gallery addGallery(Gallery gallery);
    Gallery deleteGallery(Gallery gallery);
    Gallery updateGallery(Gallery gallery);

}
