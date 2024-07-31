package GameBack;

public class game {
private String name;
private String date;
private String intro;
private String image;
private String type;
public game(String name, String date, String intro, String image) {
	super();
	this.name = name;
	this.date = date;
	this.intro = intro;
	this.image = image;
}

public game(String name, String date, String intro, String image, String type) {
	super();
	this.name = name;
	this.date = date;
	this.intro = intro;
	this.image = image;
	this.type = type;
}

public game() {
	super();
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getIntro() {
	return intro;
}
public void setIntro(String intro) {
	this.intro = intro;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

}
