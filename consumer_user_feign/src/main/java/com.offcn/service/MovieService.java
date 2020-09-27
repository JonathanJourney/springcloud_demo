package com.offcn.service;

import com.offcn.dao.UserDao;
import com.offcn.pojo.Movie;
import com.offcn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@FeignClient(value = "PROVIDERMOVIE")
public interface MovieService {

    @GetMapping("movie")
    public Movie getOne();
}
