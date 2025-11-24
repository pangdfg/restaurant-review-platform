package com.example.restaurant.services;

import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import com.example.restaurant.domain.entities.Photo;

public interface PhotoService {

    Photo uploadPhoto(MultipartFile file);

    Optional<Resource> getPhotoAsResource(String id);
}
