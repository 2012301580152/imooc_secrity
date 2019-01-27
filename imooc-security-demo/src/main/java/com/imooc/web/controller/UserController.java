package com.imooc.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.dto.User;
import com.imooc.dto.UserQueryCondition;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/24 11:43
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping
    @JsonView(User.UserDetailView.class)
    public User create(@Valid @RequestBody User user, BindingResult erros) {

        if (erros.hasErrors()){
            erros.getAllErrors().stream().forEach(erro -> System.out.println(erro.getDefaultMessage()));
        }

        System.out.println(user);

        user.setId("1");
        return user;
    }


    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
//    public List<User>  query(@RequestParam String username){
    public List<User>  query(UserQueryCondition condition, Pageable pageable){
        System.out.println(condition);
        System.out.println(pageable);
        List list = new ArrayList();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }

    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam(value = "用户id") @PathVariable String id) {

//        throw new UserNotExistException(id);
        System.out.println("进入getInfo服务");
        User user = new User();

        user.setUsername("tom");

        return user;
    }

    @PutMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User update(@Valid @RequestBody User user, BindingResult erros) {

        if (erros.hasErrors()){
            erros.getAllErrors().stream().forEach(erro -> System.out.println(erro.getDefaultMessage()));
        }

        System.out.println(user);

        user.setId("1");
        return user;
    }


    @DeleteMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }
}
