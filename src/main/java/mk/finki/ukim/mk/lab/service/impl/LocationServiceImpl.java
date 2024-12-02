package mk.finki.ukim.mk.lab.service.impl;

import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.exception.LocationNotFoundException;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(Long locationId) {
         return this.locationRepository.findById(locationId)
                .orElseThrow(() -> new LocationNotFoundException("Location with id: " + locationId + " was not found"));
    }
}
