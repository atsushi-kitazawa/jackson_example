package com.example;

import java.util.Iterator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNodeExample {

	private JsonNode getJsonNode(String json) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readTree(json);
	}

	private void printField(JsonNode node) {
		for (Iterator<String> i = node.fieldNames(); i.hasNext();) {
			String field = i.next();
			System.out.println(field);
		}
	}

	public static void main(String[] args) throws Exception {
		String json = "{\"id\":1,\"str\":\"abc\",\"list\":[\"AAA\",\"BBB\",\"CCC\"],\"map\":{\"key2\":\"value2\",\"key1\":\"value1\"}}";
		JsonNodeExample jnx = new JsonNodeExample();
		JsonNode jn = jnx.getJsonNode(json);

		jnx.printField(jn);
	}
}
