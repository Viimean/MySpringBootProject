package com.vimean.employees.employee.external;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExternalConfig {
    @Value("s")
    protected String sssss;
}
