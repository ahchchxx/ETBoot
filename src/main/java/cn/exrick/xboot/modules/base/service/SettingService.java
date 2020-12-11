package cn.exrick.xboot.modules.base.service;

import cn.exrick.xboot.modules.base.entity.Setting;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;


/**
 * 配置接口
 * @author
 */
@CacheConfig(cacheNames = "setting")
public interface SettingService extends IService<Setting> {

    /**
     * 通过id获取
     * @param id
     * @return
     */
    @Cacheable(key = "#id")
    Setting get(String id);

    /**
     * 修改
     * @param setting
     * @return
     */
    @CacheEvict(key = "#setting.id")
    Setting saveOrUpdateSetting(Setting setting);
}