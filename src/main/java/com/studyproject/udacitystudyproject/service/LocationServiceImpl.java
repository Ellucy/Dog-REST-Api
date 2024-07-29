package com.studyproject.udacitystudyproject.service;

import com.studyproject.udacitystudyproject.entity.Location;
import com.studyproject.udacitystudyproject.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public List<Location> retrieveLocations() {
        return locationRepository.findAll();
    }
}
