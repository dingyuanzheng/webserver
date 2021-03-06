package upload.bean;

import java.io.Serializable;

public class FileInfo implements Serializable{
	
	private String url;
	private long size;
	private String name;
	private long updatedAt;
	private String group;
	private String version;

	
	
	public String getGroup() {
		return group;
	}

	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setGroup(String group) {
		this.group = group;
	}


	public long getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(long updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public long getSize() {
		return size;
	}


	public void setSize(long size) {
		this.size = size;
	}
	
	
}
