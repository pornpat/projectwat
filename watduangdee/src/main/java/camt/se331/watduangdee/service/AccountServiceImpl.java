package camt.se331.watduangdee.service;

import camt.se331.watduangdee.dao.AccountDao;
import camt.se331.watduangdee.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Asus N46V on 17/5/2558.
 */
public class AccountServiceImpl implements  AccountService {

    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    @Override
    public Account getAccount(Long id) {
        return accountDao.getAccount(id);
    }

    @Override
    public Account addAccount(Account account) {
        return accountDao.addAccount(account);
    }

    @Override
    public Account deleteAccount(Long id) {
        Account account = getAccount(id);
        return accountDao.deleteAccount(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountDao.updateAccount(account);
    }

    @Override
    public List<Account> getAccountsByName(String name) {
        return accountDao.getAccountsByName(name);
    }
}
