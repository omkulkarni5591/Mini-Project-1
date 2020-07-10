package com.oksoft.binding;

import java.util.Date;

import lombok.Data;

@Data
public class Contact {
  
	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private Date createdDate;
	private Date updatedDate;
}
