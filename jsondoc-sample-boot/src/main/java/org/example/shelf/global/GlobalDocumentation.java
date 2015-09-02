package org.example.shelf.global;

import org.jsondoc.core.annotation.global.ApiGlobal;
import org.jsondoc.core.annotation.global.ApiGlobalSection;

@ApiGlobal(
	sections = { 
		@ApiGlobalSection(
			title = "HTTP Verbs", 
			paragraphs = { "HTTP Verbs paragraph 1", "HTTP Verbs paragraph 2", "/jsondocfile./src/main/resources/jsondoc/global-verbs.html", "HTTP Verbs paragraph 3" }
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
