package com.example.restaurant.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.example.restaurant.domain.ReviewCreateUpdateRequest;
import com.example.restaurant.domain.dtos.ReviewCreateUpdateRequestDto;
import com.example.restaurant.domain.dtos.ReviewDto;
import com.example.restaurant.domain.entities.Review;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewMapper {

    ReviewCreateUpdateRequest toReviewCreateUpdateRequest(ReviewCreateUpdateRequestDto dto);
    ReviewDto toReviewDto(Review review);
}
