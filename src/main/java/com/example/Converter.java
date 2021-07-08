package com.example;

import com.example.entity.Entity;
import com.example.entity.EntityFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter {

	private void JsonToClass(String json) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Entity e = mapper.readValue(json, Entity.class);
		System.out.println(e);
	}

	private void ClassToJson(Entity e) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(e);
		System.out.println(json);
	}

	public static void main(String[] args) throws Exception {
		Converter c = new Converter();
		c.ClassToJson(EntityFactory.create());

		String json = "{\"id\":1,\"str\":\"abc\",\"list\":[\"AAA\",\"BBB\",\"CCC\"],\"map\":{\"key2\":\"value2\",\"key1\":\"value1\"}}";
		c.JsonToClass(json);
	}
}
