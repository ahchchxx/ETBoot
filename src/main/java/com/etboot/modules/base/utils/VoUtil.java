package com.etboot.modules.base.utils;

import com.etboot.modules.base.entity.Permission;
import com.etboot.modules.base.vo.MenuVo;
import cn.hutool.core.bean.BeanUtil;

/**
 * @author Exrick
 */
public class VoUtil {
    public static MenuVo permissionToMenuVo(Permission p) {
        MenuVo menuVo = new MenuVo();
        BeanUtil.copyProperties(p, menuVo);
        return menuVo;
    }
}
