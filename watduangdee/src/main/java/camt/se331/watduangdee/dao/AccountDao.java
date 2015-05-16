package camt.se331.watduangdee.dao;

import camt.se331.watduangdee.entity.Account;
import camt.se331.watduangdee.entity.Product;

import java.util.List;

/**
 * Created by Asus N46V on 17/5/2558.
 */
public interface AccountDao {
    List<Account> getAccounts();
    List<Account> getAccountsByName(String name);
    Account getAccount(Long id);
    Account addAccount(Account account);
    Account deleteAccount(Account account);
    Account updateAccount(Account account);
}
