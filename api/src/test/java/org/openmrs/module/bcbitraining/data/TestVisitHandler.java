package org.openmrs.module.bcbitraining.data;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;
import org.openmrs.module.bcbitraining.descriptor.data.EncounterDescriptor;
import org.openmrs.module.bcbitraining.descriptor.data.VisitDescriptor;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class TestVisitHandler extends RecordHandlerTest<VisitHandler> {

	@Test
	public void getVisits_shouldLoadVisitFromFile() throws IOException {
		Iterable<VisitDescriptor> visits = handler.getVisits("data/testVisit.json");
		assertThat(visits, notNullValue());
		VisitDescriptor visit = visits.iterator().next();
		assertThat(visit, notNullValue());
		assertThat(visit.getStartDateTime(), equalTo(
				Date.from(LocalDateTime.of(2019, 1, 1, 12, 35).atZone(
						ZoneId.systemDefault()).toInstant())));
		assertThat(visit.getStopDateTime(), equalTo(
				Date.from(LocalDateTime.of(2019, 1, 1, 14, 35).atZone(
						ZoneId.systemDefault()).toInstant())));
	}

	@Test
	public void getVisits_shouldLoadVisitWithEmbeddedLocation() throws IOException {
		Iterable<VisitDescriptor> visits = handler.getVisits("data/testVisitWithLocation.json");
		assertThat(visits, notNullValue());
		VisitDescriptor visit = visits.iterator().next();
		assertThat(visit, notNullValue());
		assertThat(visit.getLocation().getUuid(), notNullValue());
	}

	@Test
	public void getVisits_shouldLoadVisitWithEmbeddedPatient() throws IOException {
		Iterable<VisitDescriptor> visits = handler.getVisits("data/testVisitWithPatient.json");
		assertThat(visits, notNullValue());
		VisitDescriptor visit = visits.iterator().next();
		assertThat(visit, notNullValue());
		assertThat(visit.getPatient().getUuid(), notNullValue());
	}

	@Test
	public void getVisits_shouldLoadVisitWithEncounters() throws IOException {
		Iterable<VisitDescriptor> visits = handler.getVisits("data/testVisitWithEncounter.json");
		assertThat(visits, notNullValue());
		VisitDescriptor visit = visits.iterator().next();
		assertThat(visit, notNullValue());
		Iterable<EncounterDescriptor> encounters = visit.getEncounters();
		assertThat(encounters, notNullValue());
		EncounterDescriptor encounter = encounters.iterator().next();
		assertThat(encounter, notNullValue());
		assertThat(encounter.getUuid(), notNullValue());
	}

	@Test
	public void getVisits_shouldLoadMultipleVisits() throws IOException {
		Iterable<VisitDescriptor> visits = handler.getVisits("data/testVisits.json");
		assertThat(visits, notNullValue());
		Iterator<VisitDescriptor> iterator = visits.iterator();
		assertThat(iterator.next(), notNullValue());
		assertThat(iterator.hasNext(), is(true));
		assertThat(iterator.next(), notNullValue());
	}

	@Test
	public void getVisits_shouldReturnEmptyIterableWhenFileHasBeenProcessed() throws IOException {
		setupHandlerWithRecordFor("data/testVisit.json");
		Iterable<VisitDescriptor> visits = handler.getVisits("data/testVisit.json");
		assertThat(visits, notNullValue());
		assertThat(visits.iterator().hasNext(), is(false));
	}

	@Test(expected = IllegalArgumentException.class)
	public void getVisits_shouldThrowExceptionWhenFileNull() throws IOException {
		handler.getVisits(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getVisits_shouldThrowExceptionWhenFileEmpty() throws IOException {
		handler.getVisits("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void getVisits_shouldThrowExceptionWhenFileBlank() throws IOException {
		handler.getVisits("        ");
	}

	@Test(expected = FileNotFoundException.class)
	public void getVisits_shouldThrowExceptionWhenFileDoesntExist() throws IOException {
		handler.getVisits("noSuchFile.json");
	}

	@Test(expected = IOException.class)
	public void getVisits_shouldThrowExceptionWhenFileIsEmpty() throws IOException {
		handler.getVisits("data/emptyFile.json");
	}

	@Test(expected = IOException.class)
	public void getVisits_shouldThrowExceptionWhenFileIsMalformed() throws IOException {
		handler.getVisits("data/badJson.json");
	}

}
