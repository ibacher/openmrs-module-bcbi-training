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

import org.openmrs.api.ConceptNameType;
import org.openmrs.module.bcbitraining.descriptor.mds.*;

import static org.openmrs.module.bcbitraining.BCBITrainingConstants.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

import static org.openmrs.module.bcbitraining.metadata.BCBIConceptBase.*;
import static org.openmrs.api.ConceptNameType.*;

public class BCBIDiagnosisConcepts {
	
	private static final ConceptClassDescriptor DIAGNOSIS = new ConceptClassDescriptor() {
		
		@Override
		public String name() {
			return "Diagnosis";
		}
		
		@Override
		public String uuid() {
			return DIAGNOSIS_CLASS_UUID;
		}
	};
	
	public static final ConceptDescriptor BACTERAEMIA = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "148029AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "The presence of viable bacteria circulating in the blood. Fever, chills, tachycardia, and tachypnea are common acute manifestations of bacteremia. The majority of cases are seen in already hospitalized patients, most of whom have underlying diseases or procedures which render their bloodstreams susceptible to invasion.";
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
					return "Bacteraemia";
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
							return "148029";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor RENAL_FAILURE = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "121849AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Acute Renal Failure";
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
					return ACUTE_RENAL_FAILURE_NAME_UUID;
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
					return "Acute kidney failure";
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
					return "AKI";
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
							return "121849";
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
							return "3698";
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
							return "RENAL FAILURE, ACUTE";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor UTI = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "111633AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Urinary tract infection";
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
					return UTI_NAME_UUID;
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
					return "UTI";
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
							return "111633";
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
							return "55";
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
							return "URINARY TRACT INFECTION";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor DIABETES = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "111735AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Diabetes Mellitus Type II, Controlled, with no Complications";
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
							return "111735";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor THRMBOCYTOPAENIA = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "112406AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "A decrease in the number of blood platelets.";
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
					return "Thrombocytopaenia";
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
							return "112406";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor BONE_TUMOR = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "113084AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Metastatic Bone Tumor";
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
					return "Metastatic bone malignancy";
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
					return "Secondary malignant neoplasm of bone";
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
							return "113084";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor PNEUMONIA = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "114100AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "Inflammation of the lungs.";
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
					return "Pneumonia";
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
					return PNEUMONIA_NAME_UUID;
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
							return "114100";
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
							return "43";
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
							return "PNEUMONIA";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor PLEURAL_EFFUSION = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "114108AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Pleural effusion";
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
							return "114108";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor OSTEOPOROSIS = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "114662AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Osteoporosis";
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
							return "114662";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor MITRAL_VALVE_DISORDER = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "115736AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "Abnormal protrusion of one or both of the leaflets of the mitral valve into the left atrium during systole. This may be accompanied by mitral regurgitation, systolic murmur, nonejection click, or cardiac arrhythmia.";
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
					return "Mitral Valve Disorder";
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
							return "115736";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor LIVER_CANCER = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "116066AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Malignant Neoplasm of Liver";
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
							return "116066";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor HYPOTHYROIDISM = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "117321AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Hypothyroidism";
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
					return HYPOTHYROIDISM_NAME_UUID;
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
							return "117321";
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
							return "6357";
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
							return "Hypothyroidism";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor HYPERTENSIVE_KIDNEY = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "117380AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "The inability of a kidney to excrete metabolites at normal plasma levels under conditions of normal loading, or the inability to retain electrolytes under conditions of normal intake. In the acute form (KIDNEY FAILURE, ACUTE), it is marked by uremia and usually by oliguria or anuria, with hyperkalemia and pulmonary edema. The chronic form (KIDNEY FAILURE, CHRONIC) is irreversible and requires hemodialysis.";
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
					return "Hypertensive Kidney Disease with Chronic Kidney Disease";
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
							return "117380";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor HYPERCHOLESTEROLEMIA = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "117461AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "Abnormally high levels of cholesterol in the blood.";
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
					return "Hypercholesterolemia";
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
							return "117461";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor GOUT = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "117762AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "Hereditary metabolic disorder characterized by recurrent acute arthritis, hyperuricemia and deposition of sodium urate in and around the joints, sometimes with formation of uric acid calculi.";
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
					return "Gout";
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
					return GOUT_NAME_UUID;
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
							return "117762";
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
							return "3274";
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
							return "GOUT";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor DIASTOLIC_HEART_FAILURE = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "119424AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Diastolic Heart Failure";
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
							return "119424";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor DEPRESSION = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "119537AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Depression";
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
					return DEPRESSION_NAME_UUID;
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
							return "119537";
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
							return "207";
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
							return "DEPRESSION";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor DELIRIUM_NOS = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "119583AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Delirium due to Conditions Classified Elsewhere";
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
							return "119583";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor CORONARY_ATHEROSCLEROSIS = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "119821AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "Disorder of cardiac function due to an imbalance between myocardial function and the capacity of the coronary vessels to supply sufficient flow for normal function. It is a form of MYOCARDIAL ISCHEMIA (insufficient blood supply to the heart muscle) caused by a decreased capacity of the coronary vessels.";
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
					return "Coronary Atherosclerosis";
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
							return "119821";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor CHF = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "119910AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Congestive Heart Failure";
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
					return "CHF";
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
							return "119910";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor ASTHMA = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "121375AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Asthma";
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
					return ASTHMA_NAME_UUID;
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
							return "121375AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
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
							return "5";
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
							return "ASTHMA";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor ANEMIA_CHRONIC = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "121619AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Anemia of Other Chronic Disease ";
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
							return "121619";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor HEART_ATTACK = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "121823AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Acute Myocardial Infarction, Subendocardial Infarction";
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
					return "Acute Myocardial Infarction";
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
							return "121823";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor SEPSIS = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "126721AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "The presence of pathogenic microorganisms or their toxins in tissues or in the blood.";
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
					return "Sepsis";
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
					return SEPSIS_NAME_UUID;
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
							return "126721";
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
							return "3770";
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
							return "SEPSIS";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor LUNG_CANCER = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "126932AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Secondary Malignant Neoplasm of Lung";
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
							return "126932";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor PNEUMONITIS_INHALATION = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "129996AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "A type of pneumonia resulting from the aspiration of food, liquid, or gastric contents into the upper respiratory tract.";
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
					return "Pneumonitis due to Inhalation of Food or Vomitus ";
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
							return "119583";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor SLEEP_APNEA = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "132511AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "A disorder characterized by recurrent apneas during sleep despite persistent respiratory efforts. It is due to upper airway obstruction. The respiratory pauses may induce HYPERCAPNIA or HYPOXIA. Cardiac ARRHYTHMIA and elevation of systemic and pulmonary arterial pressures may occur. Frequent partial arousals occur throughout sleep, resulting in relative SLEEP DEPRIVATION and daytime tiredness. Associated conditions include OBESITY; ACROMEGALY; MYXEDEMA; micrognathia; MYOTONIC DYSTROPHY; adenotonsilar dystrophy; and NEUROMUSCULAR DISEASES.";
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
					return "Obstructive Sleep Apnea Syndrome";
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
							return "132511";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor IATROGENIC_HYPOTENSION = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "137955AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "Abnormally low blood pressure seen in shock but not necessarily indicative of it.";
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
					return "Iatrogenic Hypotension";
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
							return "137955";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor HYPOSMOLALITY = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "138012AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Hyposmolality";
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
							return "138012";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor HYPOKALEMIA = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "138056AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "A condition due to decreased dietary intake of potassium, as in starvation or failure to administer in intravenous solutions, or to gastrointestinal loss in diarrhea, chronic laxative abuse, vomiting, gastric suction, or bowel diversion. Severe potassium deficiency may produce muscular weakness and lead to paralysis and respiratory failure. Muscular malfunction may result in hypoventilation, paralytic ileus, hypotension, muscle twitches, tetany, and rhabomyolysis. Nephropathy from potassium deficit impairs the concentrating mechanism, producing polyuria and decreased maximal urinary concentrating ability with secondary polydipsia.";
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
					return "Hypokalemia";
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
					return "Hypopotassemia";
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
							return "138056";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor HYPEROSMOLALITY = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "138249AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Hyperosmolality";
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
							return "138249";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor HYPERKALEMIA = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "138281AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Hyperkalemia";
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
					return HYPERKALEMIA_NAME_UUID;
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
					return "Hyperpotassemia";
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
							return "138281";
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
							return "3285";
						}
					};
				}
			}, new ConceptMapDescriptor() {
				
				@Override
				public ConceptReferenceDescriptor conceptReference() {
					return new ConceptReferenceDescriptor() {
						
						@Override
						public ConceptSourceDescriptor conceptSource() {
							return CIEL;
						}
						
						@Override
						public String code() {
							return "HYPERKALEMIA";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor GE_REFLUX = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "139590AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "Inflammation of the esophagus caused by reflux of gastric juice and/or stomach and duodenal contents.";
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
					return "Gastro-Esophageal Reflux Disease with Esophagitis";
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
					return "Reflux oesophagitis";
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
							return "139590";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor CHRONIC_AIRWAY_OBSTRUCTION = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "119583AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Chronic Airway Obstruction";
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
							return "119583";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor CLOSTRIDIUM_DIFFICILE = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "144685AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Clostridium Difficile Infection";
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
							return "144685";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor CHRONIC_KIDENY_DISEASE = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "145438AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Chronic Kidney Disease";
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
					return CHRONIC_KIDNEY_DISEASE_NAME_UUID;
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
							return "145438";
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
							return "3699";
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
							return "RENAL FAILURE, CHRONIC";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor ATRIAL_FIBRILLATION = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "148203AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "Disorder of cardiac rhythm characterized by rapid, irregular atrial impulses and ineffective atrial contractions.";
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
					return "Atrial Fibrillation";
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
					return ATRIAL_FIBRILLATION_NAME_UUID;
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
							return "148203";
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
							return "3177";
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
							return "ATRIAL FIBRILLATION";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor PULMONARY_COLLAPSE = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "148246AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Pulmonary Collapse";
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
							return "148246";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor ASCITES = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "148346AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Ascites";
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
					return ASCITES_NAME_UUID;
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
							return "148346";
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
							return "581";
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
							return "ASCITES";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor AORTIC_VALVE_DISORDER = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "148547AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Aortic Valve Disorder";
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
							return "148547";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor ANEMIA_CHRONIC_BLOOD_LOSS = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "148873AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Anemia due to Chronic Blood Loss";
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
							return "148873";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor ACUTE_RESPITORY_FAILURE = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "149537AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Acute Respiratory Failure";
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
							return "149537";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor LIVER_NECROSIS = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "149637AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Acute Necrosis of Liver";
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
							return "149637";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor ACIDOSIS = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "150148AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return "A pathologic condition resulting from accumulation of acid or depletion of the alkaline reserve (bicarbonate) content of the blood and body tissues, and characterized by an increase in hydrogen ion concentration (decrease in pH).";
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
					return "Acidosis";
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
							return "150148";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor STATUS_AFTER_CORONARY_GRAFT = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "151252AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Status Post Coronary Artery Bypass Graft";
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
					return "Aortocoronary bypass status";
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
							return "151252";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor BREAST_CANCER_HISTORY = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "151285AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Personal History of Malignant Neoplasm of Breast";
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
					return "Personal History of Breast Cancer";
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
							return "151285";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor HISTORY_DVT = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "152510AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Personal History of Deep Vein Thrombosis";
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
							return "152510";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor HISTORY_TOBACCO = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "159084AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "History of Tobacco Use";
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
					return "Tobacco User";
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
							return "159084";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor CHRONIC_PSYCHIATRIC = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "160518AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Chronic psychiatric disease";
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
							return "138012";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor ANAEMIA = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "121629AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Anaemia";
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
							return "121629";
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
							return "3";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final ConceptDescriptor HYPERTENSION = new ConceptDescriptor() {
		
		@Override
		public String uuid() {
			return "140987AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
		}
		
		@Override
		public String description() {
			return null;
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
					return "Essential hypertension";
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
							return "140987";
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
							return "6847";
						}
					};
				}
			});
		}
		
		@Override
		public ConceptClassDescriptor conceptClass() {
			return DIAGNOSIS;
		}
		
		@Override
		public ConceptDatatypeDescriptor datatype() {
			return NA;
		}
	};
	
	public static final Iterable<ConceptDescriptor> ALL_DIAGNOSES = Arrays.asList(ACIDOSIS, ACUTE_RESPITORY_FAILURE, ANAEMIA,
	    ANEMIA_CHRONIC, ANEMIA_CHRONIC_BLOOD_LOSS, AORTIC_VALVE_DISORDER, ASCITES, ASTHMA, ATRIAL_FIBRILLATION, BACTERAEMIA,
	    BONE_TUMOR, BREAST_CANCER_HISTORY, CHF, CHRONIC_AIRWAY_OBSTRUCTION, CHRONIC_KIDENY_DISEASE, CHRONIC_PSYCHIATRIC,
	    CLOSTRIDIUM_DIFFICILE, CORONARY_ATHEROSCLEROSIS, DELIRIUM_NOS, DEPRESSION, DEPRESSION, DIABETES,
	    DIASTOLIC_HEART_FAILURE, GE_REFLUX, GOUT, HEART_ATTACK, HISTORY_DVT, HISTORY_TOBACCO, HYPERCHOLESTEROLEMIA,
	    HYPERKALEMIA, HYPEROSMOLALITY, HYPERTENSION, HYPERTENSIVE_KIDNEY, HYPOKALEMIA, HYPOSMOLALITY, HYPOTHYROIDISM,
	    IATROGENIC_HYPOTENSION, LIVER_CANCER, LIVER_NECROSIS, LUNG_CANCER, MITRAL_VALVE_DISORDER, OSTEOPOROSIS,
	    PLEURAL_EFFUSION, PNEUMONIA, PNEUMONITIS_INHALATION, PULMONARY_COLLAPSE, RENAL_FAILURE, SEPSIS, SLEEP_APNEA,
	    STATUS_AFTER_CORONARY_GRAFT, THRMBOCYTOPAENIA, UTI);
	
}
