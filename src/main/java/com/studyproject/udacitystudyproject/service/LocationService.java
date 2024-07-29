package com.studyproject.udacitystudyproject.service;

import com.studyproject.udacitystudyproject.entity.Location;
import com.studyproject.udacitystudyproject.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LocationService {

    public List<Location> retrieveLocations();
}
