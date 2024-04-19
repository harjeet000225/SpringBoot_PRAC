package com.harjeet.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaymentServiceImpl implements PaymentService{

	private PaymentDoa dao;
	@Autowired
	public PaymentDoa getDao() {
		return dao;
	}

	public void setDao(PaymentDoa dao) {
		this.dao = dao;
	}
	
	
}
