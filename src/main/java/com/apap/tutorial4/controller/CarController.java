package com.apap.tutorial4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial4.model.CarModel;
import com.apap.tutorial4.model.DealerModel;
import com.apap.tutorial4.service.CarService;
import com.apap.tutorial4.service.DealerService;

/*
 * CarController
 */
@Controller
public class CarController {
	@Autowired
	private CarService carService;
	
	@Autowired
	private DealerService dealerService;
	
	@RequestMapping(value = "/car/add{dealerId}", method = RequestMethod.GET)
	private String add(@PathVariable(value = "dealerId") Long dealerId, Model model) {
		CarModel car = new CarModel();
		DealerModel dealer = dealerService.getDealerDetailById(dealerId).get();
		car.setDealer(dealer);
		
		model.addAttribute("car", car);
		return "addCar";
	}
	
	@RequestMapping(value = "/car/add", method = RequestMethod.POST)
	private String addCarSubmit(@ModelAttribute CarModel car) {
		carService.addCar(car);
		return "add";
	}
	
	@RequestMapping(value = "/car/delete", method = RequestMethod.GET)
	private String deleteCarById(@RequestParam("id") Long id, Model model) {	
		//if(carService.getCar(id) != null) {
			carService.deleteCar(id);
			return "delete";
		//}
		//return "error";
		
	}
	
	@RequestMapping(value = "/car/update", method = RequestMethod.GET)
	private String updateCarById(@RequestParam("id") Long id, Model model, @RequestParam("brand") String brand, @RequestParam("type") String type, 
			@RequestParam("price") Long price, @RequestParam("amount") Integer amount) {
		//if(carService.getCar(id) != null) {
			carService.updateCar(id, brand, type, price, amount);
			return "update";
		//}
		//return "error";
		
	}

}
