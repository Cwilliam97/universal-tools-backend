package com.tools.binarytree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nodes")
public class NodeController {
    @Autowired
    private NodeService nodeService;

    @PostMapping
    public Node insertNode(@RequestBody Node node) {
        nodeService.insertNode(node);
        return node;
    }

    @GetMapping("/{id}")
    public Node findNodeById(@PathVariable Long id) {
        return nodeService.findNodeById(id);
    }
}
