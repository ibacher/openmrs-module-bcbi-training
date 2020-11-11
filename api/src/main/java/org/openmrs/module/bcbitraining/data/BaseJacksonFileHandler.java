package org.openmrs.module.bcbitraining.data;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.openmrs.module.bcbitraining.descriptor.data.*;
import org.openmrs.module.bcbitraining.descriptor.data.mixins.*;

@Slf4j(topic = "org.openmrs.api")
public abstract class BaseJacksonFileHandler extends BaseHandler {

	private final ObjectMapper objectMapper;
	
	BaseJacksonFileHandler() {
		objectMapper = new ObjectMapper();
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
		objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		objectMapper.configure(JsonParser.Feature.ALLOW_TRAILING_COMMA, true);
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		objectMapper.addMixIn(VisitDescriptor.class, VisitMixin.class);
		objectMapper.addMixIn(EncounterDescriptor.class, EncounterMixin.class);
		objectMapper.addMixIn(PatientDescriptor.class, PatientMixin.class);
		objectMapper.addMixIn(OrderDescriptor.class, OrderMixin.class);
		objectMapper.addMixIn(ProviderDescriptor.class, ProviderMixin.class);
		objectMapper.addMixIn(ObsDescriptor.class, ObsMixin.class);
	}

	<T> T getRecordFromFile(String file, Class<T> rootType) throws IOException {
		try (InputStream is = loadFile(file)) {
			if (hasFileBeenSeen(file)) {
				return null;
			}

			return objectMapper.readValue(is, rootType);
		}
	}
	
}
