package hap.sell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hap.sell.dto.InventoryItems;
import hap.sell.mapper.InventoryItemsMapper;
import hap.sell.service.IInventoryItemsService;

@Service
public class InventoryItemsServiceImpl extends BaseServiceImpl<InventoryItems> implements IInventoryItemsService{
	
	@Autowired
    private InventoryItemsMapper inventoryItemsMapper;

	@Override
	public List<InventoryItems> selectByInventoryItems(IRequest requestContext, InventoryItems inventoryItems, int page,
			int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return inventoryItemsMapper.selectByInventoryItems(inventoryItems);
	}

}
