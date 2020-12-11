package cn.exrick.xboot.modules.base.mpbase;

import cn.exrick.xboot.modules.base.mpbase.mapper.BaseDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E, ID extends Serializable> {
    BaseDao<E> getDao();

    /**
     * 根据ID获取
     *
     * @param id
     * @return
     */
    public default E get(ID id) {
        return getDao().selectById(id);
    }

    /**
     * 获取所有列表
     *
     * @return
     */
    public default List<E> getAll() {
        return getDao().selectList(null);
    }

    /**
     * 获取总数
     *
     * @return
     */
    public default Integer getTotalCount() {
        return getDao().selectCount(null);
    }

    /**
     * 保存
     *
     * @param entity
     * @return
     */
    public default int save(E entity) {
        return getDao().insert(entity);
    }

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    public default int update(E entity) {
        // return getDao().update(entity, null); // this method is dangerous
        return getDao().updateById(entity);
    }

    /**
     * 根据Id删除
     *
     * @param id
     * @return
     */
    public default int delete(ID id) {
        return getDao().deleteById(id);
    }

    /**
     * 根据条件查询获取
     *
     * @param queryWrapper
     * @return
     */
    public default List<E> findAll(QueryWrapper queryWrapper) {
        return getDao().selectList(queryWrapper);
    }

    /**
     * 分页获取
     * @param page
     * @return
     */
    public default Page<E> findAll(Page<E> page) {
        return getDao().selectPage(page, null);
    }

    /**
     * 根据查询条件分页获取
     * @param page
     * @param queryWrapper
     * @return
     */
    public default Page<E> findAll(Page<E> page, QueryWrapper<E> queryWrapper) {
        return getDao().selectPage(page, queryWrapper);
    }

    /**
     * 获取查询条件的结果数
     *
     * @param queryWrapper
     * @return
     */
    public default Integer count(QueryWrapper<E> queryWrapper) {
        return getDao().selectCount(queryWrapper);
    }


//    E get(ID id);
//
//    List<E> getAll();
//
//    Integer getTotalCount();
//
//    int save(E entity);
//
//    int update(E entity);
//
//    int delete(ID id);
//
//    List<E> findAll(QueryWrapper queryWrapper);
//
//    Page<E> findAll(Page<E> page);
//
//    Page<E> findAll(Page<E> page, QueryWrapper<E> queryWrapper);
//
//    Integer count(QueryWrapper<E> queryWrapper);
}
