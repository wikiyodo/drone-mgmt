package com.dronemanagementapi.services;

import com.dronemanagementapi.data.request.NewDroneRequest;
import com.dronemanagementapi.data.response.DroneResponse;

import org.springframework.stereotype.Component;

@Component
public interface DroneService {
   DroneResponse register(NewDroneRequest newDroneRequest);
}
