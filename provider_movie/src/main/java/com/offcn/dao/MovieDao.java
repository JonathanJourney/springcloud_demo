package com.offcn.dao;

import com.offcn.pojo.Movie;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao {

    public Movie getOne(){
        Movie movie = new Movie(2001, "八佰");
        return movie;
    }
}
