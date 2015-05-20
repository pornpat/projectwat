package camt.se331.shoppingcart.entity;

import camt.se331.watduangdee.entity.Product;
import camt.se331.watduangdee.entity.Role;
import camt.se331.watduangdee.entity.User;
import camt.se331.watduangdee.service.UserService;
import camt.se331.watduangdee.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Asus N46V on 20/5/2558.
 */
public class UserTest {

    UserService userService;

    @Before
    public void setUp(){
        userService = mock(UserServiceImpl.class);
    }

    @Test
    public void testGetUserUsingMock(){
        User admin = mock(User.class);
        when(admin.getId()).thenReturn(1l);
        when(admin.getUsername()).thenReturn("admin");
        when(admin.getPassword()).thenReturn("admin");
        when(admin.getEmail()).thenReturn("admin@gmail.com");

        Role role1 = new Role();
        role1.setId(1l);
        role1.setRoleName("admin");
        Set<Role> roles1 = new HashSet<>();
        roles1.add(role1);

        when(admin.getRoles()).thenReturn(roles1);

        User user = mock(User.class);
        when(user.getId()).thenReturn(1l);
        when(user.getUsername()).thenReturn("user");
        when(user.getPassword()).thenReturn("1234");
        when(user.getEmail()).thenReturn("user@gmail.com");

        Role role2 = new Role();
        role2.setId(2l);
        role2.setRoleName("user");
        Set<Role> roles2 = new HashSet<>();
        roles2.add(role2);

        when(admin.getRoles()).thenReturn(roles2);

    }

    @Test
    public void testAddUserUsingMock(){
        Role role = new Role("user");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        userService.addUser(new User(1l, "user", "user@gmail.com", "1234", roles));
        when(userService.addUser(new User(1l, "user", "user@gmail.com", "1234", roles))).thenReturn(new User(1l, "user", "user@gmail.com", "1234", roles));
        assertThat(userService.addUser(new User(1l, "user", "user@gmail.com", "1234", roles)), is(new User(1l, "user", "user@gmail.com", "1234", roles)));
    }

}
