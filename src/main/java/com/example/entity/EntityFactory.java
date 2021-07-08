package com.example.entity;

import java.util.Arrays;
import java.util.Map;

public class EntityFactory {

	public static Entity create() {
		Entity e = new Entity();
		e.setId(1);
		e.setStr("abc");
		e.setList(Arrays.asList("AAA", "BBB", "CCC"));
		e.setMap(Map.of("key1", "value1", "key2", "value2"));
		return e;
	}
}
