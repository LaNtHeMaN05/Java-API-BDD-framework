package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	static RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	String sysDirec = System.getProperty("user.dir");
	FileInputStream fis;
	Properties prop;
	PrintStream log;

	public RequestSpecification reqSpecificationFunction() throws IOException {
		fis = new FileInputStream(sysDirec + "\\src\\main\\java\\resources\\data.properties");
		prop = new Properties();
		prop.load(fis);

		if (reqSpec == null) {
			log = new PrintStream(new FileOutputStream("logs.txt"));
			String placeUri = prop.getProperty("PlaceUri");
			reqSpec = new RequestSpecBuilder().setBaseUri(placeUri).setContentType(ContentType.JSON)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log)).addQueryParam("key", "qaclick123").build();
			return reqSpec;
		}
		return reqSpec;

	}

	public ResponseSpecification resSpecificationFunction() {
		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		return resSpec;
	}

}
