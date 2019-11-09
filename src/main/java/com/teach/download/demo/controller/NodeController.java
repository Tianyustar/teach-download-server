package com.teach.download.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.teach.download.demo.entity.Node;
import com.teach.download.demo.mapper.NodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.teach.download.demo.service.NodeService;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author libre
 * @since 2019-11-09
 */
@RestController
@RequestMapping("/node")
public class NodeController {

    @Autowired
    NodeService nodeService;

    @Autowired
    NodeMapper nodeMapper;

    @GetMapping("/list")
    public IPage<Node> GetChildeList(String parentId, Page pagination) {

        QueryWrapper<Node> wapper = new QueryWrapper<>();
        wapper.lambda().eq(Node::getParentId, parentId);
        return nodeService.selectByPage(pagination,wapper);
    }

    @GetMapping("/info")
    public Node GetNode(String id) {
        return nodeService.getById(id);
    }
}

