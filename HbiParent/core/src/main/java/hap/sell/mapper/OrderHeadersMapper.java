package hap.sell.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hap.sell.dto.OrderHeaders;

public interface OrderHeadersMapper extends Mapper<OrderHeaders>{

    List<OrderHeaders> selectByOrderHeaders(OrderHeaders orderHeaders);

    int insertOrderHeaders(OrderHeaders orderHeaders);
    
    int updateOrderHeaders(OrderHeaders orderHeaders);
    
    int deleteOrderHeaders(OrderHeaders orderHeaders);
	
}