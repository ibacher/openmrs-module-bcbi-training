/*
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.bcbitraining.metadata;

import static org.openmrs.api.ConceptNameType.*;
import static org.openmrs.module.bcbitraining.BCBITrainingConstants.*;
import static org.openmrs.module.bcbitraining.metadata.BCBIConceptBase.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import org.openmrs.api.ConceptNameType;
import org.openmrs.module.bcbitraining.descriptor.*;

public class BCBILabConcepts {
	
	private static final ConceptClassDescriptor TEST = new ConceptClassDescriptor() {
		
		@Override
		public String name() {
			return "Test";
		}
		
		@Override
		public String uuid() {
			return TEST_CLASS_UUID;
		}
	};
	
	private static abstract class LabConceptDescriptor extends ConceptDescriptor {
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return TEST;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NUMERIC;
		}
	}
	
	public static final ConceptDescriptor ANION_GAP = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Anion gap (mols/vol)";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Anion gap";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Serum anion gap";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "165555";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "1863-0";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "33037-3";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "165555AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor BACTERIA_URINE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Bacteria in urine sediment";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "165561";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5769-5";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "165561AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor BASOPHILS = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Basophils";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Basos";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1025";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "704-7";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return "Type of leukocyte, with coarse granules that stain blue when exposed to a basic dye. Basophils normally constitute 1% or less of the total white blood cell count but may increase or decrease in certain diseases.";
		}
		
		@Override
		public String uuid() {
			return "1025AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor BICARBONATE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Serum carbon dioxide";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return SERUM_CARBON_DIOXIDE_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Bicarbonate";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return BICARBONATE_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "CO2";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return CO2_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Serum CO2";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return SERUM_CO2_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1135";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "1963-8";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "34728-6";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "1135";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "SERUM CARBON DIOXIDE";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1135AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor BILIRUBIN_URINE = new LabConceptDescriptor() {
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return CODED;
		}
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Bilirubin total presence in urine by test strip";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Bilirubin dipstick test";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "163680";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5770-3";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "163680AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor BLOOD_URINE = new LabConceptDescriptor() {
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return CODED;
		}
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Urine dipstick for blood";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "162096";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5794-3";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "162096AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor CALCIUM = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Serum Calcium";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "CA";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "159497";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "2000-8";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "159497AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor CHLORIDE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Serum chloride";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Chloride";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "CL";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1134";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "2075-0";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1134AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor CK = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Creatine kinase";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "CK";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Creatinine Phosphokinase";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "CPK";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1011";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "2157-6";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1011AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor CREATINEINE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Serum creatinine";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Cr";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "164364";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "2160-0";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "164364AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor EOSINOPHILS = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Eosinophils";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Eos";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1024";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "711-2";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1024AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor EPITHELIAL_URINE = new LabConceptDescriptor() {
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return CODED;
		}
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Epithelial cells presence in urine sediment by light microscopy test";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Epi cells urine test";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "163685";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5787-7";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "163685AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor GLUCOSE_BLOOD = new LabConceptDescriptor() {
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return CODED;
		}
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Serum glucose";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Blood sugar";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Glu";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Glucose";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "887";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "2345-7";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "887AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor GLUCOSE_URINE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Glucose measurement, quantitative, urine";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Urine glucose";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "159733";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5792-7";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "159733AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor HEMATOCRIT = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Hematocrit";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return HEMATOCRIT_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "HCT";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return HCT_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1015";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "4544-3";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "1015";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "HEMATOCRIT";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1015AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor HEMOGLOBIN = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Haemonglobin";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "HGB";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Hemoglobin";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "21";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "718-7";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "21AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor INR = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "International normalized ration";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "INR";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "161482";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5895-7";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "161482AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor KETONE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Urine ketone test";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Ketone";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "161442";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5797-6";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "161442AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor LACTATE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Serum lactate";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Lactate";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Lactic acid";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1012";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "32693-4";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1012AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor LEUKOCYTES = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Leukocytes presence in urine sediment by light microscopy";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "White blood cells in urine";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "163684";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5799-2";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "163684AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor LYMPHOCYTES = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Lymphocytes in blood";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Lymphocytes";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "165558";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "731-0";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "165558AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor MAGNESIUM = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Serum magnesium measurement";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Magnesium";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "159643";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "2601-3";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "159643AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor MCH = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Mean corpuscular hemoglobin";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return MEAN_CORPUSCULAR_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "MCH";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return MCH_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1018";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "785-6";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "1018";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "MEAN CORPUSCULAR HEMOGLOBIN";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1018AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor MCHC = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Mean cell hemoglobin concentration";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return MEAN_CELL_HEMO_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "MCHC";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return MCHC_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1017";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "786-4";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "1017";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "MEAN CELL HEMOGLOBIN CONCENTRATION";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1017AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor MCV = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Mean corpuscular volume";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return MEAN_CORPUSCULAR_VOLUME_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "MCV";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return MCV_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "851";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "787-2";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "851";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "MEAN CORPUSCULAR VOLUME";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "851AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor MONOCTYES = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Monocytes";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1023";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "742-7";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1023AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor NEUTROPHILS = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Neutrophils";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return NEUTROPHILS_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Polymorphonuclear cells";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return POLYMORPHONUCLEAR_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "PMNS";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return PMNS_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1022";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "761-7";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "1022";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "NEUTROPHILS";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1022AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor NITRATE_URINE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Urine nitrite test";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "161440";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5802-4";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "161440AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor PH_BLOOD = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Serum pH measurement";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Blood pH";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "165176";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "11558-4";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "165176AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor PH_URINE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Urine pH";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "161438";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5803-2";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "161438AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor PHOSPHATE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Serum phosphorous";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Serum phosphate";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "161154";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "2777-1";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "161154AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor PLATELET_COUNT = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Platelets";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return PLATELETS_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Blood platelet";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return BLOOD_PLATELET_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Platelet count";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "729";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "777-3";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "729";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "PLATELETS";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "729AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor POTASSIUM = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Serum potassium";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return SERUM_POTASSIUM_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Potassium";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return POTASSIUM_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "K";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return K_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1133";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "2823-3";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "1133";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "SERUM POTASSIUM";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1133AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor PROTEIN_URINE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Urine protein (dip stick)";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Urine dipstick for protein";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1875";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5804-0";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1875AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor PT = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Prothrombin time";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "PT";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "161481";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5902-2";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "161481AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor PTT = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Partial thromboplastin time";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "PTT";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "161153";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "3173-2";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "161153AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor RBC_URINE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Erythrocytes presence in urine sediment by light microscopy test";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Red blood cells in urine test";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "RBC in urine";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "163683";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5808-1";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "163683AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor RDW = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Red cell distribution width";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return RED_CELL_DISTRIBUTION_WIDTH_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "RDW";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return RDW_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1016";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "788-0";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "1016";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "RED CELL DISTRIBUTION WIDTH";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1016AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor RBC = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Red blood cells";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return RED_BLOOD_CELLS_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "RBC";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return RBC_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "RBC count";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return RBC_COUNT_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "679";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "789-8";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "679";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "RED BLOOD CELLS";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "679AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor SODIUM = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Serum sodium";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return SERUM_SODIUM_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "NA";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return NA_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Sodium";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return SODIUM_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "1132";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "2951-2";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "1132";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "SERUM SODIUM";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "1132AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor SG_URINE = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Urine specific gravity";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "161439";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5811-5";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "161439AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor BUN = new LabConceptDescriptor() {
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Blood urea nitrogen";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return BLOOD_UREA_NITROGEN_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "BUN";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return BUN_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "857";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "3094-0";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "857";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "BLOOD UREA NITROGEN";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "857AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor URINE_APPEARANCE = new LabConceptDescriptor() {
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Urine turbidity";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Urine appearance";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "162101";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5767-9";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "162101AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor URINE_COLOR = new LabConceptDescriptor() {
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {

				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}

				@Override
				public String name() {
					return "Urine color";
				}

				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}

				@Override
				public String description() {
					return null;
				}

				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "162106";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5778-6";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "162106AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor WBC_URINE = new LabConceptDescriptor() {
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return CODED;
		}
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "WBC casts presence in urine sediment by light microscopy test";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Leukocyte casts urine test";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "163693";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5821-4";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "163693AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor WBC = new LabConceptDescriptor() {
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return CODED;
		}
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "White blood cells";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return WHITE_BLOOD_CELLS_NAME_UUID;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "WBC";
				}
				
				@Override
				public ConceptNameType nameType() {
					return SHORT;
				}
				
				@Override
				public String description() {
					return WBC_NAME_UUID;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Leukocyte count";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return LEUKOCYTE_COUNT_NAME_UUID;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "678";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "804-5";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "678";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return PIH;
						}
						
						@Override
						public String code() {
							return "WHITE BLOOD CELLS";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "678AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor YEAST = new LabConceptDescriptor() {
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return CODED;
		}
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Yeast presence in urine sediment by light microscopy";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			}, new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return false;
				}
				
				@Override
				public String name() {
					return "Yeast urine test";
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "163686";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5822-2";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "163686AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final ConceptDescriptor UROBILINOGEN = new LabConceptDescriptor() {
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return CODED;
		}
		
		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {
				
				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}
				
				@Override
				public boolean preferred() {
					return true;
				}
				
				@Override
				public String name() {
					return "Urobilinogen presence in urine test ";
				}
				
				@Override
				public ConceptNameType nameType() {
					return FULLY_SPECIFIED;
				}
				
				@Override
				public String description() {
					return null;
				}
				
				@Override
				public String uuid() {
					return null;
				}
			});
		}
		
		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Arrays.asList(new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "163682";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return LOINC;
						}
						
						@Override
						public String code() {
							return "5818-0";
						}
					};
				}
			});
		}
		
		@Override
		public String description() {
			return null;
		}
		
		@Override
		public String uuid() {
			return "163682AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};
	
	public static final Iterable<ConceptDescriptor> ALL_LABS = Arrays.asList(ANION_GAP, BACTERIA_URINE, BASOPHILS,
	    BICARBONATE, BILIRUBIN_URINE, BLOOD_URINE, CALCIUM, CHLORIDE, CK, CREATINEINE, EOSINOPHILS, EPITHELIAL_URINE,
	    GLUCOSE_BLOOD, GLUCOSE_URINE, HEMATOCRIT, HEMOGLOBIN, INR, KETONE, LACTATE, LEUKOCYTES, LYMPHOCYTES, MAGNESIUM, MCH,
	    MCHC, MCV, MONOCTYES, NEUTROPHILS, NITRATE_URINE, PH_BLOOD, PH_URINE, PHOSPHATE, PLATELET_COUNT, POTASSIUM,
	    PROTEIN_URINE, PT, PTT, RBC, RBC_URINE, RDW, SODIUM, SG_URINE, BUN, URINE_APPEARANCE, URINE_COLOR, UROBILINOGEN,
	    WBC, WBC_URINE, YEAST);
	
}
