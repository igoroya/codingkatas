package com.igoroya.codingkatas.march2018.comparablefun;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;

public final class BookShopAnalytics {

	private final List<Book> books;
	private final NumberFormat euroFormatter = new DecimalFormat("#0.00 Euro");
	
	
	public BookShopAnalytics(List<Book> books) {
		this.books = books;
	}

	
	public void printNumberOfBooks() {
		System.out.println("Number of books: "+ books.size());
	}

	public void printNumberOfUniqueBooks() {
		Set<Book> uniqueBooks = new HashSet<>(books);
		System.out.println("Number of unique books: "+ uniqueBooks.size());
	}

	public void printUniqueBooks() {
		Set<Book> uniqueBooks = new HashSet<>(books);
		System.out.println("List of unique books");
		printBooks(uniqueBooks);
	}

	private static void printBooks(Collection<Book> books) {
		for(Book book: books) {
			System.out.println(book);
		}
	}
	
	public void printTotalBooksCost() {
		double sum = books.stream().mapToDouble(Book::getPriceEuros).sum();
		System.out.println("Cost of all books: "+ euroFormatter.format(sum));	
	}
	
	
	public void printAverageBookPrice() {
		OptionalDouble sum = books.stream().mapToDouble(Book::getPriceEuros).average();
		System.out.println("Cost of all books: " + euroFormatter.format(sum.orElse(0.0)));	
	}
}
