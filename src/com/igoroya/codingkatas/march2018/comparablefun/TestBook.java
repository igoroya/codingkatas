package com.igoroya.codingkatas.march2018.comparablefun;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBook {
	private Book book1;
	private Book book2;
	private Book book3;
	private Book book4;
	
	
	@BeforeEach
	void setUp() throws Exception {
		book1 = new Book("Iliad", 1, 11.95f);
		book2 = new Book("Iliad", 1, 11.95f);
		book3 = new Book("Oddisey", 2, 12.95f);
		book4 = new Book("Iliad", 2, 8.50f, new BookTag[] {BookTag.NEW});
	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHashCode() {
		assertEquals(book1.hashCode(), book2.hashCode());
		assertNotEquals(book1.hashCode(), book3.hashCode());
		assertNotEquals(book1.hashCode(), book4.hashCode());
	}

	@Test
	void testEquals() {
		assertTrue(book1.equals(book1));
		assertTrue(book1.equals(book2));
		assertTrue(book2.equals(book1));
		assertFalse(book1.equals(book4));
		assertFalse(book1.equals(book3));
		assertFalse(book1.equals(null));
		assertFalse(book1.equals("nono"));
	}

	@Test
	void testGetId() {
		assertEquals(book1.getId(), 1);
	}

	@Test
	void testGetTitle() {
		assertEquals(book1.getTitle(), "Iliad");
	}

	@Test
	void testGetPriceEuros() {
		assertEquals(book1.getPriceEuros(), 11.95f);
	}
	
	@Test
	void testTag() {
		assertEquals(book1.getTag()[0], BookTag.NONE);
		assertEquals(book4.getTag()[0], BookTag.NEW);
	}

	@Test
	void testCompareTo() {
		assertEquals(0, book1.compareTo(book1));
		assertEquals(0, book1.compareTo(book2));
		assertEquals(0, book2.compareTo(book1));
		assertTrue(book1.compareTo(book3) < 0);
		assertTrue(book3.compareTo(book1) > 0);		
		assertEquals(0, book1.compareTo(book4));
		}

}
