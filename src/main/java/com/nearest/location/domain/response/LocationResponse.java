package com.nearest.location.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.geo.Point;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LocationResponse {

    private String locationName;
    private String averageDistance;
    private Point point;
}
