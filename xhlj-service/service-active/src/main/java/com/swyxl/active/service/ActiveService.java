package com.swyxl.active.service;

import com.swyxl.model.entity.service.active.Active;
import com.swyxl.model.vo.service.active.ActiveShareVo;

import java.util.List;

public interface ActiveService {
    void enroll(Long activeId);

    List<Active> list();

    List<Active> active();

    void like(Long id);

    ActiveShareVo share(Long id);
}
