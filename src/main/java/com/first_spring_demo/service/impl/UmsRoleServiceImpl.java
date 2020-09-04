package com.first_spring_demo.service.impl;

import com.first_spring_demo.dao.UmsRoleDao;
import com.first_spring_demo.mbg.model.UmsMenu;
import com.first_spring_demo.mbg.model.UmsPermission;
import com.first_spring_demo.mbg.model.UmsResource;
import com.first_spring_demo.mbg.model.UmsRole;
import com.first_spring_demo.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 后台角色管理Service实现类
 * @author wxd
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsRoleDao roleDao;

    @Override
    public int create(UmsRole role) {
        return 0;
    }

    @Override
    public int update(Long id, UmsRole role) {
        return 0;
    }

    @Override
    public int delete(List<Long> ids) {
        return 0;
    }

    @Override
    public List<UmsPermission> getPermissionList(Long roleId) {
        return null;
    }

    @Override
    public int updatePermission(Long roleId, List<Long> permissionIds) {
        return 0;
    }

    @Override
    public List<UmsRole> list() {
        return null;
    }

    @Override
    public List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return roleDao.getMenuList(adminId);
    }

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return null;
    }

    @Override
    public List<UmsResource> listResource(Long roleId) {
        return null;
    }

    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        return 0;
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        return 0;
    }

}
