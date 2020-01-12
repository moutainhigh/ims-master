package com.yianju.ims.system.service;

import com.yianju.ims.entity.Result;
import com.yianju.ims.system.model.CoCompany;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 企业管理
 */
@RequestMapping("/company")
public interface CompanyManger {

    /**
     * 保存公司
     * @param company
     * @return
     */
    @RequestMapping("/saveCompany")
    public Result saveCompany(@RequestBody CoCompany company);

    /**
     * 更新公司
     * @param company
     * @return
     */
    @RequestMapping("/updateCompany")
    public Result updateCompany(@RequestBody CoCompany company);

    /**
     * 删除公司
     * @param company
     * @return
     */
    @RequestMapping("/deleteCompany")
    public Result deleteCompany(@RequestBody CoCompany company);

    /**
     * 查找全部企业
     * @param company
     * @return
     */
    @RequestMapping("/findAllCompany")
    public Result findAllCompany(@RequestBody CoCompany company);

    /**
     * 通过ID获取企业信息
     * @param company
     * @return
     */
    @RequestMapping("/findCompanyById")
    public Result findCompanyById(@RequestBody CoCompany company);

}
