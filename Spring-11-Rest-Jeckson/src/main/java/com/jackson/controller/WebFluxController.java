package com.jackson.controller;

import com.jackson.entity.Genre;
import com.jackson.entity.MovieCinema;
import com.jackson.repository.GenreRepository;
import com.jackson.repository.MovieCinemaRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class WebFluxController {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    private MovieCinemaRepository movieCinemaRepository;
    private GenreRepository genreRepository;

    public WebFluxController(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
        this.movieCinemaRepository = movieCinemaRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("/flus-movie-cinemas")
    public Flux<MovieCinema> readAllCinemaFlux() {
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema> readById(@PathVariable("id") long id) {
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

    @GetMapping("/mono-movie-cinema")
    public Mono<MovieCinema> readByIdRequestParam(@RequestParam("id") long id) {
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

    @PostMapping("/create-genre")
    public Mono<Genre> createGenre(@RequestBody Genre genre) {
//        Genre createGenre = genreRepository.save(genre);
//        return Mono.just(createGenre);

        return Mono.just(genreRepository.save(genre));
    }

    @PutMapping("/update-genre")
    public Mono<Genre> updateGenre(@RequestBody Genre genre) {
        Genre updatedGenre = genreRepository.save(genre);
        return Mono.just(updatedGenre);
    }

    @DeleteMapping("delete-genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") long id) {
        genreRepository.deleteById(id);
        return Mono.empty();
    }
}
