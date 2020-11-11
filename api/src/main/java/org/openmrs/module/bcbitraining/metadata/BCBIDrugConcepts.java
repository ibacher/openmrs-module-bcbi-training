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

import static org.openmrs.api.ConceptNameType.FULLY_SPECIFIED;
import static org.openmrs.module.bcbitraining.BCBITrainingConstants.ACETYLSALICYCLIC_ACID_NAME_UUID;
import static org.openmrs.module.bcbitraining.BCBITrainingConstants.ASPIRIN_NAME_UUID;
import static org.openmrs.module.bcbitraining.BCBITrainingConstants.DRUG_CLASS_UUID;
import static org.openmrs.module.bcbitraining.BCBITrainingConstants.FAMOTIDINE_NAME_UUID;
import static org.openmrs.module.bcbitraining.metadata.BCBIConceptBase.CIEL;
import static org.openmrs.module.bcbitraining.metadata.BCBIConceptBase.NA;
import static org.openmrs.module.bcbitraining.metadata.BCBIConceptBase.PIH;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import org.openmrs.api.ConceptNameType;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptClassDescriptor;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptDatatypeDescriptor;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptDescriptor;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptMapDescriptor;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptNameDescriptor;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptReferenceDescriptor;
import org.openmrs.module.bcbitraining.descriptor.mds.ConceptSourceDescriptor;

public class BCBIDrugConcepts {

	public static final ConceptDescriptor ACETAMINOPHEN = new DrugConceptDescriptor() {

		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Acetaminophen";
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
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}
			}, new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Paracetamol";
				}

				@Override
				public String description() {
					return null;
				}

				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return false;
				}
			}, new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Tylenol";
				}

				@Override
				public String description() {
					return null;
				}

				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return false;
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
							return "70116";
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
							return "Paracetamol";
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
							return "89";
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
			return "70116AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};

	public static final ConceptDescriptor ABUTEROL = new DrugConceptDescriptor() {

		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Abuterol Sulfate";
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
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}
			}, new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Salbutamol Sulfate";
				}

				@Override
				public String description() {
					return null;
				}

				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return false;
				}
			});
		}

		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Collections.singletonList(new ConceptMapDescriptor() {

				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {

						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}

						@Override
						public String code() {
							return "70461";
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
			return "70461AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};

	public static final ConceptDescriptor ASPIRIN = new DrugConceptDescriptor() {

		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return ASPIRIN_NAME_UUID;
				}

				@Override
				public String name() {
					return "Aspirin";
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
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}
			}, new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return ACETYLSALICYCLIC_ACID_NAME_UUID;
				}

				@Override
				public String name() {
					return "Acetylsalicyclic Acid";
				}

				@Override
				public String description() {
					return null;
				}

				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return false;
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
							return "71617";
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
							return "ASPIRIN";
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
							return "88";
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
			return "71617AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};

	public static final ConceptDescriptor FAMOTIDINE = new DrugConceptDescriptor() {

		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return FAMOTIDINE_NAME_UUID;
				}

				@Override
				public String name() {
					return "Famotidine";
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
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}
			}, new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Pepcid";
				}

				@Override
				public String description() {
					return null;
				}

				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return false;
				}
			});
		}

		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Collections.singletonList(new ConceptMapDescriptor() {

				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {

						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}

						@Override
						public String code() {
							return "76178";
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
			return "76178AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};

	public static final ConceptDescriptor LORAZEPAM = new DrugConceptDescriptor() {

		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Lorezepam";
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
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}
			});
		}

		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Collections.singletonList(new ConceptMapDescriptor() {

				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {

						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}

						@Override
						public String code() {
							return "79054";
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
			return "79054AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};

	public static final ConceptDescriptor NOREPINEPHRINE = new DrugConceptDescriptor() {

		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Norepinephrine";
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
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}
			}, new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Noradrenaline";
				}

				@Override
				public String description() {
					return null;
				}

				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return false;
				}
			});
		}

		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Collections.singletonList(new ConceptMapDescriptor() {

				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {

						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}

						@Override
						public String code() {
							return "80779";
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
			return "80779AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};

	public static final ConceptDescriptor PANTOPRAZOLE = new DrugConceptDescriptor() {

		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Pantoprazole";
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
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}
			});
		}

		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Collections.singletonList(new ConceptMapDescriptor() {

				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {

						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}

						@Override
						public String code() {
							return "81550";
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
			return "81550AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};

	public static final ConceptDescriptor STREP_VAX = new DrugConceptDescriptor() {

		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Polyvalent Pneumococcal Vaccine";
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
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}
			});
		}

		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Collections.singletonList(new ConceptMapDescriptor() {

				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {

						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}

						@Override
						public String code() {
							return "82312";
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
			return "82312AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};

	public static final ConceptDescriptor POTASSIUM_PHOSPHATE = new DrugConceptDescriptor() {

		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Potassium Phosphate";
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
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}
			});
		}

		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Collections.singletonList(new ConceptMapDescriptor() {

				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {

						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}

						@Override
						public String code() {
							return "82372";
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
			return "82372AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};

	public static final ConceptDescriptor VANCOMYCIN = new DrugConceptDescriptor() {

		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Collections.singletonList(new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return null;
				}

				@Override
				public String name() {
					return "Vancomycin";
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
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}
			});
		}

		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Collections.singletonList(new ConceptMapDescriptor() {

				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {

						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}

						@Override
						public String code() {
							return "86082";
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
			return "86082AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};

	public static final ConceptDescriptor LACTATED_RINGERS = new DrugConceptDescriptor() {

		@Override
		public Iterable<? extends ConceptNameDescriptor> names() {
			return Arrays.asList(new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return "10200BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";
				}

				@Override
				public String name() {
					return "Glucose / Lactated Ringer's Solution";
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
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return true;
				}
			}, new ConceptNameDescriptor() {

				@Override
				public String uuid() {
					return "6296BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB";
				}

				@Override
				public String name() {
					return "Lactated Ringer's";
				}

				@Override
				public String description() {
					return null;
				}

				@Override
				public Locale locale() {
					return Locale.ENGLISH;
				}

				@Override
				public boolean preferred() {
					return false;
				}
			});
		}

		@Override
		public Iterable<? extends ConceptMapDescriptor> sameAs() {
			return Collections.singletonList(new ConceptMapDescriptor() {

				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {

						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}

						@Override
						public String code() {
							return "104730";
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
			return "104730AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
	};

	public static final Iterable<ConceptDescriptor> ALL_DRUGS = Arrays.asList(ACETAMINOPHEN, ABUTEROL, ASPIRIN, FAMOTIDINE,
			LORAZEPAM, NOREPINEPHRINE, PANTOPRAZOLE, STREP_VAX, POTASSIUM_PHOSPHATE, VANCOMYCIN, LACTATED_RINGERS);

	private static final ConceptClassDescriptor DRUG = new ConceptClassDescriptor() {

		@Override
		public String name() {
			return "Drug";
		}

		@Override
		public String uuid() {
			return DRUG_CLASS_UUID;
		}
	};

	private static abstract class DrugConceptDescriptor extends ConceptDescriptor {

		@Override
		public ConceptClassDescriptor conceptClass() {
			return DRUG;
		}

		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	}
}
