package com.nestis.cloud.config.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class GarbageController {
	 @RequestMapping(value = "mem", produces = "text/plain")
	    public String mem() { 
	        long total = Runtime.getRuntime().totalMemory(); 
	        long free = Runtime.getRuntime().freeMemory(); 
	        long used = total - free; 
	        return String.format("Memory:\n" +
	                "total: %,d bytes\n" +
	                "free: %,d bytes\n" +
	                "used: %,d bytes\n",
	                total, free, used); 
	    } 
	 
	    @RequestMapping("rungc") 
	    public String rungc() { 
	        Runtime.getRuntime().gc(); 
	        return "Run GC";
	    } 
}
