package camt.se331.watduangdee.repository;

import camt.se331.watduangdee.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dell on 2/5/2558.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findByEmailAndPassword(String email,String password);
}

