package vo;

import org.springframework.web.multipart.MultipartFile;

// /upload2.do?title=����&photo=a.jpg

public class PhotoVo {

	String title;
	
	String filename;
	
	//ȭ���������� ����
	MultipartFile photo;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	
	
	
}
