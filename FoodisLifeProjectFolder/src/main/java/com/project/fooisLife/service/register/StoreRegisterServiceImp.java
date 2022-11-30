package com.project.fooisLife.service.register;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fooisLife.entity.Branch;
import com.project.fooisLife.entity.Admin;
import com.project.fooisLife.repository.register.StoreRegisterRepository;

@Service
public class StoreRegisterServiceImp implements StoreRegisterService{
	@Autowired
	private StoreRegisterRepository storeRegisterRepository; 
	@Override
	public boolean registerStoreService(Branch branch, Admin admin) {
		try {
			return storeRegisterRepository.registerStoreInfo(branch.getBid(), branch.getName(), branch.getAddress(),
					branch.getCity(), branch.getEmail(), branch.getOpenHours(), branch.getPhone(), branch.getState(),
					admin.getUsername(), admin.getPassword(), admin.getEmail(), admin.getPhone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
