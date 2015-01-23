package org.jsondoc.sample.spark.jsondoc;

import static spark.Spark.get;

import java.util.List;

import org.jsondoc.core.scanner.DefaultJSONDocScanner;
import org.jsondoc.core.scanner.JSONDocScanner;

import spark.Request;
import spark.Response;
import spark.Route;

import com.google.gson.Gson;

public class JSONDocController {

	public static void registerJSONDocRoute(final String version, final String basePath, final List<String> packages, final Gson gson) {
		get(new Route("/jsondoc") {
			@Override
			public Object handle(Request request, Response response) {
				JSONDocScanner jsondocScanner = new DefaultJSONDocScanner();
				return gson.toJson(jsondocScanner.getJSONDoc(version, basePath, packages));
			}
		});
	}

}
