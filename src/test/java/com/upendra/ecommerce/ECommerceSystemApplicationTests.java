package com.upendra.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class ECommerceSystemApplicationTests {

	@Test
	void contextLoads() {
		ApplicationModules modules = ApplicationModules.of(ECommerceSystemApplication.class)
				.verify();
		new Documenter(modules).writeDocumentation();

	}

}
