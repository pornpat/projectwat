package camt.se331.watduangdee.dao;

import camt.se331.watduangdee.entity.Account;
import camt.se331.watduangdee.entity.Product;
import camt.se331.watduangdee.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Asus N46V on 17/5/2558.
 */
public class DbAccountDao implements AccountDao{

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAccountsByName(String name) {
        return accountRepository.findByNameContaining(name);
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findOne(id);
    }

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account deleteAccount(Account account) {
        accountRepository.delete(account);
        account.setId(null);
        return account;
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }
}
