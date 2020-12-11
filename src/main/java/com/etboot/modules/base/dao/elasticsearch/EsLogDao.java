package com.etboot.modules.base.dao.elasticsearch;

import com.etboot.modules.base.entity.elasticsearch.EsLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Exrickx
 */
public interface EsLogDao {// extends ElasticsearchRepository<EsLog, String> {
    /**
     * 通过类型获取
     * @param type
     * @param pageable
     * @return
     */
    Page<EsLog> findByLogType(Integer type, Pageable pageable);
}
