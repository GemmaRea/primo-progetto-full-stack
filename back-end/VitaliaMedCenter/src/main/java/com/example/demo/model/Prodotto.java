package com.example.demo.model;

public class Prodotto {
 private int id;
 private String url;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public Prodotto(int id, String url) {
	
	this.id = id;
	this.url = url;
}
public Prodotto() {

}

}
