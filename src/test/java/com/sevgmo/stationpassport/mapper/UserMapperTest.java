package com.sevgmo.stationpassport.mapper;

import com.sevgmo.stationpassport.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeUsersTableTest.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterUsersTableTest.sql")
})
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void getUserById_testShouldReturnUserByIdFromDB() throws Exception {
        User user = userMapper.getUserById(1);
        String username = user.getUsername();
        assertEquals("Alexey", username);
    }

    @Test
    public void addNewUser_testShouldAddNewUserToDB() throws Exception {
        User user = new User("test","pass","test@test.test","777","ROLE_USER");
        userMapper.add(user);
        String username = userMapper.getUsernameById(3);
        assertEquals("test", username);
    }

    @Test
    public void updateUser_testShouldUpdateUserInDB() throws Exception {
        User user = new User();
        user.setId(1);
        user.setPhone("777");
        user.setEmail("qqq");
        userMapper.update(user);
        assertEquals("777", userMapper.getUserById(1).getPhone());
        assertEquals("qqq", userMapper.getUserById(1).getEmail());
    }

    @Test
    public void deleteUser_testShouldDeleteUserFromDB() throws Exception {
        userMapper.delete(1);
        assertEquals(null, userMapper.getUsernameById(1));
    }

    @Test
    public void getPasswordByUsername() throws Exception {
        String password = userMapper.getPasswordByUsername("Vlad");
        assertEquals("root",password);
    }

    @Test
    public void getRoleByUsername() throws Exception {
        String role = userMapper.getRoleByUsername("Alexey");
        assertEquals("ROLE_ADMIN",role);
    }

    @Test
    public void getUsernameById() throws Exception {
        String name = userMapper.getUsernameById(1);
        assertEquals("Alexey", name);
    }

}