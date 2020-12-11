package com.etboot.modules.open.service;

import com.etboot.modules.open.entity.Client;
import com.etboot.modules.base.jpabase.XbootBaseService;
import com.etboot.common.vo.SearchVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 客户端接口
 * @author Exrick
 */
public interface ClientService extends XbootBaseService<Client, String> {
    /**
     * 多条件分页获取
     * @param client
     * @param searchVo
     * @param pageable
     * @return
     */
    Page<Client> findByCondition(Client client, SearchVo searchVo, Pageable pageable);

}