package com.kh.searchfree.member.model.vo;

import oracle.sql.CLOB;


public class ProfileResource {
	private int memberNo;
	private String profileResourcePath;
	private char profileResourceDeleteYN;
	private String fileOriginName;
	private String fileChangeName;
	private String content;
	private String title;
	
public ProfileResource() {
	// TODO Auto-generated constructor stub
}

public ProfileResource(int memberNo, String profileResourcePath, char profileResourceDeleteYN, String fileOriginName,
		String fileChangeName, String content, String title) {
	super();
	this.memberNo = memberNo;
	this.profileResourcePath = profileResourcePath;
	this.profileResourceDeleteYN = profileResourceDeleteYN;
	this.fileOriginName = fileOriginName;
	this.fileChangeName = fileChangeName;
	this.content = content;
	this.title = title;
}



public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public int getMemberNo() {
	return memberNo;
}

public void setMemberNo(int memberNo) {
	this.memberNo = memberNo;
}

public String getProfileResourcePath() {
	return profileResourcePath;
}

public void setProfileResourcePath(String profileResourcePath) {
	this.profileResourcePath = profileResourcePath;
}

public char getProfileResourceDeleteYN() {
	return profileResourceDeleteYN;
}

public void setProfileResourceDeleteYN(char profileResourceDeleteYN) {
	this.profileResourceDeleteYN = profileResourceDeleteYN;
}

public String getFileOriginName() {
	return fileOriginName;
}

public void setFileOriginName(String fileOriginName) {
	this.fileOriginName = fileOriginName;
}

public String getFileChangeName() {
	return fileChangeName;
}

public void setFileChangeName(String fileChangeName) {
	this.fileChangeName = fileChangeName;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

@Override
public String toString() {
	return "ProfileResource [memberNo=" + memberNo + ", profileResourcePath=" + profileResourcePath
			+ ", profileResourceDeleteYN=" + profileResourceDeleteYN + ", fileOriginName=" + fileOriginName
			+ ", fileChangeName=" + fileChangeName + ", content=" + content + ", title=" + title + "]";
}




}