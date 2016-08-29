package hap.sell.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hap.sell.dto.InventoryItems;
import hap.sell.service.IInventoryItemsService;

@Controller
public class InventoryItemsController extends BaseController {
	
	@Autowired
    private IInventoryItemsService inventoryItemsService;
	
	@RequestMapping(value = "/sell/inventoryItems/query")
    @ResponseBody
    public ResponseData getTasks(InventoryItems inventoryItems, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(inventoryItemsService.selectByInventoryItems(requestContext, inventoryItems, page, pagesize));
    }

}
