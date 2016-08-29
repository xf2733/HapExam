package hap.sell.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hap.sell.dto.InventoryItems;

public interface InventoryItemsMapper extends Mapper<InventoryItems> {
	
	/*int deleteByPrimaryKey(Long inventoryItemId);

    int insert(InventoryItems inventoryItems);

    int insertSelective(InventoryItems inventoryItems);*/

    List<InventoryItems> selectByInventoryItems(InventoryItems inventoryItems);

    /*int updateByPrimaryKeySelective(InventoryItems inventoryItems);

    int updateByPrimaryKey(InventoryItems inventoryItems);*/

}
