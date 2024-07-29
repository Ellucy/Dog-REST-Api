package com.studyproject.udacitystudyproject.service;

import com.studyproject.udacitystudyproject.entity.Dog;
import com.studyproject.udacitystudyproject.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;


    @Override
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    @Override
    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }

    @Override
    public String retrieveDogBreedById(Long id) {
        Optional<String> breedOptional = dogRepository.findBreedById(id);
        return breedOptional.orElse(null);
    }

    @Override
    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllName();
    }

    @Override
    public Optional<Dog> getDogById(Long id) {
        return dogRepository.findById(id);
    }

    @Override
    public void addDog(Dog dog) {
        Dog newDog = new Dog();
        newDog.setName(dog.getName());
        newDog.setBreed(dog.getBreed());
        newDog.setOrigin(dog.getOrigin());

        Dog savedDog = dogRepository.save(newDog);
    }

    @Override
    public void updateDog(Dog dog) {
        Optional<Dog> existingDogOptional = dogRepository.findById(dog.getId());

        if (existingDogOptional.isPresent()) {
            Dog existingDog = existingDogOptional.get();

            existingDog.setName(dog.getName());
            existingDog.setBreed(dog.getBreed());
            existingDog.setOrigin(dog.getOrigin());
            dogRepository.save(existingDog);
        } else {
            throw new DogNotFoundException("Dog with ID " + dog.getId() + " not found.");
        }
    }
}
