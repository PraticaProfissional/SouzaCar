package br.com.souzacar.utlis;

import org.springframework.stereotype.Component;

@Component
public class Response {

	public Object data;
	public Status status;

	public Response() {
		super();
	}

	public Response(Object data, Status status) {
		this.data = data;

		if (null == status) {
			this.status = new Status();
			this.status.code = 200;
		}
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(int code, String message) {
		this.status = new Status();
		this.status.code = code;
		this.status.message = message;
	}
}