package com.sevgmo.stationpassport;

import com.sevgmo.stationpassport.model.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MappedTypes(User.class)
//@MapperScan("com.sevgmo.stationpassport.mapper")
@SpringBootApplication
public class StationPassportApplication {

	public static void main(String[] args) {
		SpringApplication.run(StationPassportApplication.class, args);
	}
}
