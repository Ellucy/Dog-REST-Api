package com.studyproject.udacitystudyproject.repository;

import com.studyproject.udacitystudyproject.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
}
