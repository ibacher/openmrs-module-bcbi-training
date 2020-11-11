package org.openmrs.module.bcbitraining.data;

import java.io.IOException;
import java.util.Collections;

import org.openmrs.module.bcbitraining.descriptor.data.VisitContainerDescriptor;
import org.openmrs.module.bcbitraining.descriptor.data.VisitDescriptor;

public class VisitHandler extends BaseJacksonFileHandler {

	public Iterable<VisitDescriptor> getVisits(String file) throws IOException {
		VisitContainerDescriptor result = getRecordFromFile(file, VisitContainerDescriptor.class);

		if (result == null) {
			return Collections.emptyList();
		}

		saveDataRecord(file);

		return result.getVisits();
	}

}
