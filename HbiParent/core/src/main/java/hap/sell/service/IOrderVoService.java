package hap.sell.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hap.sell.dto.OrderVo;



public interface IOrderVoService extends IBaseService<OrderVo>,ProxySelf<OrderVo>{
	
	List<OrderVo> selectByOrderVo(IRequest requestContext, OrderVo orderVo, int page, int pagesize);

}
