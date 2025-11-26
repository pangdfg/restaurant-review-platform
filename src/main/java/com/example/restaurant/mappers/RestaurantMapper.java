package com.example.restaurant.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.Mapping;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import com.example.restaurant.domain.RestaurantCreateUpdateRequest;
import com.example.restaurant.domain.dtos.GeoPointDto;
import com.example.restaurant.domain.dtos.RestaurantCreateUpdateRequestDto;
import com.example.restaurant.domain.dtos.RestaurantDto;
import com.example.restaurant.domain.dtos.RestaurantSummaryDto;
import com.example.restaurant.domain.entities.Restaurant;
import com.example.restaurant.domain.entities.Review;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {

    RestaurantCreateUpdateRequest toRestaurantCreateUpdateRequest(RestaurantCreateUpdateRequestDto dto);

    @Mapping(source = "reviews", target = "totalReviews", qualifiedByName = "populateTotalReviews")
    RestaurantDto toRestaurantDto(Restaurant restaurant);

    @Mapping(source = "reviews", target = "totalReviews", qualifiedByName = "populateTotalReviews")
    RestaurantSummaryDto toSummaryDto(Restaurant restaurant);

    @Named("populateTotalReviews")
    default Integer populateTotalReviews(List<Review> reviews) {
        return reviews.size();
    }

    @Mapping(target = "latitude", expression = "java(geoPoint.getLat())")
    @Mapping(target = "longitude", expression = "java(geoPoint.getLon())")
    GeoPointDto toGeoPointDto(GeoPoint geoPoint);
}
