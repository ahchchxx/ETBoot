package com.etboot.modules.quartz.service;

import com.etboot.modules.quartz.entity.QuartzJob;
import com.etboot.modules.base.jpabase.XbootBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 定时任务接口
 * @author Exrick
 */
public interface QuartzJobService extends XbootBaseService<QuartzJob, String> {
    /**
     * 通过类名获取
     * @param jobClassName
     * @return
     */
    List<QuartzJob> findByJobClassName(String jobClassName);

    /**
     * 分页获取
     * @param key
     * @param pageable
     * @return
     */
    Page<QuartzJob> findByCondition(String key, Pageable pageable);
}