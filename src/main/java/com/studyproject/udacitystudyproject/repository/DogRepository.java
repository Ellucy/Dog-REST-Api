package com.studyproject.udacitystudyproject.repository;

import com.studyproject.udacitystudyproject.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    @Query("SELECT d.breed FROM Dog d WHERE d.id = :id")
    Optional<String> findBreedById(@Param("id") Long id);

    @Query(value = "SELECT DISTINCT breed FROM dog", nativeQuery = true)
    List<String> findAllBreed();

    @Query("SELECT d.name FROM Dog d")
    List<String> findAllName();
}
