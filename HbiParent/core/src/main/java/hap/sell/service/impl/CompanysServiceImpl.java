package hap.sell.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hand.hap.core.IRequest;
import com.hand.hap.system.service.impl.BaseServiceImpl;

import hap.sell.dto.Companys;
import hap.sell.mapper.CompanysMapper;
import hap.sell.service.ICompanysService;

@Service
public class CompanysServiceImpl extends BaseServiceImpl<Companys> implements ICompanysService {
	
	@Autowired
    private CompanysMapper companysMapper;

	@Override
	public List<Companys> selectByCompanys(IRequest requestContext, Companys companys, int page, int pagesize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, pagesize);
		return companysMapper.selectByCompanys(companys);
	}
}
