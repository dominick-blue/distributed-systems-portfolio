package com.loyalblue.ecommerce.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HealthCheckController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public String healthCheck() {
        try {
            jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            return "{\"status\": \"UP\"}";
        } catch (Exception e) {
            return "{\"status\": \"DOWN\", \"error\": \"" + e.getMessage() + "\"}";
        }
    }
}