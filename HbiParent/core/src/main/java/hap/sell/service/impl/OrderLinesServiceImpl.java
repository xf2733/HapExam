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

import hap.sell.dto.OrderLines;
import hap.sell.mapper.OrderLinesMapper;
import hap.sell.service.IOrderLinesService;


@Service
public class OrderLinesServiceImpl extends BaseServiceImpl<OrderLines> implements IOrderLinesService{
	
	@Autowired
    private OrderLinesMapper orderLinesMapper;

	@Override
	public List<OrderLines> selectByOrderLines(IRequest requestContext, OrderLines orderLines, int page, int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return orderLinesMapper.selectByOrderLines(orderLines);
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
    public List<OrderLines> batchUpdate(IRequest requestContext, List<OrderLines> orderLiness) {
        // TODO Auto-generated method stub
        for (OrderLines orderLines : orderLiness) {
            if (orderLines.get__status() != null) {
                switch (orderLines.get__status()) {
                case DTOStatus.ADD:
                	orderLinesMapper.insertOrderLines(orderLines);
                    break;
                case DTOStatus.UPDATE:
                	orderLinesMapper.updateOrderLines(orderLines);
                    break;
                case DTOStatus.DELETE:
                    //self().deleteByPrimaryKey(fruit);
                	orderLinesMapper.deleteOrderLines(orderLines);
                    break;
                default:
                    break;
                }
            }
        }
        return orderLiness;
    }
}