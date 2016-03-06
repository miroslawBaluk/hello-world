package com.json.converting;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Jackson2Example {
	public static void main(String[] args) {
		Jackson2Example obj = new Jackson2Example();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		CurrentUsingApp currentApp = createDummyObject();

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("/home/mrs/staff.json"), currentApp);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(currentApp);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(currentApp);

			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private CurrentUsingApp createDummyObject() {

		CurrentUsingApp currentApp = new CurrentUsingApp();
		currentApp.setTime("11:10");
		currentApp.setName("Jakas aplikacja odpalona");

		return currentApp;

	}

}
		
