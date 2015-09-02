package org.jsondoc.sample.global;

import org.jsondoc.core.annotation.global.ApiMigration;
import org.jsondoc.core.annotation.global.ApiMigrationSet;

@ApiMigrationSet(
	migrations = { 
		@ApiMigration(fromversion = "1.1", steps = { "Step #3" }, toversion = "2.0"),
		@ApiMigration(fromversion = "1.0", steps = { "Step #1", "Step #2" }, toversion = "1.1")
	}
)
public class MigrationDocumentation {

}
