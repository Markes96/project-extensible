package org.mk96.extensible.api.crud;

import org.junit.jupiter.api.Test;
import org.mk96.extensible.api.crud.config.MkCrudServiceTestConfig;
import org.mk96.extensible.api.crud.requirement.domain.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MkCrudServiceTestConfig.class)
public class MkCrudServiceTest {

	@Autowired
	CrudService service;

	@Test
	void example() {
		// service.create(null);
		// service.delete(null);
		System.out.println();
	}

}
