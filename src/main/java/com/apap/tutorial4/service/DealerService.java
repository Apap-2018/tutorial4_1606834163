package com.apap.tutorial4.service;

import java.util.Optional;
import java.util.List;
import com.apap.tutorial4.model.DealerModel;
/*
 * DealerService
 */
public interface DealerService {
	Optional<DealerModel> getDealerDetailById(Long id);
	
	void addDealer(DealerModel dealer);
	void deleteDealer(Long id);
	void updateDealer(Long id, String alamat, String noTelp);
	List<DealerModel> viewAllDealer();


}
