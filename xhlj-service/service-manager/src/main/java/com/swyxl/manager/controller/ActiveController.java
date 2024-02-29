package com.swyxl.manager.controller;


import com.github.pagehelper.Page;
import com.swyxl.feign.common.CommonFeignClient;
import com.swyxl.manager.service.ActiveService;
import com.swyxl.model.constant.TypeConstant;
import com.swyxl.model.entity.service.active.Active;
import com.swyxl.model.vo.common.PageResult;
import com.swyxl.model.vo.common.Result;
import com.swyxl.model.vo.common.ResultCodeEnum;
import com.swyxl.model.vo.service.active.ActiveQueryVo;
import com.swyxl.model.vo.service.active.ActiveStatisticVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/service/manager/active/auth")
public class ActiveController {

    @Autowired
    private ActiveService activeService;

    @PostMapping("/add")
    public Result add(@RequestBody Active active){
        activeService.add(active);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    @GetMapping("/find/{id}")
    public Result find(@PathVariable Long id){
        Active active = activeService.findById(id);
        return Result.build(active,ResultCodeEnum.SUCCESS);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Active active){
       activeService.update(active);
       return Result.build(null,ResultCodeEnum.SUCCESS);
    }

    @PutMapping("/delete/{id}")
    public Result delete(@PathVariable Long id){
        activeService.deleteById(id);
        return Result.build(null,ResultCodeEnum.SUCCESS);
    }

    @GetMapping("/getAll")
    public Result getAll(){
        List<Active> list =  activeService.getAll();
        return Result.build(list,ResultCodeEnum.SUCCESS);
    }

    @PostMapping("/upload")
    public Result upload(MultipartFile file){
        String url = activeService.fileUpload(file);
        return Result.build(url, ResultCodeEnum.SUCCESS);
    }

    //统计注册活动
    @GetMapping("/getRegister")
    public Result getRegister(){
        Integer registerNumber =activeService.getRegister();
        return Result.build(registerNumber,ResultCodeEnum.SUCCESS);
    }

    //分页查询
    @GetMapping("/pageSelect/{limit}/{page}")
    public Result pageSelect(@PathVariable Integer limit,
                             @PathVariable Integer page,
                             @RequestBody ActiveQueryVo activeQueryVo){
       PageResult pageResults =  activeService.page(limit,page,activeQueryVo);
       return Result.build(pageResults,ResultCodeEnum.SUCCESS);
    }
    //统计活动情况
    @GetMapping("/statistics/{id}")
    public Result getSituation(@PathVariable Long id){
        ActiveStatisticVo activeStatisticVo =activeService.getStatistics(id);
        return Result.build(activeStatisticVo,ResultCodeEnum.SUCCESS);
    }
}
