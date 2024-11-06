package org.mk96.extensible.api.type;

import org.mk96.extensible.api.util.MkBeanCreationUtils;

import jakarta.annotation.PostConstruct;

public class AbstractMkBean {

    @PostConstruct
    void _init_() {
    	MkBeanCreationUtils.checkAutowired(this);
    }
	
}
