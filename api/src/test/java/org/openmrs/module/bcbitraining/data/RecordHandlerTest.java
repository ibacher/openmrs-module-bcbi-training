package org.openmrs.module.bcbitraining.data;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

import net.jodah.typetools.TypeResolver;
import org.junit.Before;
import org.openmrs.module.bcbitraining.BCBIDataRecord;
import org.openmrs.module.bcbitraining.api.BCBIDataRecordService;

public abstract class RecordHandlerTest<T extends BaseHandler> {

	T handler;

	@Before
	public void setup() throws IllegalAccessException, InstantiationException {
		Class<T> clazz = (Class<T>) TypeResolver.resolveRawArgument(RecordHandlerTest.class, getClass());
		this.handler = clazz.newInstance();

		BCBIDataRecordService dataRecordService = mock(BCBIDataRecordService.class);
		when(dataRecordService.getDataRecordByFile(anyString())).thenReturn(null);
		when(dataRecordService.saveDataRecord(any(BCBIDataRecord.class))).thenReturn(null);
		handler.setDataRecordService(dataRecordService);
	}

	public void setupHandlerWithRecordFor(String file) throws IOException {
		BCBIDataRecordService dataRecordService = mock(BCBIDataRecordService.class);
		when(dataRecordService.hasFileBeenSeen(file)).thenReturn(true);
		handler.setDataRecordService(dataRecordService);
	}

}
