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
		CurrentUsingApp currentApp2 = createDummyObject();
		currentApp2.setName("sasa");
		currentApp2.setTime("22:2222");
		try {
			// Convert object to JSON string and save into a file directly
			File file = new File("/home/mrs/staff.json");
			mapper.writeValue(file, currentApp);
			mapper.writeValue(file, currentApp2);
			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(currentApp);
			String jsonInString2 = mapper.writeValueAsString(currentApp2);
			System.out.println(jsonInString2);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(currentApp);
			jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(currentApp2);
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
		
