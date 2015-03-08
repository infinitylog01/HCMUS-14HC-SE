package hcmus14hc.cnpm.airplaneticket.model;

import hcmus14hc.cnpm.airplaneticket.pojo.Colors;

public class DumpColorModel {
	public Colors colorCode(String name) {
		switch (name) {
		case "blue":
			return new Colors("0000FF");
		case "red":
			return new Colors("FF0000");
		case "green":
			return new Colors("1EFF00");
		case "yellow":
			return new Colors("EBFF00");
		default:
			return new Colors("");
		}
	}
}
