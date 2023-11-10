package com.demo.example.address.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


public class PdfService {
	private Logger logger=LoggerFactory.getLogger(PdfService.class);

	@PostMapping("/createPdf")
	public ByteArrayInputStream createPdf() {
		logger.info("Create pdf started:");
		
		String title="welcome to coding Nepal";
	    String content="we are the group of coders of Nepal";
	    
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    
	    Document document=new Document();
	   
	    PdfWriter.getInstance(document, out);
	    document.open();
	    
	    Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	    Paragraph titlepara = new Paragraph(title,titleFont);
	    titlepara.setAlignment(Element.ALIGN_CENTER);
	    document.add(titlepara);
	    
	    Font paraFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	    Paragraph paragraph=new Paragraph(content);
	    document.add(paragraph);
	    
	    document.close();
	    
	    return new ByteArrayInputStream(out.toByteArray());
	}
	
	
	
}
