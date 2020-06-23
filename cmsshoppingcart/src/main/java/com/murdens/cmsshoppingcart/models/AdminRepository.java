package com.murdens.cmsshoppingcart.models;

import com.murdens.cmsshoppingcart.models.data.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    
    Admin findByUsername(String username);
}