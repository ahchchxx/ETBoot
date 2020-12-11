package cn.exrick.xboot.modules.web.controller;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cn.exrick.xboot.common.utils.PageUtil;
import cn.exrick.xboot.common.utils.ResultUtil;
import cn.exrick.xboot.common.vo.PageVo;
import cn.exrick.xboot.common.vo.Result;
import cn.exrick.xboot.modules.base.mpbase.controller.BaseController;
import cn.exrick.xboot.modules.base.mpbase.BaseService;
import cn.exrick.xboot.modules.web.entity.LogInfo;
import cn.exrick.xboot.modules.web.service.LogService1;

import java.util.Date;

@RestController
@RequestMapping("/xboot/log")
public class LogController1 extends BaseController<LogInfo, String> {
    @Autowired
    LogService1 service;
    @Override
    public BaseService<LogInfo, String> getService() {
        return service;
    }

    // get list by query and page
    @RequestMapping(value = "/getByConditionPage", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "分页获取")
    public Result<Page<LogInfo>> getByQuery(PageVo page, LogInfo bean) {
        QueryWrapper<LogInfo> qw = new QueryWrapper<>();
        if (!StringUtils.isEmpty(bean.getName())) {
            qw.like("name", bean.getName());
        }
        if (!StringUtils.isEmpty(bean.getIp())) {
            qw.like("ip", bean.getIp());
        }
        if (bean.getCostTime() != null) {
            qw.eq("cost_time", bean.getCostTime());
        }

        // daterange 测试
        // if (!StringUtils.isEmpty(request.getParameter("createTime_0"))) {
        // 	if (!StringUtils.isEmpty(request.getParameter("createTime_1"))) {
        // 		qw.between("create_time", request.getParameter("createTime_0"), request.getParameter("createTime_1"));
        // 	} else {
        // 		qw.eq("create_time", request.getParameter("createTime_0"));
        // 	}
        // }
        // if (!StringUtils.isEmpty(request.getParameter("createTime_01"))) {
        //     String[] dateRange = request.getParameter("createTime_01").split(",");
        //     if (dateRange.length > 1) {
        //         Date end = DateUtil.parse(dateRange[1]);
        //         qw.between("create_time", dateRange[0], DateUtil.endOfDay(end));
        //     } else {
        //         // qw.eq("create_time", dateRange[0]); // 这个找不到
        //         // qw.likeLeft("create_time", dateRange[0]);
        //         Date end = DateUtil.parse(dateRange[0]);
        //         qw.between("create_time", dateRange[0], end);
        //     }
        // }

        Page<LogInfo> data = service.findAll(PageUtil.initMpPage(page), qw);
        return new ResultUtil<Page<LogInfo>>().setData(data);
    }

}

