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
		e.setSubList(Arrays.asList(createSubEntity("sub1"), createSubEntity("sub2")));
		return e;
	}

	private static SubEntity createSubEntity(String param) {
		SubEntity e = new SubEntity();
		e.setSubStr(param);

		return e;
	}
}
