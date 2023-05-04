package com.interview.demo.controller;


import com.interview.demo.job.Job;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@RestController
@RequestMapping("/api/v1/")
public class JobController {
    @GetMapping("/job")
    public ResponseEntity<Job[]> requestAllJobs(){
        final String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Job[]> result = restTemplate.getForEntity(uri, Job[].class);
        return result;
    }

    @GetMapping("job/{id}")
    public ResponseEntity<Job> requestJob(@PathVariable("id") String id){
        final String uri = "http://dev3.dansmultipro.co.id/api/recruitment/positions/"+id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Job> result = restTemplate.getForEntity(uri, Job.class);
        return result;
    }

}
