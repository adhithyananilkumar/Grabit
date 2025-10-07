package com.grabit.spring_backend.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> updateRestaurant(Long id, Restaurant updated) {
        return restaurantRepository.findById(id).map(r -> {
            r.setName(updated.getName());
            r.setLocation(updated.getLocation());
            r.setType(updated.getType());
            return restaurantRepository.save(r);
        });
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
