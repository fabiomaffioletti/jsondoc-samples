package org.jsondoc.sample.global;

import org.jsondoc.core.annotation.global.ApiGlobal;
import org.jsondoc.core.annotation.global.ApiGlobalSection;

@ApiGlobal(
	sections = { 
		@ApiGlobalSection(
			title = "HTTP Verbs", 
			paragraphs = { "This is to demonstrate the use of paragraphs with simple html text and text coming from a file in the classpath", "/jsondocfile./src/main/resources/jsondoc/global-verbs.html"}
		),
		@ApiGlobalSection(
			title = "Authentication",
			paragraphs = { "/jsondocfile./src/main/resources/jsondoc/global-authentication.html" }
		),
		@ApiGlobalSection(
			title = "Headers",
			paragraphs = { "/jsondocfile./src/main/resources/jsondoc/global-headers.html" }
		),
		@ApiGlobalSection(
			title = "Status codes",
			paragraphs = { "/jsondocfile./src/main/resources/jsondoc/global-responsestatuscodes.html" }
		)
	}
)
public class GlobalDocumentation {

}
