package com.example.demo.service;

import com.example.demo.dto.MovieDTO;
import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MoiveService {
    private final M정보ovieRepository movieRepository;

    // 저장
    public MovieDTO save(MovieDTO dto) {
        Movie movie = dto.toEntity();
        Movie m = movieRepository.save(movie);
        MovieDTO movieDTO = new MovieDTO(m);;
        return movieDTO;
    }

    // 영화번호로 조회
    public MovieDTO selectMnum(Long mnum) {
       Optional<Movie> movie = movieRepository.findById(mnum);
       if(movie.isPresent()) {
           Movie m = movie.get();
           return new MovieDTO(m);
       }
       return null;
    }

    // 전체 조회(pageing없이)
    public List<MovieDTO> selectAll() {
        List<Movie> movieList = movieRepository.findAll();
        List<MovieDTO> dtoList = movieList.stream().map(MovieDTO::new).toList();
        return dtoList;
    }

}
