package com.nearest.location.runner;

import com.nearest.location.domain.request.LocationRequest;
import com.nearest.location.service.GeoLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationRunner implements CommandLineRunner {

    private final GeoLocationService geoLocationService;

    @Override
    public void run(String... args) throws Exception {

        //İçeren Köy Merkez Taksi
        geoLocationService.add(LocationRequest.builder()
                .latitude(40.9635357987984)
                .longitude(29.115110861465435)
                .locationName("İçeren Köy Merkez Taksi").build());

        // Alp Taksi
        geoLocationService.add(LocationRequest.builder()
                .latitude(40.969278607807425)
                .longitude(29.09265249930892)
                .locationName("Alp Taksi").build());

        // 18 Mart Taksi
        geoLocationService.add(LocationRequest.builder()
                .latitude(40.977905060727764)
                .longitude(29.053039078914768)
                .locationName("18 Mart Taksi").build());

    }
}
