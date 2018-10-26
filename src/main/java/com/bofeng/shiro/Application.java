package com.bofeng.shiro;

import com.bofeng.shiro.config.DisableSSLCertificateCheckUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequiresPermissions(value = "role:edit")
    @GetMapping(value = "/roles/{id}")
    public String put() {
        return "允许修改角色";
    }

    @RequiresPermissions(value = "user:info")
    @GetMapping(value = "/users/{id}")
    public PrincipalCollection getUserById() {
        return SecurityUtils.getSubject().getPrincipals();
    }

    @GetMapping(value = "/you")
    public String you() {
        return "you you 不需要权限";
    }

    @GetMapping(value = "/callback")
    public String getUserById1() {
            return "登陆成功！";
    }
    @GetMapping(value = "/")
    public String getUserById2() {
        return "登陆成功！首页";
    }


}