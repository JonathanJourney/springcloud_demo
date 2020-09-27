package com.offcn.service;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.offcn.dao.UserDao;
import com.offcn.pojo.Movie;
import com.offcn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RestTemplate restTemplate;

    public User getUserById(Integer id){
        return userDao.getUser(id);
    }

    @HystrixCommand(fallbackMethod = "buyMovieFallbackMethod")
    public Map buyMovie(Integer id){
        Map<String,Object> map=new HashMap<>();
        User user = this.getUserById(id);
        map.put("user",user);
        Movie movie = restTemplate.getForObject("http://PROVIDERMOVIE/movie", Movie.class);
        map.put("movie",movie);
        return map;
    }

    public Map buyMovieFallbackMethod(Integer id){
        Map<String,Object> map=new HashMap<>();
        User user = this.getUserById(id);
        map.put("user",user);
        //Movie movie = restTemplate.getForObject("http://PROVIDERMOVIE/movie", Movie.class);
        Movie movie = new Movie(-1,"服务出错");
        map.put("movie",movie);
        return map;
    }
}
