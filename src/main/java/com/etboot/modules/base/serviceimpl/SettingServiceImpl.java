package com.etboot.modules.base.serviceimpl;

import com.etboot.modules.base.dao.mapper.SettingMapper;
import com.etboot.modules.base.entity.Setting;
import com.etboot.modules.base.service.SettingService;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 配置接口实现
 *
 * @author 田培融
 */
@Slf4j
@Service
@Transactional
public class SettingServiceImpl extends ServiceImpl<SettingMapper, Setting> implements SettingService {

    @Autowired
    private SettingMapper settingMapper;

    @Override
    public Setting get(String id) {
        Setting setting = settingMapper.selectById(id);
        if (ObjectUtil.isEmpty(setting)) {
            setting = new Setting(id);
        }
        return setting;
    }

    @Override
    public Setting saveOrUpdateSetting(Setting setting) {
        super.saveOrUpdate(setting);
        return setting;
    }
}