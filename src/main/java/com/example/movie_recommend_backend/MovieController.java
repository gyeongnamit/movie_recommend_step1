package com.example.movie_recommend_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // RESTful 컨트롤러를 나타내는 어노테이션

public class MovieController {
    // 의존성 주입 
    @Autowired
    private MovieRepository movieRepository;

     // 최신 영화 10개 조회 (개봉일 기준 내림차순)
    @GetMapping("/movie/movie_latest")
    public List<Movie> getLatestMovies() {
        return movieRepository.findAllByOrderByOpenDateDesc().stream().limit(10).toList();
    }

    // 가장 인기 있는 영화 10개 조회 (관람객 수 기준 내림차순)
    @GetMapping("/movie/movie_popular")
    public List<Movie> getPopularMovies() {
        return movieRepository.findAllByOrderByBoxOfficeDesc().stream().limit(10).toList();
    }
}