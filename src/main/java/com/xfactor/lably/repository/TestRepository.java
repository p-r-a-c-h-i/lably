package com.xfactor.lably.repository;

import com.xfactor.lably.entity.Tests;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Tests, Long> {

}