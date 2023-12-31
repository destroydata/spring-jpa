package com.example.demo.hobby.controller;

import com.example.demo.hobby.domain.entity.Hobby;
import com.example.demo.hobby.domain.request.ConnectRequest;
import com.example.demo.hobby.domain.request.HobbyRequest;
import com.example.demo.hobby.domain.response.HobbyResponse;
import com.example.demo.hobby.service.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hobbies")
public class HobbyController {
    private final HobbyService service;
    @PostMapping
    public void save(@RequestBody HobbyRequest request){
        service.save(request);
    }

    @GetMapping("{id}")
    public HobbyResponse getById(@PathVariable("id") Long id){
        return service.findById(id);
    }
    @GetMapping
    public List<HobbyResponse> getAll(){
        return service.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @PostMapping("connect")
    public void connect(@RequestBody ConnectRequest request){
        service.connect(request);
    }

}
