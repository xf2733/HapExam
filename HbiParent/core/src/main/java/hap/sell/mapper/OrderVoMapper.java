package hap.sell.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hap.sell.dto.OrderVo;



public interface OrderVoMapper extends Mapper<OrderVo>{
	List<OrderVo> selectByOrderVo(OrderVo orderVo);
    

}
