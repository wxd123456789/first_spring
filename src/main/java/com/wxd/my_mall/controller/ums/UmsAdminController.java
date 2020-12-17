package com.wxd.my_mall.controller.ums;

import com.wxd.my_mall.framework.api.CommonPage;
import com.wxd.my_mall.framework.api.Response;
import com.wxd.my_mall.dto.UmsAdminLoginParam;
import com.wxd.my_mall.dto.UmsAdminParam;
import com.wxd.my_mall.mbg.model.UmsAdmin;
import com.wxd.my_mall.mbg.model.UmsRole;
import com.wxd.my_mall.services.UmsAdminService;
import com.wxd.my_mall.services.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台用户管理
 */
@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private UmsRoleService roleService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UmsAdminController.class);

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Response login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return Response.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>(2);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return Response.success(tokenMap);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public Response getAdminInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>(4);
        data.put("username", umsAdmin.getUsername());
        data.put("roles", new String[]{"TEST"});
        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        return Response.success(data);
    }

    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Response<CommonPage<UmsAdmin>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                               @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UmsAdmin> adminList = adminService.list(keyword, pageSize, pageNum);
        return Response.success(CommonPage.restPage(adminList));
    }

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Response<UmsAdmin> getItem(@PathVariable Long id) {
        UmsAdmin admin = adminService.getItem(id);
        return Response.success(admin);
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Response<UmsAdmin> register(@RequestBody UmsAdminParam umsAdminParam, BindingResult result) {
        try {
            UmsAdmin umsAdmin = adminService.register(umsAdminParam);
            return Response.success(umsAdmin);
        } catch (Exception e) {
            return Response.failed(e.getMessage());
        }
    }

    @ApiOperation("给用户分配角色")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    @ResponseBody
    public Response updateRole(@RequestParam("adminId") Long adminId,
                               @RequestParam("roleIds") List<Long> roleIds) {
        try {
            int count = adminService.updateRole(adminId, roleIds);
            return Response.success(count);
        } catch (Exception e) {
            return Response.failed(e.getMessage());
        }
    }

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public Response<List<UmsRole>> getRoleList(@PathVariable Long adminId) {
        List<UmsRole> roleList = adminService.getRoleList(adminId);
        return Response.success(roleList);
    }

    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Response update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
        try {
            int count = adminService.update(id, admin);
            return Response.success(count);
        } catch (Exception e) {
            return Response.failed(e.getMessage());
        }
    }

    @ApiOperation("删除指定用户信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Response delete(@PathVariable Long id) {
        try {
            adminService.delete(id);
            return Response.success(String.format("delete admin id[%s] success", id));
        } catch (Exception e) {
            return Response.failed(e.getMessage());
        }
    }
}