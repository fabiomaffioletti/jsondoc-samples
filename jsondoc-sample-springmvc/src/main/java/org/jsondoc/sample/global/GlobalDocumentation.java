package org.jsondoc.sample.global;

import org.jsondoc.core.annotation.global.ApiGlobal;
import org.jsondoc.core.annotation.global.ApiGlobalSection;

@ApiGlobal(
	sections = { 
		@ApiGlobalSection(
			title = "HTTP Verbs", 
			paragraphs = { "This is to demonstrate the use of paragraphs with simple html text and text coming from a file in the classpath", "/jsondocfile:/jsondoc/global-verbs.html"}
		),
		@ApiGlobalSection(
			title = "Authentication",
			paragraphs = { "/jsondocfile:/jsondoc/global-authentication.html" }
		),
		@ApiGlobalSection(
			title = "Headers",
			paragraphs = { "/jsondocfile:/jsondoc/global-headers.html" }
		),
		@ApiGlobalSection(
			title = "Status codes",
			paragraphs = { "/jsondocfile:/jsondoc/global-responsestatuscodes.html" }
		)
	}
)
public class GlobalDocumentation {

}
