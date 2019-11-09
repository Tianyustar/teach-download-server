package com.teach.download.demo.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.teach.download.demo.mapper.NodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teach.download.demo.entity.Node;

import java.io.File;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author libre
 * @since 2019-11-09
 */
@Service
public class NodeService extends ServiceImpl<NodeMapper, Node>  {

    @Autowired
    NodeMapper nodeMapper;
    public IPage<Node> selectByPage(Page page, QueryWrapper<Node> wapper) {
        IPage<Node> resPage = nodeMapper.selectPage(page, wapper);
        return resPage;
    }
}
