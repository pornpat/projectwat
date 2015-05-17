package camt.se331.watduangdee.controller;

import camt.se331.watduangdee.entity.User;
import camt.se331.watduangdee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by TEN10 on 5/17/2015.
 */
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "user",method = RequestMethod.GET)
    public List<User> list(){
        return userService.findAll();
    }

    @RequestMapping(value = "user",method = RequestMethod.POST)
    public User add(@RequestBody User user, BindingResult bindingResult){
        return userService.addUser(user);
    }

    @RequestMapping(value = "user/{id}",method = RequestMethod.PUT)
    public  User edit(@PathVariable("id") Long id,@RequestBody User user, BindingResult bindingResult){
        return userService.updateUser(user);
    }



}
