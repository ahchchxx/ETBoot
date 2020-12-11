package com.etboot.modules.base.mpbase.controller;

import com.etboot.common.utils.ResultUtil;
import com.etboot.common.vo.Result;
import com.etboot.modules.base.mpbase.BaseService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.List;

public abstract class BaseController<E, ID extends Serializable> {
    // @Autowired
    // BaseService<E, ID> baseService;
    public abstract BaseService<E, ID> getService();


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "保存数据")
    public Result<E> save(E entity) {
        int i = getService().save(entity);
        if (i > 0) {
            return ResultUtil.success("" + i);
        }
        return ResultUtil.error("" + i);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新数据")
    public Result<E> update(E entity) {
        int i = getService().update(entity);
        if (i > 0) {
            return ResultUtil.success("" + i);
        }
        return ResultUtil.error("" + i);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "通过id获取")
    public Result<E> del(@PathVariable ID id) {
        int i = getService().delete(id);
        if (i > 0) {
            return ResultUtil.success("" + i);
        }
        return ResultUtil.error("" + i);
    }

    @RequestMapping(value = "/delAllByIds", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "批量通过id删除")
    public Result<Object> delByIds(ID[] ids) {
        int i = 0;
        for (ID id : ids) {
            i += getService().delete(id);
        }
        if (i > 0) {
            return ResultUtil.success("" + i);
        }
        return ResultUtil.error("" + i);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "通过id获取")
    public Result<E> get(@PathVariable ID id) {
        E entity = getService().get(id);
        return new ResultUtil<E>().setData(entity);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取全部数据")
    public Result<List<E>> getAll() {
        List<E> list = getService().getAll();
        return new ResultUtil<List<E>>().setData(list);
    }

    @RequestMapping(value = "/getByPage", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "分页获取")
    public Result<Page<E>> getByPage(Page<E> page) {
        Page<E> data = getService().findAll(page);
        return new ResultUtil<Page<E>>().setData(data);
    }
}
