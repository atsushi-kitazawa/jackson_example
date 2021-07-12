package com.example;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.entity.Entity;
import com.example.entity.SubEntity;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class StreamingExample {

	private void jsonToClass(String json) throws Exception {
		JsonFactory factory = new JsonFactory();
		JsonParser parser = factory.createParser(json);

		Entity entity = new Entity();

		while (parser.nextToken() != JsonToken.END_OBJECT) {
			String fieldName = parser.getCurrentName();
			if ("id".equals(fieldName)) {
				parser.nextToken();
				print(fieldName, parser.getText());
				entity.setId(Integer.parseInt(parser.getText()));
			}

			if ("str".equals(fieldName)) {
				parser.nextToken();
				print(fieldName, parser.getText());
				entity.setStr(parser.getText());
			}

			if ("list".equals(fieldName)) {
				parser.nextToken();
				List<String> list = new ArrayList<>();
				while (parser.nextToken() != JsonToken.END_ARRAY) {
					print(fieldName, parser.getText());
					list.add(parser.getText());
				}
				entity.setList(list);
			}

			if ("map".equals(fieldName)) {
				parser.nextToken();
				Map<String, String> map = new HashMap<>();
				while (parser.nextToken() != JsonToken.END_OBJECT) {
					String key = parser.getText();
					parser.nextToken();
					String val = parser.getText();
					print(fieldName, key);
					print(fieldName, val);
					map.put(key, val);
				}
				entity.setMap(map);
			}

			if ("subList".equals(fieldName)) {
				parser.nextToken();
				List<SubEntity> list = new ArrayList<>();
				while (parser.nextToken() != JsonToken.END_ARRAY) {
					SubEntity subEntity = new SubEntity();
					while (parser.nextToken() != JsonToken.END_OBJECT) {
						String subStrField = parser.getCurrentName();
						if ("subStr".equals(subStrField)) {
							parser.nextToken();
							print(fieldName, parser.getText());
							subEntity.setSubStr(parser.getText());
						}
					}
					list.add(subEntity);
				}
				entity.setSubList(list);
			}
		}

		System.out.println(entity);

		parser.close();
	}

	private void print(String field, String value) {
		//System.out.println(field + ":" + value);
	}
	
	public static void main(String[] args) throws Exception {
		StreamingExample se = new StreamingExample();
		String json = Files
				.lines(Paths.get(StreamingExample.class.getClassLoader()
						.getResource("example.json").toURI()),
						Charset.forName("UTF-8"))
				.collect(Collectors
						.joining(System.getProperty("line.separator")));
		// System.out.println(json);
		se.jsonToClass(json);
	}
}