package com.timsanalytics.springbase.services;

import com.timsanalytics.springbase.beans.KeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final Environment environment;

    @Autowired
    public MainService(Environment environment) {
        this.environment = environment;
    }

    public KeyValue getMain() {
        // Comment A
        return new KeyValue("response", this.environment.getProperty("application.displayName"));
    }
}
