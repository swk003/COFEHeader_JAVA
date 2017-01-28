package uk.gov.nhsdigital.cofeheader.generate;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.Bundle.Entry;
import ca.uhn.fhir.model.dstu2.resource.Composition;
import ca.uhn.fhir.model.dstu2.resource.Encounter;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Patient;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.IGenericClient;

public class GenerateExamplar {

	public static void main(String[] args) {

		// create a context for DSTU2
		FhirContext ctx = FhirContext.forDstu2();
		// Create COFE Header XML Document
		Bundle bndl = CreateXMLDocument.createBundle();
		Composition cp = CreateXMLDocument.createComposition();
		Patient pt = CreateXMLDocument.createPatient();
		Practitioner prac = CreateXMLDocument.createPractitioner();
		Practitioner prac1 = CreateXMLDocument.createPractitioner1();
		Practitioner prac2 = CreateXMLDocument.createPractitioner2();
		Organization orgn = CreateXMLDocument.createOrganization();
		Organization orgn1 = CreateXMLDocument.createOrganization1();
		Encounter enc1 = CreateXMLDocument.createEncounter();
		//Due to 'Type mismatch: cannot convert from Location to Encounter.Location' Location code:
		ca.uhn.fhir.model.dstu2.resource.Location loc3 = CreateXMLDocument.createLocation();
		
		final Entry entryBundle = bndl.addEntry();		
		final Entry entryPrac = bndl.addEntry();
		final Entry entryPrac1 = bndl.addEntry();
		final Entry entryPrac2 = bndl.addEntry();
		final Entry entryOrg = bndl.addEntry();
		final Entry entryPat = bndl.addEntry();
		final Entry entryEnc = bndl.addEntry();
		final Entry entryLoc = bndl.addEntry();
		final Entry entryOrg1 = bndl.addEntry();
		
		entryBundle.setResource(cp);
		entryPrac.setResource(prac);
		entryPrac1.setResource(prac1);
		entryOrg.setResource(orgn);
		entryPat.setResource(pt);
		entryPrac2.setResource(prac2);
		entryEnc.setResource(enc1);
		entryOrg1.setResource(orgn1);
		entryLoc.setResource(loc3);
		
		// We can now use a parser to encode this resource into a string.
		String output = ctx.newXmlParser().setPrettyPrint(true).encodeResourceToString(bndl);
		System.out.println(output);
		
		//create client
		String serverBaseUrl = "http://fhirtest.uhn.ca/baseDstu2";
		//String serverBaseUrl = "http://fhir3.healthintersections.com.au/open";
		IGenericClient client = ctx.newRestfulGenericClient(serverBaseUrl);
		
		//use client to store a new resource instance
		MethodOutcome outcome = client.create().resource(bndl).execute();
		System.out.println(outcome.getId());
		
	}
	
}