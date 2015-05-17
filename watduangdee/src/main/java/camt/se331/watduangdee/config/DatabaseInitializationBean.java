package camt.se331.watduangdee.config;

import camt.se331.watduangdee.entity.*;
import camt.se331.watduangdee.repository.ProductRepository;
import camt.se331.watduangdee.repository.QandaRepository;
import camt.se331.watduangdee.repository.ShoppingCartRepository;
import camt.se331.watduangdee.repository.UserRepository;
import camt.se331.watduangdee.service.ImageUtil;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

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

    @Override
    public void afterPropertiesSet() throws Exception {

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
        admin.setEmail("admin@yahoo.com");
        admin.setPassword("123456");
        Set<Role> roles = new HashSet<>();
        roles.add(adminRole);
        admin.setRoles(roles);

        User user = new User();
        user.setUsername("user");
        user.setEmail("user@yahoo.com");
        user.setPassword("123456");
        Set<Role>   roles2  = new HashSet<>();
        roles2.add(userRole);
        user.setRoles(roles2);


        User foreignUser = new User();
        foreignUser.setUsername("fUser");
        foreignUser.setEmail("foreignUser@yahoo.com");
        foreignUser.setPassword("123456");
        Set<Role>   roles3  = new HashSet<>();
        roles3.add(foreignRole);
        foreignUser.setRoles(roles3);


        userRepository.save(admin);
        userRepository.save(user);
        userRepository.save(foreignUser);
        admin.setRoles(roles);
        user.setRoles(roles2);
        foreignUser.setRoles(roles3);
    }
}
