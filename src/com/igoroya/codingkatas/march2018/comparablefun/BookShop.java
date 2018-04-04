package com.igoroya.codingkatas.march2018.comparablefun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookShop {

	private final List<Book> books;
	
	public BookShop() {
		books = new ArrayList<>();
	}
	
	
	List<Book> getBooks() {
		return new ArrayList<Book>(books);
	}
	
	public void addBook(Book book) {
		books.add(book);
	}

	public void printBooks() {
		for(Book book: books) {
			System.out.println(book);
		}
	}
	
	public void sortByName( ) {
		Collections.sort(books);
	}
	
	public void sortByPrice() {
		books.sort( 
			(Book b1, Book b2) -> {
				return b1.getPriceEuros() > b2.getPriceEuros() ? 
						1 : b1.getPriceEuros() < b2.getPriceEuros() ? -1 : 0 ;
			});
	}
	
	public void sortById() {
		books.sort( 
			(Book b1, Book b2) -> {
				return b1.getId() > b2.getId() ? 
						1 : b1.getId() < b2.getId() ? -1 : 0 ;
			});
	}
	
	
}
