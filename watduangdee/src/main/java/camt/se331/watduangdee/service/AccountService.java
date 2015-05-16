package camt.se331.watduangdee.service;

import camt.se331.watduangdee.entity.Account;
import camt.se331.watduangdee.entity.Product;

import java.util.List;

/**
 * Created by Asus N46V on 17/5/2558.
 */
public interface AccountService {
    List<Account> getAccounts();
    Account getAccount(Long id);
    Account addAccount(Account account);
    Account deleteAccount(Long id);
    Account updateAccount(Account account);
    List<Account> getAccountsByName(String name);
}
