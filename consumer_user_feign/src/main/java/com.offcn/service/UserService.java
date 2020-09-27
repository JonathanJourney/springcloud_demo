package com.offcn.service;

import com.offcn.dao.UserDao;
import com.offcn.pojo.Movie;
import com.offcn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private MovieService movieService;


    public User getUserById(Integer id){
        return userDao.getUser(id);
    }

    public Map buyMovie(Integer id){
        Map<String,Object> map=new HashMap<>();
        User user = this.getUserById(id);
        map.put("user",user);
        Movie movie = movieService.getOne();
        map.put("movie",movie);
        return map;
    }
}
