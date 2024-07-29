package com.studyproject.udacitystudyproject.web;

import com.studyproject.udacitystudyproject.entity.Dog;
import com.studyproject.udacitystudyproject.service.DogServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dogs")
public class DogController {

    private final DogServiceImpl dogService;

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = dogService.getAllDogs();
        return ResponseEntity.ok(dogs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id) {
        Optional<Dog> dogOptional = dogService.getDogById(id);
        return dogOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/breed")
    public ResponseEntity<List<String>> getDogBreeds() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getBreedByID(@PathVariable Long id) {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> addDog(@RequestBody Dog dog) {
        dogService.addDog(dog);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateDog(@PathVariable Long id, @RequestBody Dog dog) {
        dog.setId(id);
        dogService.updateDog(dog);
        return ResponseEntity.ok().build();
    }
}
