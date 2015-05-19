package camt.se331.watduangdee.service;

import camt.se331.watduangdee.dao.DbProductDao;
import camt.se331.watduangdee.dao.ProductDao;
import camt.se331.watduangdee.entity.Image;
import camt.se331.watduangdee.entity.Product;
import camt.se331.watduangdee.entity.User;
import camt.se331.watduangdee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Dto on 2/8/2015.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    UserRepository userRepository;

    public void setProductDao(DbProductDao productDao){
        this.productDao = productDao;
    }

    public Product getProduct(int id){
        List<Product> allProduct = productDao.getProducts();
        for(Product product : allProduct){
            if(product.getId()==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public Product getProduct(Long id) {
        return productDao.getProduct(id);
    }

    @Override
    public Product addProduct(Product product) {

        final String username="se552115047@vr.camt.info";
        final String password="552115047";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            List<User> user = new ArrayList<User>(userRepository.findAll());
            for(int i=0;i<user.size();i++){
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("se552115047@vr.camt.info"));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(user.get(i).getEmail()));
                message.setSubject("News : Duangdee Temple");
                message.setText("Update news of Duangdee Temple!! let's check our website, www.watduangdee.cloundapp.com");
                Transport.send(message);
            }

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return productDao.addProduct(product);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product = getProduct(id);
        return productDao.deleteProduct(product);
    }

    @Override
    public Product updateProduct(Product product) {
        product.setImages(productDao.getProduct(product.getId()).getImages());
        return productDao.updateProduct(product);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productDao.getProductsByName(name);
    }

    @Override
    @Transactional
    public Product addImage(Product product, Image image) {
        product.getImages().add(image);
        productDao.updateProduct(product);
        return product;
    }
}
