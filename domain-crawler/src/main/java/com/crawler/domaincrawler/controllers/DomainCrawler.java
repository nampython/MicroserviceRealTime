package com.crawler.domaincrawler.controllers;

import com.crawler.domaincrawler.services.DomainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/domain")
public class DomainCrawler {


    @Autowired
    private DomainService domainService;
    
    @GetMapping("lookup/{name}")
    public String lookup(@PathVariable("name") final String name){
        domainService.crawl(name);
        return "Domain crawler has scrapped your data";

    }
}
