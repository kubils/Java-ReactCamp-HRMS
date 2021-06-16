package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.concretes.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTypeDao extends JpaRepository<WorkType, Integer> {
}
