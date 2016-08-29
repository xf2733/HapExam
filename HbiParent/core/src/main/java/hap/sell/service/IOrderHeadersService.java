package hap.sell.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.core.annotation.StdWho;
import com.hand.hap.system.service.IBaseService;

import hap.sell.dto.OrderHeaders;
import hap.sell.dto.OrderLines;

public interface IOrderHeadersService extends IBaseService<OrderHeaders>, ProxySelf<IOrderHeadersService>{
	
	List<OrderHeaders> selectByOrderHeaders(IRequest requestContext, OrderHeaders orderHeaders, int page, int pagesize);

	List<OrderHeaders> batchUpdate(IRequest requestContext, @StdWho List<OrderHeaders> orderHeaderss);

	List<OrderLines> batchUpdateLines(IRequest requestContext, @StdWho List<OrderLines> orderLiness,Long headerId,Long companyId);

}
