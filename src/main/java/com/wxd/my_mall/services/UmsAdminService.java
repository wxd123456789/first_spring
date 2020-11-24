package com.wxd.my_mall.services;

import com.wxd.my_mall.dto.UmsAdminParam;
import com.wxd.my_mall.mbg.model.UmsAdmin;
import com.wxd.my_mall.mbg.model.UmsResource;
import com.wxd.my_mall.mbg.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface UmsAdminService {
    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);


    /**
     * 修改用户角色关系
     */
    @Transactional
    int updateRole(Long adminId, List<Long> roleIds);


    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 获取指定用户的可访问资源
     */
    List<UmsResource> getResourceList(Long adminId);

    /**
     * 根据用户id获取用户
     */
    UmsAdmin getItem(Long id);

    /**
     * 根据用户名或昵称分页查询用户
     */
    List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum);

    /**
     * 获取用户对于角色
     */
    List<UmsRole> getRoleList(Long adminId);


    /**
     * 修改指定用户信息
     */
    int update(Long id, UmsAdmin admin);


    /**
     * 删除指定用户
     */
    void delete(Long id);
}
