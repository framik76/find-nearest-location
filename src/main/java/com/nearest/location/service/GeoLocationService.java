package com.nearest.location.service;

import java.util.ArrayList;
import java.util.List;

import com.nearest.location.domain.request.LocationRequest;
import com.nearest.location.domain.response.LocationResponse;
import com.nearest.location.util.LoadCSV;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.domain.geo.GeoReference;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GeoLocationService {

    private final GeoOperations<String, String> geoOperations;
    private final StringRedisTemplate redisTemplate;
    public static final String location = "location_asset";

    public void add(LocationRequest request) {
        Point point = new Point(request.getLongitude(), request.getLatitude());
        geoOperations.add(location, point, request.getLocationName());
    }

    public int addFromCsv() {
        LoadCSV loadCSV = new LoadCSV();
        var records = loadCSV.load();
        int count = 0;
        for (var i = 1; i < records.size(); i++) {
            try {
                var rec = records.get(i);
                var longitude = rec.get(10).replaceAll("\"", "");
                var latitude = rec.get(9).replaceAll("\"", "");
                Point point = new Point(Double.parseDouble(longitude), Double.parseDouble(latitude));
                var locationName = rec.get(6).replaceAll("\"", "");
                var address = rec.get(7).replaceAll("\"", "");
                if (address.length() > 3) {
                    locationName = locationName + " - " + address;
                }
                geoOperations.add(location, point, locationName);
                count++;
            } catch (Exception e) {
                System.out.println("Error on line " + i + ": " + e.getMessage());
            }
        }
        return count;
    }

    public List<LocationResponse> findNearestLocations(Double longitude, Double latitude, int km) {

        //RedisGeoCommands.GeoRadiusCommandArgs args = RedisGeoCommands.GeoRadiusCommandArgs.newGeoRadiusArgs().includeCoordinates()
        //        .includeDistance().sortAscending().limit(10);

        Circle circle = new Circle(new Point(longitude, latitude), new Distance(km, Metrics.KILOMETERS));
        var distance = new Distance(km, Metrics.KILOMETERS);
        //GeoResults<RedisGeoCommands.GeoLocation<String>> response = geoOperations.radius(location, circle);
        GeoResults<RedisGeoCommands.GeoLocation<String>> response = geoOperations.search(location, GeoReference.fromCircle(circle), distance);

        List<LocationResponse> locationResponses = new ArrayList<>();
        response.getContent().stream().forEach(data -> {
            geoOperations.position(location, data.getContent().getName()).stream().findFirst().ifPresent(position -> {
                locationResponses.add(LocationResponse.builder()
                        .locationName(data.getContent().getName())
                        .averageDistance(data.getDistance().toString())
                        .point(position)
                        .build());
            });
        });

        return locationResponses;
    }

}
