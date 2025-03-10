package com.nearest.location.controller;

import com.nearest.location.domain.request.LocationRequest;
import com.nearest.location.domain.response.LocationResponse;
import com.nearest.location.service.GeoLocationService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/api/locations")
@CrossOrigin(origins = "*")
@RestController
public class LocationController {

    @Autowired
    private final GeoLocationService geoLocationService;

    @PostMapping
    public ResponseEntity<Void> setLocation(@RequestBody LocationRequest request) {
        geoLocationService.add(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/loadFromCsv")
    public ResponseEntity<Integer> addLocations() {
        var items = geoLocationService.addFromCsv();
        return new ResponseEntity<Integer>(items, HttpStatus.OK);
    }

    @GetMapping("/nearest")
    public ResponseEntity<List<LocationResponse>> getNearestLocations(
                                                                   @RequestParam("latitude") double latitude,
                                                                   @RequestParam("longitude") double longitude,
                                                                   @RequestParam("km") int km) {

        List<LocationResponse> locations = geoLocationService.findNearestLocations(longitude, latitude, km);
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

}
