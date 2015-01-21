package org.example.shelf.flow;

import org.jsondoc.core.annotation.ApiFlow;
import org.jsondoc.core.annotation.ApiFlowSet;
import org.jsondoc.core.annotation.ApiFlowStep;

@ApiFlowSet
public class ShelfFlows {

	@ApiFlow(
		name = "Author detail flow",
		description = "Gets an author's details starting from the book's list",
		steps = {
			@ApiFlowStep(apimethodid = ShelfFlowConstants.BOOK_FIND_ALL),	
			@ApiFlowStep(apimethodid = ShelfFlowConstants.BOOK_FIND_ONE),	
			@ApiFlowStep(apimethodid = ShelfFlowConstants.AUTHOR_FIND_ONE)	
		}
	)
	public void authorDetailFlow() {

	}

}
