package org.userapplication;

import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {


    private UserList mockUserList;
    private UserService userService;


    @BeforeEach
    void setUp(){
        mockUserList = Mockito.mock(UserList.class);
        userService = new UserService(mockUserList);
    }


    @Test
    void testCreateUser(){
        User user = userService.createUser("1","Tim Preston","timpreston@gmail.com","","","");
        assertNotNull(user);
        assertEquals("Tim Preston",user.getUserName());
        assertEquals("timpreston@gmail.com",user.getUserEmail());
        Mockito.verify(mockUserList).addUser(user);
    }

    @Test
    void testGetUserByIdFound() {
        User mockUser = new User.Builder("1", "John Doe", "johndoe@example.com").build();
        Mockito.when(mockUserList.getUserById("1")).thenReturn(mockUser);

        User user = userService.getUserById("1");
        assertNotNull(user);
        assertEquals("John Doe", user.getUserName());
    }

    @Test
    void testGetUserByIdNotFound() {
        Mockito.when(mockUserList.getUserById("2")).thenReturn(null);

        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            userService.getUserById("2");
        });

        String expectedMessage = "No user found with ID: 2";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}