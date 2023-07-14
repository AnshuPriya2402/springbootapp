package com.example.demo.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.aws.*;

public interface repository extends JpaRepository<aws, String> {

}