package camt.se331.watduangdee.repository;

import camt.se331.watduangdee.entity.Account;
import camt.se331.watduangdee.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Asus N46V on 17/5/2558.
 */
public interface AccountRepository extends JpaRepository<Account,Long>{
    public List<Account> findByNameLike(String name);
    public List<Account> findByNameContaining(String name);
    public List<Account> findByNameContainingIgnoreCase(String name);
    public List<Account> findByNameOrDescriptionContainingIgnoreCase(String name,String description);
}
