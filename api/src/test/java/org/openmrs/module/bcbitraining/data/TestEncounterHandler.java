package org.openmrs.module.bcbitraining.data;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;
import org.openmrs.module.bcbitraining.descriptor.data.EncounterDescriptor;

public class TestEncounterHandler extends RecordHandlerTest<EncounterHandler> {

	@Test
	public void getEncounters_shouldLoadEncountersFromFile() throws IOException {
		Iterable<EncounterDescriptor> encounters = handler.getEncounters("data/testEncounter.json");
		assertThat(encounters, notNullValue());
		EncounterDescriptor encounter = encounters.iterator().next();
		assertThat(encounter, notNullValue());
		assertThat(encounter.getUuid(), notNullValue());
		assertThat(encounter.getEncounterTypeUuid(), notNullValue());
		assertThat(encounter.getDateTime(), equalTo(
				Date.from(LocalDateTime.of(2019, 1, 1, 12, 35).atZone(
						ZoneId.systemDefault()).toInstant())));
	}

	@Test
	public void getEncounters_shouldLoadEncounterWithEmbeddedLocation() throws IOException {
		Iterable<EncounterDescriptor> encounters = handler.getEncounters("data/testEncounterWithLocation.json");
		assertThat(encounters, notNullValue());
		EncounterDescriptor encounter = encounters.iterator().next();
		assertThat(encounter, notNullValue());
		assertThat(encounter.getLocation().getUuid(), notNullValue());
	}

	@Test
	public void getEncounters_shouldLoadEncounterWithEmbeddedPatient() throws IOException {
		Iterable<EncounterDescriptor> encounters = handler.getEncounters("data/testEncounterWithPatient.json");
		assertThat(encounters, notNullValue());
		EncounterDescriptor encounter = encounters.iterator().next();
		assertThat(encounter, notNullValue());
		assertThat(encounter.getPatient().getUuid(), notNullValue());
	}

	@Test
	public void getEncounters_shouldLoadEncounterWithEmbeddedForm() throws IOException {
		Iterable<EncounterDescriptor> encounters = handler.getEncounters("data/testEncounterWithForm.json");
		assertThat(encounters, notNullValue());
		EncounterDescriptor encounter = encounters.iterator().next();
		assertThat(encounter, notNullValue());
		assertThat(encounter.getForm().getUuid(), notNullValue());
	}

	@Test
	public void getEncounters_shouldLoadEncounterWithOrder() throws IOException {
		Iterable<EncounterDescriptor> encounters = handler.getEncounters("data/testEncounterWithOrder.json");
		assertThat(encounters, notNullValue());
		EncounterDescriptor encounter = encounters.iterator().next();
		assertThat(encounter, notNullValue());
		assertThat(encounter.getOrders(), notNullValue());
		assertThat(encounter.getOrders().size(), equalTo(1));
		assertThat(encounter.getOrders().get(0).getUuid(), notNullValue());
	}

	@Test
	public void getEncounters_shouldLoadEncounterWithObs() throws IOException {
		Iterable<EncounterDescriptor> encounters = handler.getEncounters("data/testEncounterWithObs.json");
		assertThat(encounters, notNullValue());
		EncounterDescriptor encounter = encounters.iterator().next();
		assertThat(encounter, notNullValue());
		assertThat(encounter.getObs(), notNullValue());
		assertThat(encounter.getObs().size(), equalTo(1));
		assertThat(encounter.getObs().get(0).getUuid(), notNullValue());
	}

	@Test
	public void getEncounters_shouldLoadEncounterWithProvider() throws IOException {
		Iterable<EncounterDescriptor> encounters = handler.getEncounters("data/testEncounterWithProvider.json");
		assertThat(encounters, notNullValue());
		EncounterDescriptor encounter = encounters.iterator().next();
		assertThat(encounter, notNullValue());
		assertThat(encounter.getProviders(), notNullValue());
		assertThat(encounter.getProviders().size(), equalTo(1));
		assertThat(encounter.getProviders().get(0), notNullValue());
	}

	@Test
	public void getEncounters_shouldLoadMultipleEncounters() throws IOException {
		Iterable<EncounterDescriptor> encounters = handler.getEncounters("data/testEncounters.json");
		assertThat(encounters, notNullValue());
		Iterator<EncounterDescriptor> iterator = encounters.iterator();
		assertThat(iterator.next(), notNullValue());
		assertThat(iterator.hasNext(), is(true));
		assertThat(iterator.next(), notNullValue());
	}

	@Test
	public void getEncounters_shouldReturnEmptyIterableWhenFileHasBeenProcessed() throws IOException {
		setupHandlerWithRecordFor("data/testEncounter.json");
		Iterable<EncounterDescriptor> encounters = handler.getEncounters("data/testEncounter.json");
		assertThat(encounters, notNullValue());
		assertThat(encounters.iterator().hasNext(), is(false));
	}

	@Test(expected = IllegalArgumentException.class)
	public void getEncounters_shouldThrowExceptionWhenFileNull() throws IOException {
		handler.getEncounters(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void getEncounters_shouldThrowExceptionWhenFileEmpty() throws IOException {
		handler.getEncounters("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void getEncounters_shouldThrowExceptionWhenFileBlank() throws IOException {
		handler.getEncounters("        ");
	}

	@Test(expected = FileNotFoundException.class)
	public void getEncounters_shouldThrowExceptionWhenFileDoesntExist() throws IOException {
		handler.getEncounters("noSuchFile.json");
	}

	@Test(expected = IOException.class)
	public void getEncounters_shouldThrowExceptionWhenFileIsEmpty() throws IOException {
		handler.getEncounters("data/emptyFile.json");
	}

	@Test(expected = IOException.class)
	public void getEncounters_shouldThrowExceptionWhenFileIsMalformed() throws IOException {
		handler.getEncounters("data/badJson.json");
	}

}
