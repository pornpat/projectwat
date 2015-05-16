package camt.se331.watduangdee.controller;

import camt.se331.watduangdee.entity.Account;
import camt.se331.watduangdee.entity.Product;
import camt.se331.watduangdee.service.AccountService;
import camt.se331.watduangdee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by TEN10 on 5/17/2015.
 */

@RestController
@RequestMapping("/")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "account",method = RequestMethod.GET)
    public List<Account> list(){
        return accountService.getAccounts();
    }


    @RequestMapping(value = "getAccount",method = RequestMethod.GET)
    public  List<Account> getListByName(@RequestParam("name")String name){
        return accountService.getAccountsByName(name);
    }
    @RequestMapping(value = "account",method = RequestMethod.POST)
    public @ResponseBody
    Account add(@RequestBody Account account, BindingResult bindingResult){
        return accountService.addAccount(account);
    }

    @RequestMapping(value = "account/{id}",method = RequestMethod.GET)
    public  Account getAccount(@PathVariable("id") Long id){
        return accountService.getAccount(id);
    }

    @RequestMapping(value = "account/{id}",method = RequestMethod.PUT)
    public  Account edit(@PathVariable("id") Long id,@RequestBody Account account, BindingResult bindingResult){
        return accountService.updateAccount(account);
    }

    @RequestMapping(value = "account/{id}",method = RequestMethod.DELETE)
    public  Account edit(@PathVariable("id") Long id){
        return accountService.deleteAccount(id);
    }
}
