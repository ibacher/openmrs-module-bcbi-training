package org.openmrs.module.bcbitraining.data;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;

import lombok.Setter;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.lang3.StringUtils;
import org.openmrs.module.bcbitraining.api.BCBIDataRecordService;
import org.openmrs.util.OpenmrsClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseHandler {

	@Autowired
	@Setter
	BCBIDataRecordService dataRecordService;

	InputStream loadFile(String file) throws FileNotFoundException {
		if (StringUtils.isBlank(file)) {
			throw new IllegalArgumentException("file cannot be null or empty");
		}

		BufferedInputStream bis;
		File visitsFile = new File(file);
		if (visitsFile.exists() && visitsFile.canRead()) {
			bis = new BufferedInputStream(new BOMInputStream(new FileInputStream(file)));
		} else {
			try {
				bis = new BufferedInputStream(new BOMInputStream(Objects.requireNonNull(
						OpenmrsClassLoader.getSystemResourceAsStream(file))));
			}
			catch (NullPointerException e) {
				throw new FileNotFoundException("Could not find file " + file + " on classpath");
			}
		}

		return bis;
	}

	boolean hasFileBeenSeen(String file) {
		return dataRecordService.hasFileBeenSeen(file);
	}

	void saveDataRecord(String file) {
		dataRecordService.saveDataRecord(file);
	}

}
