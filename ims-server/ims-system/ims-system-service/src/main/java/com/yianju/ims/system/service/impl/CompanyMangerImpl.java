package com.yianju.ims.system.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yianju.ims.entity.Result;
import com.yianju.ims.entity.ResultCode;
import com.yianju.ims.service.impl.BaseManagerImpl;
import com.yianju.ims.system.mapper.CompanyMapper;
import com.yianju.ims.system.model.CoCompany;
import com.yianju.ims.system.service.CompanyManger;
import com.yianju.ims.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 企业服务
 */
@RestController
public class CompanyMangerImpl extends BaseManagerImpl<CoCompany> implements CompanyManger {

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private BaseMapper<CoCompany> mapper;

    @Override
    public Result saveCompany(CoCompany company) {

        CoCompany byName = new CoCompany();
        byName.setCompanyName(company.getCompanyName());
        // 企业名称不能重复
        List<CoCompany> byNameList = this.queryListByWhere(byName);

        long l = new IdGenerator().nextId();
        company.setCompanyId(l+"");
        mapper.insert(company);
        return new Result(ResultCode.SUCCESS);
    }

    @Override
    public Result updateCompany(CoCompany company) {
        return null;
    }

    @Override
    public Result deleteCompany(CoCompany company) {
        return null;
    }

    @Override
    public Result findAllCompany(CoCompany company) {
        return null;
    }

    @Override
    public Result findCompanyById(CoCompany company) {
        return null;
    }
}
