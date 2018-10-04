package com.apap.tutorial4.service;

import java.util.List;

import com.apap.tutorial4.model.CarModel;
/*
 * CarService
 */
public interface CarService {
	void addCar(CarModel car);
	List<CarModel> sortByPriceDesc(Long dealer_id);
	void deleteCar(Long id);
	CarModel getCar(long id);
	void updateCar(Long id, String brand, String type, Long price, Integer amount);

}
