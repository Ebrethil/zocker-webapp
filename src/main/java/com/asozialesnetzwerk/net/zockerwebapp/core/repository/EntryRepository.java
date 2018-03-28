package com.asozialesnetzwerk.net.zockerwebapp.core.repository;

import com.asozialesnetzwerk.net.zockerwebapp.core.model.TestEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<TestEntry, String> {

}
