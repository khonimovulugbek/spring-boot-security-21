package com.spring.security.service;

import org.springframework.stereotype.Service;

@Service
public class JWTService {
    public String generateToken() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IktoYW4iLCJpYXQiOjE1MTYyMzkwMjJ9.3On2cZYXn84-7MSDjQrgCVuaLcuMGnm-j5NEAjf95ok";
    }
}
