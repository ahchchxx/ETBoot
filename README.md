## ETBoot

### Spring-boot Project Sample

Keeping learning and improving. 

> Github: https://github.com/ahchchxx/ETBoot
>
> Gitee:  https://gitee.com/ahchchxx/ETBoot

> It is a forked project from XBoot.

### 功能增强
#### 一、资源权限方面

##### 1、管理员角色功能增强
- ADMIN角色用户默认访问任意资源，无需配置
- 对其余角色而言，都需要先配置permission资源，再给角色绑上资源权限
- 增加 2个系统必须使用的资源，首次登录时使用
    1. /xboot/permission/getMenuList*
    2. /xboot/user/info

~~~ java
// 具体功能可参考，下类的方法
// MySecurityMetadataSource#getAttributes
~~~

##### 2、新增“仅限本人数据”的行级数据权限

~~~ java
// 新增一个角色上数据权限类型的常量 
// com.etboot.common.constant.CommonConstant
Integer DATA_TYPE_SELF = 6;

// 具体功能可参考，下类的方法
// SecurityUtil#getIsOnlySelfData
~~~

#### 二、提炼CRUD的base类

Dao层基于`mybatis-plus`的CRUD代码封装，`demo`工程（作者的另外一个工程）里提供代码生成器。

> com.etboot.modules.base.mpbase 目录下

- BaseEntity
- BaseService
- BaseServiceImpl
- mapper/BaseDao
- controller/BaseController  目录这样放，利于AOP日志工具定位切面



