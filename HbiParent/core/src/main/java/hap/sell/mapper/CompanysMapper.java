package hap.sell.mapper;

import java.util.List;

import com.hand.hap.mybatis.common.Mapper;

import hap.sell.dto.Companys;

public interface CompanysMapper extends Mapper<Companys> {
	
	/*int deleteByPrimaryKey(Long companyId);

    int insert(Companys companys);

    int insertSelective(Companys companys);*/
    
    List<Companys> selectByCompanys(Companys companys);

   /* int updateByPrimaryKeySelective(Companys companys);

    int updateByPrimaryKey(Companys companys);*/

}
