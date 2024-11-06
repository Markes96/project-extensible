package org.mk96.extensible.api.infrastucture.http.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mk96.extensible.api.infrastucture.http.controller.requitement.MkControllerTestConfig;
import org.mk96.extensible.api.infrastucture.http.controller.requitement.impl.MkController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MkControllerTestConfig.class)
public class MkControllerTest {

	@Autowired
	MkController controller;

	@Test
	void example() {
		Assertions.assertTrue(true);
	}

}
