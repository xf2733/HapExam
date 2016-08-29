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

import hap.sell.dto.OrderLines;
import hap.sell.service.IOrderLinesService;


@Controller
public class OrderLinesController extends BaseController{
	
	@Autowired
    private IOrderLinesService orderLinesService;
	
	@RequestMapping(value = "/sell/orderLines/query")
    @ResponseBody
    public ResponseData getTasks(OrderLines orderLines, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pagesize, HttpServletRequest request) {
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(orderLinesService.selectByOrderLines(requestContext, orderLines, page, pagesize));
    }
	
	@RequestMapping(value = "/sell/orderLines/submit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseData submitOrderLines(@RequestBody List<OrderLines> orderLiness, BindingResult result, HttpServletRequest request)
            throws BaseException {
        getValidator().validate(orderLiness, result);
        if (result.hasErrors()) {
            ResponseData rd = new ResponseData(false);
            rd.setMessage(getErrorMessage(result, request));
            return rd;
        }
        IRequest requestContext = createRequestContext(request);
        return new ResponseData(orderLinesService.batchUpdate(requestContext, orderLiness));
    }

}