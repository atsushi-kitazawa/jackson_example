package com.example;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class StreamingExample {

	private void jsonToClass(String json) throws Exception {
		JsonFactory factory = new JsonFactory();
		JsonParser parser = factory.createParser(json);

		while (parser.nextToken() != JsonToken.END_OBJECT) {
			String fieldName = parser.getCurrentName();
			if ("id".equals(fieldName)) {
				parser.nextToken();
				print(fieldName, parser.getText());
			}

			if ("str".equals(fieldName)) {
				parser.nextToken();
				print(fieldName, parser.getText());
			}

			if ("list".equals(fieldName)) {
				parser.nextToken();
				while (parser.nextToken() != JsonToken.END_ARRAY) {
					print(fieldName, parser.getText());
				}
			}

			if ("map".equals(fieldName)) {
				parser.nextToken();
				while (parser.nextToken() != JsonToken.END_OBJECT) {
					print(fieldName, parser.getText());
				}
			}

			if ("subList".equals(fieldName)) {
				parser.nextToken();
				while (parser.nextToken() != JsonToken.END_ARRAY) {
					while (parser.nextToken() != JsonToken.END_OBJECT) {
						String subStrField = parser.getCurrentName();
						if ("subStr".equals(subStrField)) {
							parser.nextToken();
							print(fieldName, parser.getText());
						}
					}
				}
			}
		}

		parser.close();
	}

	private void print(String field, String value) {
		System.out.println(field + ":" + value);
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