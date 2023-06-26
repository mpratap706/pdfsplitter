package org.example;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import  java.io.IOException;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {

    File oldfile = new File("C:\\Users\\KIIT\\Downloads\\pdfsplitter\\sample.pdf");
    PDDocument document = PDDocument.load(oldfile);

    File newFileDestination = new File("C:\\Users\\KIIT\\Downloads\\pdfsplitter\\extract");
    newFileDestination.mkdirs();

    Splitter splitter = new Splitter();
    splitter.setStartPage(11);
    splitter.setEndPage(299);
    List<PDDocument> splitPages = splitter.split(document);
    PDDocument newDoc = new PDDocument();
    for(PDDocument mydoc: splitPages)
    {newDoc.addPage (mydoc.getPage(0));}


newDoc.save( newFileDestination+ "split.pdf");
    newDoc.close();
    System.out.println("PDF CREATED");

}}