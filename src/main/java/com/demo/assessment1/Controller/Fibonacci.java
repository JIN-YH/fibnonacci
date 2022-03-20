package com.demo.assessment1.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
//@RequestMapping("/fibonacci")
public class Fibonacci {

    @RequestMapping(path = "/fibonacci", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, int[]> fibonacci(@RequestBody Map<String, Integer> jsonMap) {
        int n = jsonMap.get("elements");
        //if n == 1, there is no other operation
        if (n == 1) {
            int[] ls = new int[] {0};
            Map<String, int[]> map = new HashMap<>();
            map.put("fibonacci", ls);
            map.put("sorted", ls);
            return map;
        }
        //if n > 1, we need calculate the fibonacci numbers
        return fib(n);

    }

    private Map<String, int[]> fib(int n) {
        List<Integer> odds = new ArrayList<>(); //contains odd values of fibonacci list
        List<Integer> evens = new ArrayList<>(); //contains even values of fibonacci list
        int[] fibs = new int[n];
        fibs[1] = 1; //initialize the second number
        odds.add(1);
        evens.add(0);
        for (int i = 2; i < n; i++) {
            //calculate current fibonacci number by the former 2 numbers
            fibs[i] = fibs[i-1] + fibs[i-2];
            if (fibs[i] % 2 == 0) evens.add(fibs[i]);
            else odds.add(fibs[i]);
        }
        Map<String, int[]> map = new HashMap<>();
        map.put("fibonacci", fibs);
        int[] sorts = new int[n];
        for (int i = 0; i < evens.size(); i++) {
            //evens are in increasing order, so we add number reversely
            sorts[i] = evens.get(evens.size()-1-i);
        }
        for (int i = 0; i < odds.size(); i++) {
            //after adding evens, the next index of sorts is evens.size()
            sorts[i+evens.size()] = odds.get(odds.size()-1-i);
        }
        map.put("sorted", sorts);
        return map;
    }




}

