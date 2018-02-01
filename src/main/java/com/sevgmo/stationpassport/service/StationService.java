package com.sevgmo.stationpassport.service;

import com.sevgmo.stationpassport.model.Station;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

        private final SqlSession sqlSession;

    public StationService(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Station> getStationById(int id){

        return sqlSession.selectList("getStationById",id);
    }

    public List<Station> getAllStations(){

        return sqlSession.selectList("getAllStations");
    }



}
