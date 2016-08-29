package hap.sell.service;

import java.util.List;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;

import hap.sell.dto.Companys;

public interface ICompanysService extends IBaseService<Companys>, ProxySelf<ICompanysService>{
	
    List<Companys> selectByCompanys(IRequest requestContext, Companys companys, int page, int pagesize);


}
