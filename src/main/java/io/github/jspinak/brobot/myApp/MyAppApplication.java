package io.github.jspinak.brobot.myApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(MyAppApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);

		AutomationInstructions automationInstructions = context.getBean(AutomationInstructions.class);
		automationInstructions.doAutomation();
	}

}
