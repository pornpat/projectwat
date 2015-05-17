package camt.se331.watduangdee.config;

import camt.se331.watduangdee.entity.*;
import camt.se331.watduangdee.repository.*;
import camt.se331.watduangdee.service.ImageUtil;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Dto on 2/11/2015.
 */
@Component
@Profile("db.init")
public class DatabaseInitializationBean implements InitializingBean {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    QandaRepository qandaRepository;
    @Autowired
    GalleryRepository galleryRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

        Gallery[] initGallery = {
                new Gallery(1l, ImageUtil.getImage("pic/gal1.JPG")),
                new Gallery(2l, ImageUtil.getImage("pic/gal1.JPG")),
                new Gallery(3l, ImageUtil.getImage("pic/gal1.JPG")),
                new Gallery(4l, ImageUtil.getImage("pic/gal1.JPG"))
        };

        galleryRepository.save(Arrays.asList(initGallery));

        Product[] initProduct =  {
                new Product(1l,"asdasdas","asdasdsadasdasdasdasdasasdasd","2015-05-18", ImageUtil.getImage("pic/x.png")),
                new Product(2l,"asdsad","asdfsdfsfsadfsdfsadfsdf","2015-05-25",ImageUtil.getImage("pic/x.png"))
        };

        productRepository.save(Arrays.asList(initProduct));

        Qanda[] initQuada =  {
                new Qanda(1l,"Kindle","the good book reader"),
                new Qanda(2l,"Surface Pro","The unknow computer")
        };

        qandaRepository.save(Arrays.asList(initQuada));

        Role adminRole = new Role("admin");
        Role userRole  = new Role("user");
        Role foreignRole = new Role("foreign user");

        User admin = new User();
        admin.setUsername("admin");
        admin.setEmail("adminduangdee@gmail.com");
        admin.setPassword("admin");
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        admin.setRoles(roles);

        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testtest@gmail.com");
        user.setPassword("test");
        Set<Role> roles2  = new HashSet<>();
        roles2.add(userRole);
        user.setRoles(roles2);

        userRepository.save(admin);
        userRepository.save(user);
        admin.setRoles(roles);
        user.setRoles(roles2);
    }
}
