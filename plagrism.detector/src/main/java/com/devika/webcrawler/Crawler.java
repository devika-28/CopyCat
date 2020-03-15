package com.devika.webcrawler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.devika.buffer.InputBuffer;
import com.devika.webcrawler.CrawlerQuery;

public class Crawler {

	final static Logger LOG = Logger.getLogger(Crawler.class);

	public void crawlerWithFiles() throws IOException, FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file path: ");
		InputBuffer inputFile = new InputBuffer();
		ArrayList<String> ls = inputFile.insertFile(sc.nextLine());
		LOG.info("file is Uploaded successfully");
		// E:\eclipse\TesterPlagrism.txt
		sc.close();

		for (String search : ls) {
			if (ls.size() > 3) {
				checkPlagiarism(search);
			}
		}
	}

	public void crawlerWithText() throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter text: ");
		LOG.info("Text is entered successfully");
		InputBuffer input = new InputBuffer();
		ArrayList<String> temp = input.processText(sc.nextLine());
		for (String i : temp) {
			checkPlagiarism(i);
		}
		sc.close();
	}

	void checkPlagiarism(String search) throws IOException {
		CrawlerQuery gsq = new CrawlerQuery();
		Document doc = Jsoup.connect(gsq.query(search)).get();

		Elements rc = doc.select("div.rc");
		for (Element i : rc) {
			Elements em = i.select("em");
			if ((em.text()).equals(search)) {
				Element link = i.select("div.r a").first();
				System.out.println("Plagiarism detected in: " + search + " \nLink: " + link.attr("href") + "\n");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------");
				break;
			}
		}
	}
}