package com.sevgmo.stationpassport;

import com.sevgmo.stationpassport.mapper.UserMapper;
import com.sevgmo.stationpassport.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@SqlGroup({
		@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeUsersTableTest.sql"),
		@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterUsersTableTest.sql")
})
public class StationPassportApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Test
	public void testUserMapper_AddNewUser_testShouldAddNewUserToDB(){
		User user = new User("test","pass","test@test.test","777","ROLE_USER");
		userMapper.add(user);
		String username = userMapper.getUsernameById(3);
		assertEquals("test", username);
	}

	@Test
	public void testUserMapper_UpdateUser_testShouldUpdateUserInDB(){
		User user = new User();
		user.setId(1);
		user.setPhone("777");
		user.setEmail("qqq");
		userMapper.update(user);
		assertEquals("777", userMapper.getUserById(1).getPhone());
		assertEquals("qqq", userMapper.getUserById(1).getEmail());
	}

	@Test
	public void testUserMapper_GetUserById_testShouldReturnUserByIdFromDB(){
		assertEquals("Alexey", userMapper.getUserById(1).getUsername());
	}

	@Test
	public void testUserMapper_DeleteUser_testShouldDeleteUserFromDB(){

		userMapper.delete(2);
		assertEquals(null, userMapper.getUsernameById(2));
	}

}
