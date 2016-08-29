package hap.sell.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hap.sell.dto.Customers;

public interface CustomersMapper extends Mapper<Customers>{
	
	/*int deleteByPrimaryKey(Long customerId);

    int insert(Customers customers);

    int insertSelective(Customers customers);*/

    List<Customers> selectByCustomers(Customers customers);

    /*int updateByPrimaryKeySelective(Customers customers);

    int updateByPrimaryKey(Customers customers);*/

}
