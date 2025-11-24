package com.example.restaurant.services;

import com.example.restaurant.domain.entities.Address;
import com.example.restaurant.domain.GeoLocation;

public interface GeoLocationService {

    GeoLocation geoLocate(Address address);
}
