package org.example.shelf.documentation.global;

import org.jsondoc.core.annotation.global.ApiGlobal;
import org.jsondoc.core.annotation.global.ApiGlobalSection;

@ApiGlobal(
	sections = { 
		@ApiGlobalSection(
			title = "HTTP Verbs", 
			paragraphs = { "HTTP Verbs paragraph 1", "HTTP Verbs paragraph 2", "/jsondocfile:/jsondoc/global-verbs.html", "HTTP Verbs paragraph 3" }
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
