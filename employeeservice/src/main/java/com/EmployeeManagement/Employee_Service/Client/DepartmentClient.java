package com.EmployeeManagement.Employee_Service.Client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class DepartmentClient {

    private final RestTemplate restTemplate;

    @Value("${department.service.url}")
    private String departmentServiceUrl;

    public DepartmentClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean departmentExists(Long deptId) {
        String url = departmentServiceUrl + "/api/v1/department/" + deptId + "/exists";
        try {
            Boolean exists = restTemplate.getForObject(url, Boolean.class);
            return Boolean.TRUE.equals(exists);
        } catch (RestClientException e) {
            log.error("Failed to reach department-service for deptId {}: {}", deptId, e.getMessage());
            return false;
        }
    }
}
