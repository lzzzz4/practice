package cn.dubidubi.model;

import java.time.LocalDateTime;

public class User {
	private String username;
	private LocalDateTime dateTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", dateTime=" + dateTime + "]";
	}

}
