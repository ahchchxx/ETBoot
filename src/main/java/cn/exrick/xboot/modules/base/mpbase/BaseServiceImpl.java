package cn.exrick.xboot.modules.base.mpbase;

import cn.exrick.xboot.modules.base.mpbase.mapper.BaseDao;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

//@Service
//public class BaseServiceImpl<E, ID extends Serializable> implements BaseService<E, ID> {
//    @Autowired
//    getDao()<E> getDao();

//    /**
//     * 根据ID获取
//     * @param id
//     * @return
//     */
//    @Override
//    public E get(ID id) {
//        return getDao().selectById(id);
//    }
//
//    /**
//     * 获取所有列表
//     * @return
//     */
//    @Override
//    public List<E> getAll() {
//        return getDao().selectList(null);
//    }
//
//    /**
//     * 获取总数
//     * @return
//     */
//    @Override
//    public Integer getTotalCount() {
//        return getDao().selectCount(null);
//    }
//
//    /**
//     * 保存
//     * @param entity
//     * @return
//     */
//    @Override
//    public int save(E entity) {
//        return getDao().insert(entity);
//    }
//
//    /**
//     * 修改
//     * @param entity
//     * @return
//     */
//    @Override
//    public int update(E entity) {
//        return getDao().update(entity, null);
//    }
//
//    /**
//     * 批量保存与修改
//     * @param entities
//     * @return
//     */
////    public Iterable<E> saveOrUpdateAll(Iterable<E> entities) {
////        return getRepository().saveAll(entities);
////    }
//
//    /**
//     * 删除
//     * @param entity
//     */
////    public void delete(E entity) {
////        getRepository().delete(entity);
////    }
//
//    /**
//     * 根据Id删除
//     * @param id
//     * @return
//     */
//    @Override
//    public int delete(ID id) {
//        return getDao().deleteById(id);
//    }
//
//    /**
//     * 批量删除
//     * @param entities
//     */
////    public void delete(Iterable<E> entities) {
////        getRepository().deleteInBatch(entities);
////        getDao().deleteBatchIds()
////    }
//
//    /**
//     * 清空缓存，提交持久化
//     */
////    public void flush() {
////        getRepository().flush();
////    }
//
//    /**
//     * 根据条件查询获取
//     * @param queryWrapper
//     * @return
//     */
//    @Override
//    public List<E> findAll(QueryWrapper queryWrapper) {
//        return getDao().selectList(queryWrapper);
//    }
//
//    /**
//     * 分页获取
//     * @param page
//     * @return
//     */
//    @Override
//    public Page<E> findAll(Page<E> page) {
//        return getDao().selectPage(page, null);
//    }
//
//    /**
//     * 根据查询条件分页获取
//     * @param page
//     * @param queryWrapper
//     * @return
//     */
//    @Override
//    public Page<E> findAll(Page<E> page, QueryWrapper<E> queryWrapper) {
//        return getDao().selectPage(page, queryWrapper);
//    }
//
//    /**
//     * 获取查询条件的结果数
//     * @param queryWrapper
//     * @return
//     */
//    @Override
//    public Integer count(QueryWrapper<E> queryWrapper) {
//        return getDao().selectCount(queryWrapper);
//    }
//
//}
