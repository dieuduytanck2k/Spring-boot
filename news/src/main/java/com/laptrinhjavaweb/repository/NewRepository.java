package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.NewEntity;

// Vì JpaRepository có sẵn @Repository nên k cần khai báo
public interface NewRepository extends JpaRepository<NewEntity, Long>{

}
