package com.test.RestApi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.RestApi.Ent.lokasi;

public interface lokasiRepo extends JpaRepository<lokasi, Integer> {
  
}
