package org.jsondoc.sample.flow;

import org.jsondoc.core.annotation.flow.ApiFlow;
import org.jsondoc.core.annotation.flow.ApiFlowSet;
import org.jsondoc.core.annotation.flow.ApiFlowStep;

@ApiFlowSet
public class BookFlows {
	
	@ApiFlow(
			name = "Book purchase flow",
			description = "The flow for purchasing a book",
			preconditions = {
					"To purchase a book there must be an existing user",
					"The user must have an account with username and password",
					"The user must have the role needed to purchase books"
			},
			steps = {
				@ApiFlowStep(apimethodid = FlowConstants.USER_LOGIN_METHOD_ID),
				@ApiFlowStep(apimethodid = FlowConstants.BOOK_LIST_METHOD_ID),
				@ApiFlowStep(apimethodid = FlowConstants.BOOK_OBJECT_METHOD_ID),
				@ApiFlowStep(apimethodid = FlowConstants.BOOK_PURCHASE_METHOD_ID)
			}
		)
	public void bookPurchaseFlow() {
		
	}
	
	@ApiFlow(
			name = "Similar books flow",
			description = "The flow for getting books similar to a given book",
			steps = {
				@ApiFlowStep(apimethodid = FlowConstants.BOOK_OBJECT_METHOD_ID),
				@ApiFlowStep(apimethodid = FlowConstants.BOOK_SIMILAR_METHOD_ID)
			}
		)
	public void similarBooksFlow() {
		
	}

}
