package hap.sell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hap.sell.dto.Customers;
import hap.sell.mapper.CustomersMapper;
import hap.sell.service.ICustomersService;

@Service
public class CustomersServiceImpl extends BaseServiceImpl<Customers> implements ICustomersService{
	
	@Autowired
    private CustomersMapper customersMapper;

	@Override
	public List<Customers> selectByCustomers(IRequest requestContext, Customers customers, int page, int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return customersMapper.selectByCustomers(customers);
	}

}
