package com.jackson.controller;

import com.jackson.entity.Genre;
import com.jackson.entity.MovieCinema;
import com.jackson.repository.GenreRepository;
import com.jackson.repository.MovieCinemaRepository;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

    @GetMapping("/flux-movie-cinemas")
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

    @DeleteMapping("/delete-genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") long id) {
        genreRepository.deleteById(id);
        return Mono.empty();
    }

    //---------------------------------- WEBCLIENT EXAMPLES ----------------------------

    @GetMapping("/flux")
    public Flux<MovieCinema> readWithWebClient() {
        return webClient.get()
                .uri("/flux-movie-cinemas")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve().bodyToFlux(MovieCinema.class);
    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id) {
        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}", id)
                .retrieve()
                .bodyToMono(MovieCinema.class);
    }

    @GetMapping("/mono-rp")
    public Mono<MovieCinema> readMonoWithWebClientRequestParam(@RequestParam("id") Long id) {
        return webClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path("/mono-movie-cinema")
                                .queryParam("id", id)
                                .build())
                .retrieve().bodyToMono(MovieCinema.class);
    }

    @PostMapping("/create")
    public Mono<Genre> createWebClient(@RequestBody Genre genre) {
        return webClient.post()
                .uri("/create-genre")
                .body(Mono.just(genre), Genre.class)
                .retrieve()
                .bodyToMono(Genre.class);
    }

//    @DeleteMapping("/delete/{id}")
//    public Mono<Void> deleteWebClient(@PathVariable("id") Long id) {
//        return webClient.delete()
//                .uri("/delete-genre/{id}", id)
//                .retrieve()
//                .bodyToMono(Void.class);
//    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteWebClient(@PathVariable("id") Long id) throws Exception {
        Integer countGenres = genreRepository.countGenresNativeQuery(id);
        if (countGenres > 0) {
            throw new Exception("Genre can't be deleted, is linked by a movie");
        }

        return webClient.delete()
                .uri("/delete-genre/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}
