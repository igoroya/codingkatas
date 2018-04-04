package com.igoroya.codingkatas.march2018.comparablefun;

import static com.igoroya.codingkatas.march2018.comparablefun.BookshopUtils.*;


public class RunBookShop {

	public static void main(String[] args) {
		
		
		System.out.println("Welcome to the bookshop tests");
		
		BookShop myBookshop = new BookShop();

		myBookshop.addBook(new Book("Iliad", 1, 11.95f));
		myBookshop.addBook(new Book("Iliad", 1, 11.95f));
		myBookshop.addBook(new Book("Oddisey", 2, 12.95f));
		myBookshop.addBook(new Book("Iliad", 1, 8.50f, getOfferTag()));
		myBookshop.addBook(new Book("Yoda der Mops", 4, 14.50f, getNewTag()));
		myBookshop.addBook(new Book("The Universe", 5, 44.50f, getNewTag()));
		myBookshop.addBook(new Book("Yoda returns", 6, 7.50f, getNewTag()));
		myBookshop.addBook(new Book("Bonsai: definite guide", 7, 54.50f, getNewTag()));
	
		System.out.println("Books ordered as inserted");
		myBookshop.printBooks();
		
		System.out.println("Books sorted by Title");
		myBookshop.sortByName();
		myBookshop.printBooks();
		
		System.out.println("Books sorted by Price");
		myBookshop.sortByPrice();
		myBookshop.printBooks();
		
		System.out.println("Books sorted by Id");
		myBookshop.sortById();
		myBookshop.printBooks();

		System.out.print("\nBookShop analytics\n");
		BookShopAnalytics analitycs = new BookShopAnalytics(myBookshop.getBooks());
		analitycs.printNumberOfBooks();
		analitycs.printNumberOfUniqueBooks();
		analitycs.printUniqueBooks();
		analitycs.printTotalBooksCost();
		analitycs.printAverageBookPrice();

	
	}
	
}
