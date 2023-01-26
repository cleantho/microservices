package com.course.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
