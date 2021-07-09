package com.example;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import com.example.entity.Entity;
import com.example.entity.EntityFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SimpleConverter {

	private void JsonToClass(String json) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Entity e = mapper.readValue(json, Entity.class);
		System.out.println(e);
	}

	private void ClassToJson(Entity e) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(e);
		System.out.println(json);
	}

	public static void main(String[] args) throws Exception {
		SimpleConverter c = new SimpleConverter();
		c.ClassToJson(EntityFactory.create());

		String json = Files
				.lines(Paths.get(SimpleConverter.class.getClassLoader()
						.getResource("example.json").toURI()),
						Charset.forName("UTF-8"))
				.collect(Collectors
						.joining(System.getProperty("line.separator")));
		c.JsonToClass(json);
	}
}
