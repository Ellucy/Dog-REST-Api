package com.studyproject.udacitystudyproject.service;

import com.studyproject.udacitystudyproject.entity.Dog;

import java.util.List;
import java.util.Optional;

public interface DogService {

    public List<Dog> getAllDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
    public Optional<Dog> getDogById(Long id);
    public void addDog(Dog dog);
    public void updateDog(Dog dog);
}
