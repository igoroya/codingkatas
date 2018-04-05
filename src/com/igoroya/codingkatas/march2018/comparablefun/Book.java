package com.igoroya.codingkatas.march2018.comparablefun;

public class Book implements Comparable<Book> {

	private final int id;
	private final String title;
	private final float priceEuros;
	private final BookTag[] tags;
	
	public Book(String title, int id, float priceEuros, BookTag[] tags) {
		this.title = title;
		this.id = id;
		this.priceEuros = priceEuros;
		this.tags = tags;

	}
		
	public Book(String title, int id, float priceEuros) {
		this.title = title;
		this.id = id;
		this.priceEuros = priceEuros;
		this.tags = new BookTag[]{BookTag.NONE};
	}
	
	//TODO: Add a factory to get a new book item when we apply a new tag
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	/**
	 * 	 Two books are equal if they have Same title and ID, irrespective of price and tag
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (!title.equals(other.title))
			return false;
		return true;
	}

	public BookTag[] getTag() {
		return tags;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public float getPriceEuros() {
		return priceEuros;
	}

	
	
	
	/**
	 * Natural order is alphabetical in Book
	 */
	@Override
	public int compareTo(Book other) {
		return this.title.toLowerCase().compareTo(other.title.toLowerCase());				
	}

	@Override
	public String toString() {
		String tagsString = "";
		for (BookTag tag: tags) { 
			if (!tagsString.equals(""))
				tagsString+=", ";
			tagsString+=tag.toString();
		}
			
		
		return "| Title: " + title +  " |  id: "  + id + " |  price (Euro): " +  priceEuros + " |  tags: " +  tagsString + " |";
	}
	
}
