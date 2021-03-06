package com.offcn.service;

import com.offcn.dao.MovieDao;
import com.offcn.pojo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Value("${server.port}")
    private String port;

    @Autowired
    private MovieDao movieDao;

    public Movie getOne(){
        System.out.println("当前调用的提供者的端口是:"+port);
        return movieDao.getOne();
    }
}
