package com.studyproject.udacitystudyproject.repository;

import com.studyproject.udacitystudyproject.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
