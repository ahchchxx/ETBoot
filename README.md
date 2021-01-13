## ETBoot

### Spring-boot Project Sample

Keeping learning and improving. 

> It is a forked project from XBoot.

### 功能增强
资源权限方面
#### 一、管理员角色功能增强
- ADMIN角色用户默认访问任意资源，无需配置
- 对其余角色而言，都需要先配置permission资源，再给角色绑上资源权限
- 增加 2个系统必须使用的资源，首次登录时使用
    1. /xboot/permission/getMenuList*
    2. /xboot/user/info

~~~ java
// 具体功能可参考，下类的方法
// MySecurityMetadataSource#getAttributes
~~~

#### 二、新增“仅限本人数据”的行级数据权限

~~~ java
// 新增一个角色上数据权限类型的常量
Integer DATA_TYPE_SELF = 6;

// 具体功能可参考，下类的方法
// SecurityUtil#getIsOnlySelfData
~~~
