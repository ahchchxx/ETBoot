package com.etboot.modules.quartz.dao;

import com.etboot.modules.quartz.entity.QuartzJob;
import com.etboot.modules.base.jpabase.XbootBaseDao;

import java.util.List;

/**
 * 定时任务数据处理层
 * @author Exrick
 */
public interface QuartzJobDao extends XbootBaseDao<QuartzJob, String> {
    /**
     * 通过类名获取
     * @param jobClassName
     * @return
     */
    List<QuartzJob> findByJobClassName(String jobClassName);
}