package com.asozialesnetzwerk.net.zockerwebapp.blog.web.controller;

import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Dashboard;
import com.asozialesnetzwerk.net.zockerwebapp.blog.repository.DashboardRepository;
import com.asozialesnetzwerk.net.zockerwebapp.blog.web.dto.DashboardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DashboardController {
    private final DashboardRepository dashboardRepository;

    @Autowired
    public DashboardController(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    @PostMapping("/api/dashboards")
    public HttpEntity createComment(@RequestBody DashboardDto dashboardDto) {
        dashboardRepository.save(new Dashboard(dashboardDto.getTitle()));

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/api/dashboards")
    public HttpEntity<List<Dashboard>> getAllDashboards() {
        return new ResponseEntity<>(dashboardRepository.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/api/dashboards/{id}")
    public HttpEntity<Dashboard> getDashboardById(@PathVariable String id) {
        return new ResponseEntity<>(dashboardRepository.findOne(id), HttpStatus.FOUND);
    }

    @DeleteMapping("/api/dashboards/{id}")
    public HttpEntity deleteDashboardById(@PathVariable String id){
        dashboardRepository.delete(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
