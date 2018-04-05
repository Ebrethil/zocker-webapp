package com.asozialesnetzwerk.net.zockerwebapp.blog.repository;

import com.asozialesnetzwerk.net.zockerwebapp.blog.model.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, String> {
}
