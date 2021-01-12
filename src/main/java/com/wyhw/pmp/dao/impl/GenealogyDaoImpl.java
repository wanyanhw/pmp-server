package com.wyhw.pmp.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyhw.pmp.dao.GenealogyDao;
import com.wyhw.pmp.entity.GenealogyEntity;
import com.wyhw.pmp.mapper.GenealogyMapper;
import org.springframework.stereotype.Component;

@Component
public class GenealogyDaoImpl extends ServiceImpl<GenealogyMapper, GenealogyEntity> implements GenealogyDao {
}
