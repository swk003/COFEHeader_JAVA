package uk.gov.nhsdigital.cofeheader.generate;

import java.util.ArrayList;
import java.util.List;
import ca.uhn.fhir.model.api.ExtensionDt;
import ca.uhn.fhir.model.api.ResourceMetadataKeyEnum;
import ca.uhn.fhir.model.base.resource.ResourceMetadataMap;
import ca.uhn.fhir.model.dstu2.composite.BoundCodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.PeriodDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Composition;
import ca.uhn.fhir.model.dstu2.resource.Composition.Section;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.resource.Encounter.Hospitalization;
import ca.uhn.fhir.model.dstu2.resource.Location;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.resource.Practitioner.PractitionerRole;
import ca.uhn.fhir.model.dstu2.valueset.AddressUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.dstu2.valueset.BundleTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.CompositionStatusEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointSystemEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.EncounterStateEnum;
import ca.uhn.fhir.model.dstu2.valueset.EncounterTypeEnum;
import ca.uhn.fhir.model.dstu2.valueset.NameUseEnum;
import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.DateTimeDt;

public class CreateXMLDocument {

	@SuppressWarnings("unchecked")
	public static Bundle createBundle(){
		
		final Bundle bndl = new Bundle();
		
		bndl.setId("320d7908-d1ae-48aa-b055-94561076b945");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/cofe-document-bundle-1");
		bndl.setResourceMetadata(meta);
		//SWK bundle type
		//These valuesets must either be empty, or be populated with a value drawn from the list of allowable values 
		//defined by FHIR. HAPI provides special typesafe Enums to help in dealing with these fields.
		// HAPI provides Java enumerated types which make it easier to
		// deal with coded values. This code achieves the exact same result
		bndl.setType(BundleTypeEnum.DOCUMENT);
		// end bundle type
		return bndl;
	}
	
	
	@SuppressWarnings("unchecked")
	public static Patient createPatient(){
		
		Patient pat = new Patient();
		pat.setId("22daadee-26e1-4d6a-9e6a-7f4af9b58800");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/CareConnect-patient-1");
		pat.setResourceMetadata(meta);
		
		ExtensionDt ext1 = new ExtensionDt();
		ext1.setModifier(false);
		ext1.setUrl("http://hl7.org.uk/fhir/CareConnect-EthnicCategory-1-Extension");
		CodeableConceptDt codeableConceptext1 = new CodeableConceptDt();
		codeableConceptext1.addCoding().setSystem("http://hl7.org.uk/fhir/CareConnect-EthnicCategory-1-Extension").setCode("A").setDisplay("British, Mixed British");
		ext1.setValue(codeableConceptext1);
		pat.addUndeclaredExtension(ext1);
		
		ExtensionDt ext2 = new ExtensionDt();
		ext2.setModifier(false);
		ext2.setUrl("http://hl7.org.uk/fhir/CareConnect-ReligiousAffiliation-1-Extension");
		CodeableConceptDt codeableConceptext2 = new CodeableConceptDt();
		codeableConceptext2.addCoding().setSystem("http://snomed.info/sct").setCode("160542002").setDisplay("Atheist (person)");
		ext2.setValue(codeableConceptext2);
		pat.addUndeclaredExtension(ext2);
		
		ExtensionDt ext6 = new ExtensionDt();
		ext6.setModifier(false);
		ext6.setUrl("http://hl7.org.uk/fhir/CareConnect-OrganDonor-1-Extension");
		ext6.setValue(new BooleanDt(true));
		pat.addUndeclaredExtension(ext6);
		
		ExtensionDt ext7 = new ExtensionDt();
		ext7.setModifier(false);
		ext7.setUrl("http://hl7.org.uk/fhir/CareConnect-ResidentialStatus-1-Extension");
		CodeableConceptDt codeableConceptext7 = new CodeableConceptDt();
		codeableConceptext7.addCoding().setSystem("http://hl7.org.uk/fhir/CareConnect-ResidentialStatus-1-Extension").setCode("H").setDisplay("UK Resident");
		ext7.setValue(codeableConceptext7);
		pat.addUndeclaredExtension(ext7);
		
		ExtensionDt ext8 = new ExtensionDt();
		ext8.setModifier(false);
		ext8.setUrl("http://hl7.org.uk/fhir/CareConnect-TreatmentCategory-1-Extension");
		CodeableConceptDt codeableConceptext8 = new CodeableConceptDt();
		codeableConceptext8.addCoding().setSystem("http://hl7.org.uk/fhir/CareConnect-TreatmentCategory-1-Extension").setCode("8").setDisplay("Not applicable");
		ext8.setValue(codeableConceptext8);
		pat.addUndeclaredExtension(ext8);
		
		ExtensionDt ext9 = new ExtensionDt();
		ext9.setModifier(false);
		ext9.setUrl("http://hl7.org.uk/fhir/CareConnect-NhsCommunication-1-Extension");
		ext9.setUrl("language");
		CodeableConceptDt codeableConceptext9 = new CodeableConceptDt();
		codeableConceptext9.addCoding().setSystem("http://hl7.org.uk/fhir/ValueSet/CareConnect-HumanLanguage").setCode("en").setDisplay("English");
		ext9.setValue(codeableConceptext9);
		pat.addUndeclaredExtension(ext9);
		
		ExtensionDt ext10 = new ExtensionDt();
		ext10.setModifier(false);
		ext10.setUrl("preferred");
		ext10.setValue(new BooleanDt(true));
		pat.addUndeclaredExtension(ext10);
		
		ExtensionDt ext11 = new ExtensionDt();
		ext11.setModifier(false);
		ext11.setUrl("modeOfCommunication");
		CodeableConceptDt codeableConceptext11 = new CodeableConceptDt();
		codeableConceptext11.addCoding().setSystem("http://hl7.org.uk/fhir/ValueSet/CareConnect-LanguageAbilityMode").setCode("ESP").setDisplay("Expressed spoken");
		ext11.setValue(codeableConceptext11);
		pat.addUndeclaredExtension(ext11);
		
		ExtensionDt ext12 = new ExtensionDt();
		ext12.setModifier(false);
		ext12.setUrl("modeOfCommunication");
		CodeableConceptDt codeableConceptext12 = new CodeableConceptDt();
		codeableConceptext12.addCoding().setSystem("http://hl7.org.uk/fhir/ValueSet/CareConnect-LanguageAbilityMode").setCode("RWR").setDisplay("Received written");
		ext12.setValue(codeableConceptext12);
		pat.addUndeclaredExtension(ext12);
		
		ExtensionDt ext13 = new ExtensionDt();
		ext13.setModifier(false);
		ext13.setUrl("communicationProficiency");
		CodeableConceptDt codeableConceptext13 = new CodeableConceptDt();
		codeableConceptext13.addCoding().setSystem("http://hl7.org.uk/fhir/ValueSet/CareConnect-LanguageAbilityMode").setCode("E").setDisplay("Excellent");
		ext13.setValue(codeableConceptext13);
		pat.addUndeclaredExtension(ext13);
		
		ExtensionDt ext14 = new ExtensionDt();
		ext14.setModifier(false);
		ext14.setUrl("interpreterRequired");
		ext14.setValue(new BooleanDt(false));
		pat.addUndeclaredExtension(ext14);
		
		ExtensionDt ext15 = new ExtensionDt();
		ext15.setModifier(false);
		ext15.setUrl("http://hl7.org.uk/fhir/CareConnect-NhsNumberVerificationStatus-1-Extension");
		CodeableConceptDt codeableConceptext15 = new CodeableConceptDt();
		codeableConceptext15.addCoding().setSystem("http://hl7.org.uk/fhir/ValueSet/CareConnect-NhsNumberVerificationStatus").setCode("01").setDisplay("Number present and verified");
		ext15.setValue(codeableConceptext15);
		
		pat.addIdentifier().setSystem("http://fhir.nhs.net/Id/nhs-number").setValue("1352465790").addUndeclaredExtension(ext15);
		
		pat.setActive(true);
		
		pat.addName().setUse(NameUseEnum.USUAL).addFamily("Smith").addGiven("Richard").addPrefix("Mr");
		pat.setGender(AdministrativeGenderEnum.MALE);
		pat.setBirthDate(new DateDt("1957-01-01"));
		pat.addAddress().setUse(AddressUseEnum.HOME).addLine("21, Grove Street").setCity("Overtown").setDistrict("Leeds").setPostalCode("LS21 1PF");
		CodingDt maritalStatus = pat.getMaritalStatus().addCoding();
		maritalStatus.setSystem("http://hl7.org/fhir/marital-status");
		maritalStatus.setCode("M");
		maritalStatus.setDisplay("Married");
		
		pat.addContact().addRelationship().addCoding().setCode("01").setDisplay("Spouse").setSystem("http://hl7.org.uk/fhir/ValueSet/CareConnect-PersonRelationshipType");
			
		ResourceReferenceDt rr4 = new ResourceReferenceDt();
		rr4.setReference("Organization/43daadee-26e1-4d6a-9e6a-7f4af9b58800").setDisplay("MGP Medical Centre");
		List<ResourceReferenceDt> rr4list = new ArrayList<ResourceReferenceDt>();
		rr4list.add(rr4);
		pat.setCareProvider(rr4list);
	
		return pat;
	}

	
	@SuppressWarnings("unchecked")
	public static Practitioner createPractitioner(){
		
		Practitioner pract = new Practitioner();
		pract.setId("8ece9986-9af0-4882-b0cf-23a96ea7b509");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/CareConnect-Practitioner-1");
		pract.setResourceMetadata(meta);
		
		pract.setName(new HumanNameDt().addFamily("Smith").addGiven("Angela").addPrefix("Mrs"));
		pract.addTelecom().setSystem(ContactPointSystemEnum.PHONE).setValue("01136323200").setUse(ContactPointUseEnum.WORK);
		
		List<PractitionerRole> PracRoleList = new ArrayList<PractitionerRole>();
		PractitionerRole pr1 = new PractitionerRole();
		pr1.setManagingOrganization(new ResourceReferenceDt().setReference("Organization/f9f24f89-646b-4a19-a6b1-cabfa3b612e1").setDisplay("MGP Medical Centre"));
		pr1.getRole().getCodingFirstRep().setSystem("http://fhir.nhs.net/job-role-name-1").setCode("NR0700").setDisplay("Community Nurse");
		PracRoleList.add(pr1);
		pract.setPractitionerRole(PracRoleList);
		
		return pract;
		
	}

	
	@SuppressWarnings("unchecked")
	public static Practitioner createPractitioner1(){
		
		Practitioner pract1 = new Practitioner();
		pract1.setId("5e414a77-d394-4248-a631-00e45ddb64a0");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/CareConnect-Practitioner-1");
		pract1.setResourceMetadata(meta);
		
		pract1.addIdentifier().setSystem("http://fhir.nhs.net/Id/sds-identifier").setValue("GP12345600");
		pract1.setName(new HumanNameDt().addFamily("Lorenzo").addGiven("John").addPrefix("Dr"));
		pract1.addTelecom().setSystem(ContactPointSystemEnum.PHONE).setValue("01634111222").setUse(ContactPointUseEnum.WORK);
		pract1.addTelecom().setSystem(ContactPointSystemEnum.EMAIL).setValue("John.Lorenzo@MMC.co.uk");
		
		List<PractitionerRole> PracRoleList = new ArrayList<PractitionerRole>();
		PractitionerRole pr1 = new PractitionerRole();
		pr1.setManagingOrganization(new ResourceReferenceDt().setReference("Organization/f9f24f89-646b-4a19-a6b1-cabfa3b612e1").setDisplay("MGP Medical Centre"));
		pr1.getRole().getCodingFirstRep().setSystem("http://fhir.nhs.net/job-role-name-1").setCode("NR9100").setDisplay("Named GP");
		PracRoleList.add(pr1);
		pract1.setPractitionerRole(PracRoleList);
		
		return pract1;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static Practitioner createPractitioner2(){
		
		Practitioner pract2 = new Practitioner();
		pract2.setId("9ff4a692-c1d7-4dd6-9e0b-f44e77348faf");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/CareConnect-Practitioner-1");
		pract2.setResourceMetadata(meta);
		
		pract2.setName(new HumanNameDt().addFamily("Jones").addGiven("Tom").addPrefix("Mr"));
		pract2.addTelecom().setSystem(ContactPointSystemEnum.PHONE).setValue("01136323200").setUse(ContactPointUseEnum.WORK);
		pract2.addAddress().addLine("Leeds Teaching Hospital").addLine("Great George Street").addLine("Leeds").addLine("LS1 3EX");
		
		List<PractitionerRole> PracRoleList = new ArrayList<PractitionerRole>();
		PractitionerRole pr2 = new PractitionerRole();
		pr2.setManagingOrganization(new ResourceReferenceDt().setReference("Organization/e1580b71-99bd-4c5b-8d54-9b420418135f").setDisplay("Leeds Community Healthcare NHS Trust"));
		pr2.getRole().getCodingFirstRep().setSystem("http://fhir.nhs.net/ValueSet/sds-job-role-name-1").setCode("NR0110").setDisplay("Specialist Registrar");
		PracRoleList.add(pr2);
		pract2.setPractitionerRole(PracRoleList);
		
		return pract2;
		
	}
	
	@SuppressWarnings("unchecked")
	public static Organization createOrganization(){
		
		Organization org = new Organization();
		org.setId("f9f24f89-646b-4a19-a6b1-cabfa3b612e1");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/CareConnect-organization-1");
		org.setResourceMetadata(meta);
		
		IdentifierDt rr2 = new IdentifierDt();
		rr2.setSystem("http://fhir.nhs.net/Id/ods-organization-code").setValue("GP123456");
		List<IdentifierDt> idenList = new ArrayList<IdentifierDt>();
		idenList.add(rr2);
		org.setIdentifier(idenList);
		
		 // Coded types can naturally be set using plain strings
		CodingDt orgtype = org.getType().addCoding();
		orgtype.setSystem("http://hl7.org/fhir/ValueSet/organization-type");
		orgtype.setCode("prov");
		orgtype.setDisplay("Healthcare Provider");
		
		org.setName("MGP Medical Centre");
		org.addTelecom().setSystem(ContactPointSystemEnum.PHONE).setValue("01634111223").setUse(ContactPointUseEnum.WORK);
		org.addTelecom().setSystem(ContactPointSystemEnum.EMAIL).setValue("Admin@MMC.co.uk");
		org.addAddress().setUse(AddressUseEnum.WORK).addLine("1 MGP House").addLine("Overtown").addLine("Leeds").addLine("LS21 7PA");
		return org;
	}
	

	@SuppressWarnings("unchecked")
	public static Organization createOrganization1(){
		
		Organization org1 = new Organization();
		org1.setId("e1580b71-99bd-4c5b-8d54-9b420418135f");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/CareConnect-organization-1");
		org1.setResourceMetadata(meta);
		
		IdentifierDt rr23 = new IdentifierDt();
		rr23.setSystem("http://fhir.nhs.net/Id/ods-organization-code").setValue("RY6");
		List<IdentifierDt> idenList1 = new ArrayList<IdentifierDt>();
		idenList1.add(rr23);
		org1.setIdentifier(idenList1);
		
		  // Coded types can naturally be set using plain strings
		CodingDt orgtype1 = org1.getType().addCoding();
		orgtype1.setSystem("http://hl7.org/fhir/ValueSet/organization-type");
		orgtype1.setCode("prov");
		orgtype1.setDisplay("Healthcare Provider");
		
		org1.setName("Leeds Community Healthcare NHS Trust");
		org1.addTelecom().setSystem(ContactPointSystemEnum.PHONE).setValue("01136323200").setUse(ContactPointUseEnum.WORK);
		org1.addAddress().addLine("Leeds Community Healthcare NHS Trust").addLine("First Floor, Stockdale House").addLine("Headingley Office Park").addLine("Victoria Road").addLine("Leeds").addLine("LS6 1PF");
		return org1;
	}
	
	@SuppressWarnings("unchecked")
	public static Location createLocation(){
		
		Location loc = new Location();
		loc.setId("01bb1ccc-577b-4a4a-9fb0-9c8fe9f21fa3");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/cofe-Location-1");
		loc.setResourceMetadata(meta);
		
		loc.setName("Accident and emergency department of Leeds Teaching Hospital");
		
		// Coded types can naturally be set using plain strings
		CodingDt loctype = loc.getType().addCoding();
		loctype.setSystem("http://snomed.info/sct");
		loctype.setCode("225728007");
		loctype.setDisplay("Accident and Emergency department");
		
		return loc;
	}
	
	@SuppressWarnings("unchecked")
	public static Encounter createEncounter(){
	
		Encounter enc = new Encounter();
		enc.setId("4f36b35a-ad18-4ea9-a3fb-c893f709e88a");
	
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://hl7.org.uk/fhir/CareConnect-Encounter-1");
		enc.setResourceMetadata(meta);
	
		enc.addIdentifier().setValue("13c73015-d8fa-4844-8d68-4f856883eca8");
		enc.setStatus(EncounterStateEnum.FINISHED);
		
		// EncounterTypeEnum doesn't include SNOMED codes so have set an arbitrary value
	    BoundCodeableConceptDt<EncounterTypeEnum> type = enc.addType();
	    type.addCoding().setSystem("http://snomed.info/sct").setCode("4525004").setDisplay("Emergency department patient visit");

		 //Subject
		 enc.setPatient((new ResourceReferenceDt().setReference("Patient/31686b67-9f20-4644-9a54-193d2f91de57").setDisplay("Richard Smith")));
		 enc.setPeriod(new PeriodDt().setStart(new DateTimeDt("2015-02-12T09:00:00+00:00")).setEnd(new DateTimeDt("2016-02-16T09:00:00+00:00")));
		 
		 Hospitalization hosp1 = new Hospitalization();
	     CodingDt hosp1code = hosp1.getDischargeDisposition().addCoding();
	     hosp1code.setSystem("http://snomed.info/sct");
	     hosp1code.setCode("306689006");
	     hosp1code.setDisplay("Discharge to home");
	     enc.setHospitalization(hosp1);
	     
	     enc.addLocation().setLocation((new ResourceReferenceDt().setReference("Location/01bb1ccc-577b-4a4a-9fb0-9c8fe9f21fa3").setDisplay("Accident and Emergency department")));
	  
		return enc;
}
	
	@SuppressWarnings("unchecked")
	public static <Text, Narrative> Composition createComposition() {
		// TODO Auto-generated method stub
		
		Composition comp = new Composition();
		
		ExtensionDt ext3 = new ExtensionDt();
		ext3.setModifier(false);
		ext3.setUrl("http://fhir.nhs.net/StructureDefinition/extension-cofe-information-recipient-1");
		ext3.setValue((new ResourceReferenceDt().setReference("Practitioner/8ece9986-9af0-4882-b0cf-23a96ea7b509").setDisplay("Mrs Angela Smith")));
		// Add the extension to the resource
		comp.addUndeclaredExtension(ext3);
		
		ExtensionDt ext4 = new ExtensionDt();
		ext4.setModifier(false);
		ext4.setUrl("http://fhir.nhs.net/StructureDefinition/extension-cofe-information-recipient-1");
		ext4.setValue((new ResourceReferenceDt().setReference("Practitioner/5e414a77-d394-4248-a631-00e45ddb64a0").setDisplay("Dr John Lorenzo")));
		// Add the extension to the resource
		comp.addUndeclaredExtension(ext4);
		
		ExtensionDt ext5 = new ExtensionDt();
		ext5.setModifier(false);
		ext5.setUrl("http://fhir.nhs.net/StructureDefinition/extension-cofe-care-setting-type-1");
		CodeableConceptDt codeableConcept = new CodeableConceptDt();
		codeableConcept.addCoding().setSystem("http://snomed.info/sct").setCode("394576009").setDisplay("Accident &amp; emergency");
		ext5.setValue(codeableConcept);
		comp.addUndeclaredExtension(ext5);
		
		comp.setId("fa2a75a7-4257-422d-92a4-cf537f078e13");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "http://fhir.nhs.net/StructureDefinition/cofe-cda-header-composition-1");
		comp.setResourceMetadata(meta);
		
		// DMS example INCORRECT <value id="2b5d459b-df79-4a2b-9b0c-95b2a7ee2ca4"/>
		IdentifierDt rr15 = new IdentifierDt();
		rr15.setValue("2b5d459b-df79-4a2b-9b0c-95b2a7ee2ca4");
		comp.setIdentifier(rr15);
		
		comp.setDate(new DateTimeDt("2015-02-17T10:00:00+00:00"));
		
		// Coded types can naturally be set using plain strings
	    CodingDt doctype = comp.getType().addCoding();
	    doctype.setSystem("http://snomed.info/sct");
		doctype.setCode("373942005");
	    doctype.setDisplay("Discharge summary");
		
	    comp.setTitle("Discharge summary");
		comp.setStatus(CompositionStatusEnum.FINAL);
		        
	    //confidentiality		        
	    comp.setConfidentiality("V");
		//  comp.setConfidentiality(CompositionConfidentialityEnum.V);
		        
		//Subject
		comp.setSubject(new ResourceReferenceDt().setReference("Patient/31686b67-9f20-4644-9a54-193d2f91de57").setDisplay("Mr Richard Smith"));
		//Author
		ResourceReferenceDt crr2 = new ResourceReferenceDt();
		crr2.setReference("Practitioner/9ff4a692-c1d7-4dd6-9e0b-f44e77348faf").setDisplay("Dr Tom Jones");
		List<ResourceReferenceDt> crr2list = new ArrayList<ResourceReferenceDt>();
	    crr2list.add(crr2);
		comp.setAuthor(crr2list);
		     
		//Custodian
		comp.setCustodian(new ResourceReferenceDt().setReference("Organization/e1580b71-99bd-4c5b-8d54-9b420418135f").setDisplay("Leeds Community Healthcare NHS Trust"));
		     
		//Encounter - works just no requirement to populate
		comp.setEncounter(new ResourceReferenceDt().setReference("Encounter/4f36b35a-ad18-4ea9-a3fb-c893f709e88a").setDisplay("Emergency department patient visit"));
		  
		//Admission details Section
		Section sect1 = new Section();
	    sect1.setTitle("Admission details");
		        
	    CodingDt sect1code = sect1.getCode().addCoding();
		sect1code.setSystem("http://snomed.info/sct");
		sect1code.setCode("886781000000108");
		sect1code.setDisplay("Admission details");
		sect1.getText().setDiv("<div><table><tbody><tr><th>Admission method</th><td>Emergency</td></tr><tr><th>Date of admission</th><td>12-Feb-2015</td></tr><tr><th>Source of admission</th><td>Usual place of residence</td></tr></tbody></table></div>");
		CodingDt sect1orderedby = sect1.getOrderedBy().addCoding();
		sect1orderedby.setCode("system");
		sect1orderedby.setDisplay("Sorted by System");
		comp.addSection(sect1);
		    	
		//Allergies and Adverse Reactions Section
		Section sect5 = new Section();
		sect5.setTitle("Allergies and Adverse Reactions");
		        
		CodingDt sect5code = sect5.getCode().addCoding();
		sect5code.setSystem("http://snomed.info/sct");
		sect5code.setCode("886921000000105");
		sect5code.setDisplay("Allergies and Adverse Reactions");
		sect5.getText().setDiv("<div><table><tbody><tr><th>Causative agent</th><td>Penicillin</td></tr><tr><th>Description of the reaction</th><td>Rash. No swelling/anaphylaxis</td></tr></tbody></table></div>");
		CodingDt sect5orderedby = sect5.getOrderedBy().addCoding();
		sect5orderedby.setCode("system");
		sect5orderedby.setDisplay("Sorted by System");
		comp.addSection(sect5);
		   
		//Assessment Scales
		Section sect9 = new Section();
		sect9.setTitle("Assessment Scales");
		        
		CodingDt sect9code = sect9.getCode().addCoding();
		sect9code.setSystem("http://snomed.info/sct");
	    sect9code.setCode("887141000000103");
		sect9code.setDisplay("Assessment Scales");
		sect9.getText().setDiv("<div><table><tbody><tr><th>Assessment scales</th><td>TIMI score=2</td></tr></tbody></table></div>");
		CodingDt sect9orderedby = sect9.getOrderedBy().addCoding();
		sect9orderedby.setCode("system");
		sect9orderedby.setDisplay("Sorted by System");
		comp.addSection(sect9);
		    	
		    	
		//Clinical summary
		Section sect10 = new Section();
		sect10.setTitle("Clinical summary");
		        
		CodingDt sect10code = sect10.getCode().addCoding();
		sect10code.setSystem("http://snomed.info/sct");
		sect10code.setCode("887181000000106");
		sect10code.setDisplay("Clinical summary");
	    sect10.getText().setDiv("<div><table><tbody><tr><th>Clinical Summary</th></tr><tr><td>58 year old man with an acute history of cardiac sounding chest pain lasting around 2 hours.</td></tr><tr><td>Examination unremarkable.</td></tr><tr><td>Inferior ischaemic changes on ECGs and raised Troponin T.</td></tr><tr><td>Coronary angiogram demonstrated diseased RCA, drug eluting stent successfully placed.</td></tr><tr><td>Appropriate secondary prevention medications prescribed and for follow up with Cardiac Rehabilitation team.</td></tr></tbody></table></div>");
		CodingDt sect10orderedby = sect10.getOrderedBy().addCoding();
		sect10orderedby.setCode("system");
		sect10orderedby.setDisplay("Sorted by System");
		comp.addSection(sect10);
		
		//Diagnoses Section
		Section sect3 = new Section();
		sect3.setTitle("Diagnoses");
		        
	    CodingDt sect3code = sect3.getCode().addCoding();
		sect3code.setSystem("http://snomed.info/sct");
		sect3code.setCode("887161000000102");
		sect3code.setDisplay("Diagnoses");
		sect3.getText().setDiv("<div><table><tbody><tr><th>Diagnosis</th><td>Cardiac chest pain/ACS</td></tr></tbody></table></div>");
		CodingDt sect3orderedby = sect3.getOrderedBy().addCoding();
	    sect3orderedby.setCode("system");
	    sect3orderedby.setDisplay("Sorted by System");
		comp.addSection(sect3);
	
		//Discharge details
		Section sect11 = new Section();
		sect11.setTitle("Discharge details");
		        
		CodingDt sect11code = sect11.getCode().addCoding();
		sect11code.setSystem("http://snomed.info/sct");
		sect11code.setCode("886811000000106");
		sect11code.setDisplay("Discharge details");
		sect11.getText().setDiv("<div><table><tbody><tr><th>Discharging consultant</th><td>Mr Abacus</td></tr><tr><th>Date of discharge</th><td>16-Feb-2015</td></tr><tr><th>Discharge method</th><td>Patient discharged on clinical advice</td></tr><tr><th>Discharge destination</th><td>Usual place of residence</td></tr></tbody></table></div>");
		CodingDt sect11orderedby = sect11.getOrderedBy().addCoding();
		sect11orderedby.setCode("system");
		sect11orderedby.setDisplay("Sorted by System");
		comp.addSection(sect11);
		        
		//Information given
		Section sect12 = new Section();
		sect12.setTitle("Information given");
		        
		CodingDt sect12code = sect12.getCode().addCoding();
		sect12code.setSystem("http://snomed.info/sct");
		sect12code.setCode("887181000000106");
		sect12code.setDisplay("Information given");
		sect12.getText().setDiv("<div><table><tbody><tr><th>Information Given</th></tr><tr><td>Patient seen by Cardiac Rehab and information given regarding diagnosis, lifestyle change and benefits of rehab programme.</td></tr><tr><td>Community follow up planned.</td></tr></tbody></table></div>");
		CodingDt sect12orderedby = sect12.getOrderedBy().addCoding();
		sect12orderedby.setCode("system");
		sect12orderedby.setDisplay("Sorted by System");
		comp.addSection(sect12);
		    	
		//Investigations and procedures requested
		Section sect13 = new Section();
		sect13.setTitle("Investigations and procedures requested");
		        
		CodingDt sect13code = sect13.getCode().addCoding();
		sect13code.setSystem("http://snomed.info/sct");
		sect13code.setCode("887191000000108");
		sect13code.setDisplay("Investigations and procedures requested");
		sect13.getText().setDiv("<div><table><tbody><tr><th>FBC</th><td>5 x 10<sup>12</sup>/L, WCC: 11.1 x 10<sup>9</sup>/L, Hb: 150 g/dl, neutrophils: 7.0 x 10<sup>9</sup>/L, eosinophils: 0.40 x 10<sup>9</sup>/L, lymphocytes: 3.5x10<sup>9</sup>/L, monocytes: 0.3 x 10<sup>9</sup>/L</td></tr><tr><th>Arterial Blood Gases</th><td>PH: 7.41, pO<sub>2</sub>: 13 kPa, pCO<sub>2</sub>: 6.0kPa, HCO3: 24 mEq/L, B.E.: +2 mmol/L</td></tr><tr><th>ECG</th><td>Inferior ischaemic changes</td></tr><tr><th>Chest Xray</th><td>Normal</td></tr></tbody></table></div>");
		CodingDt sect13orderedby = sect13.getOrderedBy().addCoding();
		sect13orderedby.setCode("system");
		sect13orderedby.setDisplay("Sorted by System");
		comp.addSection(sect13);
		    	
		//Legal Information  Section
		Section sect7 = new Section();
		sect7.setTitle("Legal Information");
		        
		CodingDt sect7code = sect7.getCode().addCoding();
		sect7code.setSystem("http://snomed.info/sct");
		sect7code.setCode("886961000000102");
		sect7code.setDisplay("Legal Information");
		sect7.getText().setDiv("<div><table><tbody><tr><th>Advance decisions about treatment</th></tr><tr><td>Declines blood products - patient is a Jehovah’s witness</td></tr></tbody></table></div>");
		CodingDt sect7orderedby = sect7.getOrderedBy().addCoding();
		sect7orderedby.setCode("system");
		sect7orderedby.setDisplay("Sorted by System");
		comp.addSection(sect7);
		
		//Medications And Medical Devices Section
		Section sect4 = new Section();
		sect4.setTitle("Medications And Medical Devices");
		        
		CodingDt sect4code = sect4.getCode().addCoding();
		sect4code.setSystem("http://snomed.info/sct");
		sect4code.setCode("933361000000108");
		sect4code.setDisplay("Medications and medical devices");

		sect4.getText().setDiv("<div><table><tbody><tr><th>Medication Name</th><td>Ramipril</td></tr><tr><th>Dose</th><td>2.5mg</td></tr><tr><th>Medication Frequency</th><td>OD</td></tr><tr><th>Route</th><td>oral</td></tr><tr><th>Medication Recommendations</th><td>continue</td></tr></tbody></table><table><tbody><tr><th>Medication Name</th><td>Omeprazole</td></tr><tr><th>Dose</th><td>20mg</td></tr><tr><th>Medication Frequency</th><td>OD/PRN</td></tr><tr><th>Route</th><td>oral</td></tr><tr><th>Medication Recommendations</th><td>continue</td></tr></tbody></table><table><tbody><tr><th>Medication Name</th><td>Aspirin</td></tr><tr><th>Dose</th><td>75mg</td></tr><tr><th>Medication Frequency</th><td>OD</td></tr><tr><th>Route</th><td>oral</td></tr><tr><th>Medication Recommendations</th><td>continue</td></tr></tbody></table><table><tbody><tr><th>Medication Name</th><td>Clopidogrel</td></tr><tr><th>Dose</th><td>75mg</td></tr><tr><th>Medication Frequency</th><td>OD</td></tr><tr><th>Route</th><td>oral</td></tr><tr><th>Medication Recommendations</th><td>1 year then stop</td></tr></tbody></table></div>");
		CodingDt sect4orderedby = sect4.getOrderedBy().addCoding();
		sect4orderedby.setCode("system");
		sect4orderedby.setDisplay("Sorted by System");
		comp.addSection(sect4);
				
		//Participation in research  Section
		Section sect14 = new Section();
		sect14.setTitle("Participation in research");
		        
        CodingDt sect14code = sect14.getCode().addCoding();
		sect14code.setSystem("http://snomed.info/sct");
		sect14code.setCode("886751000000102");
		sect14code.setDisplay("Participation in research");
		sect14.getText().setDiv("<div><table><tbody><tr><th>Participation in research</th></tr><tr><td>None</td></tr></tbody></table></div>");
		CodingDt sect14orderedby = sect14.getOrderedBy().addCoding();
		sect14orderedby.setCode("system");
		sect14orderedby.setDisplay("Sorted by System");
		comp.addSection(sect14);
		        
		//Patient and carer concerns  Section
		Section sect15 = new Section();
		sect15.setTitle("Patient and carer concerns");
		        
		CodingDt sect15code = sect15.getCode().addCoding();
		sect15code.setSystem("http://snomed.info/sct");
		sect15code.setCode("887131000000107");
		sect15code.setDisplay("Patient and carer concerns");
		sect15.getText().setDiv("<div><table><tbody><tr><th>Patient and carer concerns</th></tr><tr><td>Concern re possibility of heart attack/similarity with mothers illness.</td></tr><tr><td>Worried about ability to drive and work/financial implications.</td></tr></tbody></table></div>");
		CodingDt sect15orderedby = sect15.getOrderedBy().addCoding();
		sect15orderedby.setCode("system");
		sect15orderedby.setDisplay("Sorted by System");
		comp.addSection(sect15);
		        
		//Person completing record  Section
		Section sect16 = new Section();
		sect16.setTitle("Person completing record");
		        
		CodingDt sect16code = sect16.getCode().addCoding();
		sect16code.setSystem("http://snomed.info/sct");
		sect16code.setCode("887231000000104");
		sect16code.setDisplay("Person completing record");
		sect16.getText().setDiv("<div><table><tbody><tr><th>Name</th><td>Dr Paul Rastall</td></tr><tr><th>Designation or role</th><td>On call Dr</td></tr><tr><th>Grade</th><td>SpR</td></tr><tr><th>Specialty</th><td>Medicine</td></tr></tbody></table></div>");
		CodingDt sect16orderedby = sect16.getOrderedBy().addCoding();
		sect16orderedby.setCode("system");
		sect16orderedby.setDisplay("Sorted by System");
		comp.addSection(sect16);
		        
		//Plan and requested actions  Section
		Section sect17 = new Section();
		sect17.setTitle("Plan and requested actions");
		        
	    CodingDt sect17code = sect17.getCode().addCoding();
		sect17code.setSystem("http://snomed.info/sct");
		sect17code.setCode("887201000000105");
		sect17code.setDisplay("Plan and requested actions");
		sect17.getText().setDiv("<div><table><tbody><tr><th>Actions</th></tr><tr><td>GP please continue secondary preventative medication.</td></tr><tr><td>Doses will be uptitrated by Cardiac Rehab team.</td></tr></tbody></table></div>");
		CodingDt sect17orderedby = sect17.getOrderedBy().addCoding();
		sect17orderedby.setCode("system");
		sect17orderedby.setDisplay("Sorted by System");
		comp.addSection(sect17);
		        
		//Procedures  Section
		Section sect18 = new Section();
		sect18.setTitle("Procedures");
		        
		CodingDt sect18code = sect18.getCode().addCoding();
		sect18code.setSystem("http://snomed.info/sct");
		sect18code.setCode("887171000000109");
		sect18code.setDisplay("Procedures");
		sect18.getText().setDiv("<div><table><tbody><tr><th>Procedures</th></tr><tr><td>Coronary Angiogram with stent to right coronary artery (RCA)</td></tr></tbody></table></div>");
		CodingDt sect18orderedby = sect18.getOrderedBy().addCoding();
		sect18orderedby.setCode("system");
		sect18orderedby.setDisplay("Sorted by System");
		comp.addSection(sect18);
		        
	    //Safety Alerts Section  Section
		Section sect6 = new Section();
		sect6.setTitle("Safety Alerts");
		        
		CodingDt sect6code = sect6.getCode().addCoding();
		sect6code.setSystem("http://snomed.info/sct");
		sect6code.setCode("886931000000107");
		sect6code.setDisplay("Safety Alerts");
		sect6.getText().setDiv("<div><table><tbody><tr><th>Safety Alerts</th></tr><tr><td>None</td></tr></tbody></table></div>");
		CodingDt sect6orderedby = sect6.getOrderedBy().addCoding();
		sect6orderedby.setCode("system");
		sect6orderedby.setDisplay("Sorted by System");
		comp.addSection(sect6);

	    //Social Context Section
		Section sect8 = new Section();
		sect8.setTitle("Social context");
		        
		CodingDt sect8code = sect8.getCode().addCoding();
		sect8code.setSystem("http://snomed.info/sct");
		sect8code.setCode("887051000000101");
		sect8code.setDisplay("Social context");
		sect8.getText().setDiv("<div><table><tbody><tr><th>Household composition</th><td>Lives alone</td></tr><tr><th>Lives alone</th><td>No</td></tr><tr><th>Occupational history</th><td>Self employed electrician</td></tr></tbody></table></div>");
		CodingDt sect8orderedby = sect8.getOrderedBy().addCoding();
		sect8orderedby.setCode("system");
		sect8orderedby.setDisplay("Sorted by System");
		comp.addSection(sect8);

		return comp;
	}

	
}

