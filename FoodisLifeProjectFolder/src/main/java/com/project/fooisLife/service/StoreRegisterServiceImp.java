package com.project.fooisLife.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooisLife.entity.Branch;
import com.project.fooisLife.entity.BranchAdmin;
import com.project.fooisLife.repository.StoreRegisterRepository;

@Service
public class StoreRegisterServiceImp implements StoreRegisterService{
	@Autowired
	private StoreRegisterRepository storeRegisterRepository; 
	@Override
	public void registerStoreService(Branch branch, BranchAdmin admin) {
		storeRegisterRepository.registerStoreInfo(branch.getId(), branch.getRestaurantName(), branch.getAddress(),
				branch.getCity(), branch.getEmail(), branch.getOpenHours(), branch.getPhone(), branch.getState(),
				admin.getUsername(), admin.getPassword(), admin.getEmail(), admin.getPhone());
	}

}
