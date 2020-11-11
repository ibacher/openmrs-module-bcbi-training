package org.openmrs.module.bcbitraining.data;

import java.io.IOException;
import java.util.Collections;

import org.openmrs.module.bcbitraining.descriptor.data.EncounterContainerDescriptor;
import org.openmrs.module.bcbitraining.descriptor.data.EncounterDescriptor;

public class EncounterHandler extends BaseJacksonFileHandler {

	public Iterable<EncounterDescriptor> getEncounters(String file) throws IOException {
		EncounterContainerDescriptor result = getRecordFromFile(file, EncounterContainerDescriptor.class);
		if (result == null) {
			return Collections.emptyList();
		}

		saveDataRecord(file);

		return result.getEncounters();
	}

}
