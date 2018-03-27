package com.asozialesnetzwerk.net.zockerwebapp.core.repository;

import com.asozialesnetzwerk.net.zockerwebapp.core.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String>{
}
