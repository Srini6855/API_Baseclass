package com.omrbranch.baseclass;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Baseclass {
	RequestSpecification requestSpec;
	Response response;

	public void addHeader(String key, String value) {
		requestSpec = RestAssured.given().header(key, value);
	}

	public void addRequestBody(String body) {
		requestSpec = requestSpec.body(body);
	}

	public Response addReqType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = requestSpec.get(endpoint);
			break;
		case "POST":
			response = requestSpec.post(endpoint);
			break;
		case "PATCH":
			response = requestSpec.patch(endpoint);
			break;
		case "PUT":
			response = requestSpec.put(endpoint);
			break;
		case "DELETE":
			response = requestSpec.delete(endpoint);
			break;

		default:
			break;
		}
		return response;
	}

	public int getResStatusCode() {
		return response.statusCode();
	}

	public String getResponseBodyAsString() {
		return response.asString();
	}

	public String getResponseBodyAsPrettyString() {
		return response.asPrettyString();
	}

}
