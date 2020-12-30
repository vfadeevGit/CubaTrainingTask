package com.company.cubatraining.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;

@Source(type = SourceType.DATABASE)
public interface CubaTestConfig extends Config {

    @Property("cuba.senderEmail")
    String getSenderEmail();
    void setSenderEmail(String senderEmail);

}