package hap.sell.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.exception.BaseException;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;

import hap.sell.dto.OrderHeaders;
import hap.sell.service.IOrderHeadersService;


@Controller
public class OrderHeadersController extends BaseController{
	
	@Autowired
    private IOrderHeadersService orderHeadersService;
	
	@RequestMapping(value = "/sell/orderHeaders/query")
    @ResponseBody
    public ResponseData getTasks(OrderHeaders orderHeaders, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(orderHeadersService.selectByOrderHeaders(requestContext, orderHeaders, page, pagesize));
    }
	
	 @RequestMapping(value = "sell/orderheader/submit", method = RequestMethod.POST)
	    public ResponseData submitFruit(@RequestBody List<OrderHeaders> orderHeaderss, BindingResult result, HttpServletRequest request)
	            throws BaseException {
	        getValidator().validate(orderHeaderss, result);
	        
	        
	        if (result.hasErrors()) {
	        	System.out.println("如果進來了，就是有錯誤吧");
	            ResponseData rd = new ResponseData(false);
	            rd.setMessage(getErrorMessage(result, request));
	            return rd;
	        }
	        IRequest requestContext = createRequestContext(request);
	        return new ResponseData(orderHeadersService.batchUpdate(requestContext, orderHeaderss));
	    }

	
}