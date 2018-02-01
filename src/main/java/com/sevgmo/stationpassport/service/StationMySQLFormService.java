package com.sevgmo.stationpassport.service;

import com.sevgmo.stationpassport.model.StationMySQLForm;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationMySQLFormService {

    private SqlSession sqlSession;

    public StationMySQLFormService(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<StationMySQLForm> getStationById(int id){
        return sqlSession.selectList("getStationById", id);
    }
}
