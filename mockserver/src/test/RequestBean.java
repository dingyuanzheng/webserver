package test;

import java.io.Serializable;

public class RequestBean implements Serializable {

	private String access_token;
	private String wallet_id;
	private String account_number;
	public RequestBean(String access_token, String wallet_id,
			String account_number) {
		super();
		this.access_token = access_token;
		this.wallet_id = wallet_id;
		this.account_number = account_number;
	}
	
	
	
}
