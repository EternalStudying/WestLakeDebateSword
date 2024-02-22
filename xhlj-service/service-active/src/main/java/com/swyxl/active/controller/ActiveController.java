package com.swyxl.active.controller;

import com.swyxl.active.service.ActiveService;
import com.swyxl.model.entity.service.active.Active;
import com.swyxl.model.vo.common.Result;
import com.swyxl.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/active/active")
public class ActiveController {

    @Autowired
    private ActiveService activeService;

    @GetMapping("/auth/enroll/{id}")
    public Result enroll(@PathVariable Long id){
        activeService.enroll(id);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @GetMapping("/list")
    public Result list(){
        List<Active> activeList = activeService.list();
        return Result.build(activeList, ResultCodeEnum.SUCCESS);
    }

    @GetMapping("auth/active")
    public Result active(){
        List<Active> activeList = activeService.active();
        return Result.build(activeList, ResultCodeEnum.SUCCESS);
    }

    @PutMapping("/auth/like/{id}")
    public Result like(@PathVariable Long id){
        activeService.like(id);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
}
