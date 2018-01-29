package com.sevgmo.stationpassport.repository;

import com.sevgmo.stationpassport.model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeUsersTableTest.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterUsersTableTest.sql")
})
public class RepositoryTest {

   @Autowired
   private SqlSession sqlSession;

    @Test
    public void getAll() throws Exception {
        List<User> users = sqlSession.selectList("getAllUsersFromDB");
        User user1 = users.get(0);
        User user2 = users.get(1);
        assertNotNull(users);
        assertEquals("Alexey",user1.getUsername());
        assertEquals("Vlad", user2.getUsername());
    }

    @Test
    public void getUserById_testShouldReturnUserByIdFromDB() throws Exception {
        User user = sqlSession.selectOne("getUserById",1);
        String username = user.getUsername();
        assertEquals("Alexey", username);
    }

    @Test
    public void addNewUser_testShouldAddNewUserToDB() throws Exception {
        User user = new User("test","pass","test@test.test","777","ROLE_USER");
        sqlSession.insert("AddUserToDB",user);
        user = sqlSession.selectOne("getUserById",3);
        assertEquals("test", user.getUsername());
    }

    @Test
    public void updateUser_testShouldUpdateUserInDB() throws Exception {
        User user = new User();
        user.setId(1);
        user.setPhone("777");
        user.setEmail("qqq");
        sqlSession.update("updateUserInDB",user);
        user = sqlSession.selectOne("getUserById",1);
        assertEquals("777", user.getPhone());
        assertEquals("qqq", user.getEmail());
    }

    @Test
    public void deleteUser_testShouldDeleteUserFromDB() throws Exception {
        sqlSession.delete("deleteUserFromDB",1);
        String username = sqlSession.selectOne("getUsernameById",1);
        assertEquals(null, username);
    }

    @Test
    public void getPasswordByUsername() throws Exception {
        String password = sqlSession.selectOne("getPasswordByUsername","Alexey");
        assertEquals("root",password);
    }

    @Test
    public void getRoleByUsername() throws Exception {
        String role = sqlSession.selectOne("getRoleByUsername","Alexey");
        assertEquals("ROLE_ADMIN",role);
    }

    @Test
    public void getUsernameById() throws Exception {
        String name = sqlSession.selectOne("getUsernameById",1);
        assertEquals("Alexey", name);
    }

}