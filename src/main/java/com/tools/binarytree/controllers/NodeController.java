package com.tools.binarytree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tools.binarytree.models.Node;
import com.tools.binarytree.services.interfaces.INodeService;

@RestController
@RequestMapping("/nodes")
public class NodeController {
    @Autowired
    private INodeService nodeService;

    @PostMapping
    public Node insertNode(@RequestBody Node node) {
        nodeService.insertNode(node);
        return node;
    }

    @GetMapping("/{id}")
    public Node findNodeById(@PathVariable Long id) {
        return nodeService.findNodeById(id);
    }

    @GetMapping("/{id}/inorder")
    public String inorder(@PathVariable Long id) { 
        return  nodeService.inorder(nodeService.findNodeById(id), "");
    }

    @GetMapping("/{id}/preorder")
    public String preorder(@PathVariable Long id) {
        return  nodeService.preorder(nodeService.findNodeById(id), "");
    }

    @GetMapping("/{id}/postorder")
    public String postorder(@PathVariable Long id) {
        return  nodeService.postorder(nodeService.findNodeById(id), "");
    }

   
}
