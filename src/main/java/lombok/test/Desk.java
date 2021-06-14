package lombok.test;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString

@RequiredArgsConstructor
public class Desk {

	private final double price;
	private final String model;
	private String name;
}