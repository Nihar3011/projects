/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argus.springboot.CRUD.CRUD_Spring.service;

import com.argus.springboot.CRUD.CRUD_Spring.files.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nihar
 */
public interface StudentRepository extends JpaRepository<Student, Integer>{
    
    
}
