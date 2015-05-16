package camt.se331.watduangdee.service;

import camt.se331.watduangdee.entity.User;
import camt.se331.watduangdee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Dell on 2/5/2558.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
@Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findUserByEmail(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }
}
