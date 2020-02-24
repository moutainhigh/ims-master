package com.yianju.ims.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yianju.ims.entity.PageResult;
import com.yianju.ims.model.BaseModel;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class BaseManagerImpl<T extends BaseModel> {

    /**
     * 获取公共请求的request、response
     */
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected String companyId;
    protected String companyName;
    protected Claims claims;
    protected Long userId;

    @Autowired
    private BaseMapper<T> mapper;

    /**
     * 根据id查询数据
     *
     * @param id
     * @return
     */
    public T queryById(Long id) {
        return this.mapper.selectById(id);
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    public List<T> queryAll() {
        return this.mapper.selectList(null);
    }

    /**
     * 根据条件查询一条数据
     *
     * @param record
     * @return
     */
    public T queryOne(T record) {
        return this.mapper.selectOne(new QueryWrapper<>(record));
    }

    /**
     * 根据条件查询数据列表
     *
     * @param record
     * @return
     */
    public List<T> queryListByWhere(T record) {
        return this.mapper.selectList(new QueryWrapper<>(record));
    }

    /**
     * 根据条件分页查询数据列表
     *
     * @param record
     * @param page
     * @param rows
     * @return
     */
    public IPage<T> queryPageListByWhere(T record, Integer page, Integer rows) {
        // 获取分页数据
        return this.mapper.selectPage(new Page<T>(page, rows), new QueryWrapper<>
                (record));
    }

    /**
     * 保存数据
     *
     * @param record
     * @return
     */
    public Integer save(T record) {
        record.setCreateTime(new Date());
        record.setModifyTime(record.getModifyTime());
        record.setRecStatus(0);
        record.setCreator(userId);
        record.setModifier(userId);
        record.setCompanyId(companyId);
        record.setCompanyName(companyName);
        return this.mapper.insert(record);
    }

    public Integer saveWithOutCompany(T record) {
        record.setCreateTime(new Date());
        record.setModifyTime(record.getModifyTime());
        record.setRecStatus(0);
        record.setCreator(userId);
        record.setModifier(userId);
        return this.mapper.insert(record);
    }

    /**
     * 更新数据
     *
     * @param record
     * @return
     */
    public Integer update(T record) {
        record.setModifyTime(new Date());
        return this.mapper.updateById(record);
    }

    /**
     * 根据id删除数据
     *
     * @param id
     * @return
     */
    public Integer deleteById(Long id) {
        return this.mapper.deleteById(id);
    }

    /**
     * 根据ids批量删除数据
     *
     * @param ids
     * @return
     */
    public Integer deleteByIds(List<Long> ids) {
        return this.mapper.deleteBatchIds(ids);
    }

    /**
     * 根据条件删除数据
     *
     * @param record
     * @return
     */
    public Integer deleteByWhere(T record) {
        return this.mapper.delete(new QueryWrapper<T>(record));
    }

    /**
     * 根据条件分页查询数据列表
     * @param queryWrapper
     * @param page
     * @param rows
     * @return
     */
    public IPage<T> queryPageList(QueryWrapper<T> queryWrapper, Integer page, Integer rows) {
        // 获取分页数据
        return this.mapper.selectPage(new Page<T>(page, rows), queryWrapper);
    }


    @ModelAttribute
    public void setReqAndResp(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        Object userClaims = request.getAttribute("user_claims");

        if(userClaims!=null){
            this.claims = (Claims) userClaims;
            this.companyId = (String)claims.get("companyId");
            this.companyName = (String)claims.get("companyName");
            this.userId = Long.parseLong((String)claims.get("userId"));
        }
    }


    /**
     * 获取分业信息
     * @param page
     * @return
     */
    public PageResult createPageResult(IPage page){
        PageResult result = new PageResult();
        result.setData(page.getRecords());
        result.setCurrent(page.getCurrent());
        result.setPageSize(page.getSize());
        result.setTotal(page.getTotal());
        result.setCode(10000);
        result.setSuccess(true);
        result.setMessage("请求成功");
        return result;
    }

}
