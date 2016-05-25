package ug.lab.Proj160520.Models;

public class Book {

	private int id_book;
	private String Title;
	private int Year;

	public Book(int id, String title, int year) {
		this.id_book = id;
		this.Title = title;
		this.Year = year;
	}

	public int getId_book() {
		return id_book;
	}

	public void setId_book(int id_book) {
		this.id_book = id_book;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}
}
