package hap.sell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hap.sell.dto.OrderHeaders;
import hap.sell.dto.OrderLines;
import hap.sell.mapper.OrderHeadersMapper;
import hap.sell.mapper.OrderLinesMapper;
import hap.sell.service.IOrderHeadersService;

@Service
public class OrderHeadersServiceImpl extends BaseServiceImpl<OrderHeaders> implements IOrderHeadersService {
	
	@Autowired
    private OrderHeadersMapper orderHeadersMapper;
	
	@Autowired
    private OrderLinesMapper orderLinesMapper;

	@Override
	public List<OrderHeaders> selectByOrderHeaders(IRequest requestContext, OrderHeaders orderHeaders, int page,
			int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return orderHeadersMapper.selectByOrderHeaders(orderHeaders);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
    public List<OrderHeaders> batchUpdate(IRequest requestContext, List<OrderHeaders> orderHeaderss) {
        // TODO Auto-generated method stub
        for (OrderHeaders orderHeaders : orderHeaderss) {
            if (orderHeaders.get__status() != null) {
                switch (orderHeaders.get__status()) {
                case DTOStatus.ADD:
                	orderHeadersMapper.insertOrderHeaders(orderHeaders);
                    break;
                case DTOStatus.UPDATE:
                	orderHeadersMapper.updateOrderHeaders(orderHeaders);
                    break;
                case DTOStatus.DELETE:
                    //self().deleteByPrimaryKey(fruit);
                	orderHeadersMapper.deleteOrderHeaders(orderHeaders);
                    break;
                default:
                    break;
                }
            }
        }
        return orderHeaderss;
    }


	@Override
	public List<OrderLines> batchUpdateLines(IRequest requestContext, List<OrderLines> orderLiness, Long headerId,Long companyId) {
		for (OrderLines orderLines : orderLiness) {
            if (orderLines.get__status() != null) {
                switch (orderLines.get__status()) {
                case DTOStatus.ADD:
                	orderLines.setCompanyId(companyId);
                	orderLines.setDescription("hehe");
                	orderLines.setOrderQuantityUom("EA");
                	orderLines.setHeaderId(headerId);
                	orderLinesMapper.insertOrderLines(orderLines);
                    break;
                case DTOStatus.UPDATE:
                	//orderHeadersMapper.updateFruit(fruit);
                    break;
                case DTOStatus.DELETE:
                  //  self().deleteByPrimaryKey(orderHeaders);
                    break;
                default:
                    break;
                }
            }
        }
        return orderLiness;
}


}