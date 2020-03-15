package com.devika.webcrawler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class PlagiarismDetector {

	final static Logger LOG = Logger.getLogger(PlagiarismDetector.class);

	public static void main(String... strings) {

		System.out.println("Do you want to Upload a file, Or enter the text");
		System.out.println(
				"Press 1: Upload File\nPress 2: Enter Text(HINT: use this when your data is free of any new line character!)");
		Crawler crawl = new Crawler();

		try (Scanner sc = new Scanner(System.in)) {
			switch (sc.nextInt()) {

			case 1: {
				LOG.info("Redirected to Crawler with files");
				crawl.crawlerWithFiles();
				break;
			}
			case 2: {
				LOG.info("Redirected to Crawler with text");
				crawl.crawlerWithText();
				break;
			}
			default: {
				LOG.error("wrong Selection");
				System.out.println(
						"Sorry for inconvinience! \nTryAgain! \nYou only have two choices\nPS: Select from either 1: Upload File \n2: Enter Text");
			}
			}
		} catch (FileNotFoundException e) {
			LOG.error("Enter correct file path");
			e.printStackTrace();
		} catch (IOException e) {
			LOG.error("an IO exception was encountered");
			e.printStackTrace();
		}

	}

}
