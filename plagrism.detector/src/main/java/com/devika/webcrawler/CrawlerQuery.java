package com.devika.webcrawler;

public class CrawlerQuery {

	public String query(String input) {
		String query = "https://www.google.com/search?q=\"";
		String[] ls = input.split(" ");
		for (String i : ls) {
			query += i + "+";
		}
		return query + "\"";
	}
}