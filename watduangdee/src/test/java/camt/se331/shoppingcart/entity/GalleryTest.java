package camt.se331.shoppingcart.entity;

import camt.se331.watduangdee.entity.Gallery;
import camt.se331.watduangdee.entity.Image;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Asus N46V on 20/5/2558.
 */
public class GalleryTest {

    @Test
    public void testGetGalleryUsingMock(){
        Gallery gallery = mock(Gallery.class);
        when(gallery.getId()).thenReturn(1l);
        Set<Image> images = new HashSet<>();
        images.add(new Image());
        images.add(new Image());
        when(gallery.getImages()).thenReturn(images);
    }

}
