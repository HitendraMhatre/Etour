package com.etour.dto;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.etour.entities.Booking_Master;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class ProductPDFExporter {
    private Booking_Master invoice;

    public ProductPDFExporter(Booking_Master invoice) {
        this.invoice = invoice;
    }

    private void writeListHeader(List<Element> list) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(Color.BLUE);

        list.add(new Chunk("Booking ID: ", font));
        list.add(new Chunk(String.valueOf(invoice.getBookingid())));

        list.add(new Chunk("\nBooking Date: ", font));
        list.add(new Chunk(String.valueOf(invoice.getBookingdate())));

        list.add(new Chunk("\nNo of Passengers: ", font));
        list.add(new Chunk(String.valueOf(invoice.getNoofpassenger())));

        list.add(new Chunk("\nTour Amount: ", font));
        list.add(new Chunk(String.valueOf(invoice.getTouramount())));

        list.add(new Chunk("\nTaxes: ", font));
        list.add(new Chunk(String.valueOf(invoice.getTaxes())));

        list.add(new Chunk("\nTotal Amount: ", font));
        list.add(new Chunk(String.valueOf(invoice.getTotalamount())));

        list.add(new Chunk("\nMaster ID: ", font));
        list.add(new Chunk(String.valueOf(invoice.getBookmasterid())));

        list.add(new Chunk("\nCustomer ID: ", font));
        list.add(new Chunk(String.valueOf(invoice.getBookcustomerid())));

        list.add(new Chunk("\nDeparture ID: ", font));
        list.add(new Chunk(String.valueOf(invoice.getBookdepartureid())));

        list.add(new Chunk("\nStatus: ", font));
        list.add(new Chunk(invoice.isStatus() ? "Paid" : "Pending"));
    }

    private void writeListData(List<Element> list) {
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        list.add(new Chunk("Booking ID: ", font));
        list.add(new Chunk(String.valueOf(invoice.getBookingid())));

        list.add(new Chunk("\nBooking Date: ", font));
        list.add(new Chunk(String.valueOf(invoice.getBookingdate())));

        list.add(new Chunk("\nNo of Passengers: ", font));
        list.add(new Chunk(String.valueOf(invoice.getNoofpassenger())));

        list.add(new Chunk("\nTour Amount: ", font));
        list.add(new Chunk(String.valueOf(invoice.getTouramount())));

        list.add(new Chunk("\nTaxes: ", font));
        list.add(new Chunk(String.valueOf(invoice.getTaxes())));

        list.add(new Chunk("\nTotal Amount: ", font));
        list.add(new Chunk(String.valueOf(invoice.getTotalamount())));

        list.add(new Chunk("\nMaster ID: ", font));
        list.add(new Chunk(String.valueOf(invoice.getBookmasterid())));

        list.add(new Chunk("\nCustomer ID: ", font));
        list.add(new Chunk(String.valueOf(invoice.getBookcustomerid())));

        list.add(new Chunk("\nDeparture ID: ", font));
        list.add(new Chunk(String.valueOf(invoice.getBookdepartureid())));

        list.add(new Chunk("\nStatus: ", font));
        list.add(new Chunk(invoice.isStatus() ? "Paid" : "Pending"));
    }
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("INVOICE", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        p.setSpacingAfter(20);
        document.add(p);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {3.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);
        List<Element> list = new ArrayList<>();

        writeListHeader(list);

        for (Element e : list) {
            document.add(e);
        }

        Font footerFont = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE);
        footerFont.setSize(10);
        footerFont.setColor(Color.GRAY);

        Paragraph footer = new Paragraph("Thank you for your business", footerFont);
        footer.setAlignment(Paragraph.ALIGN_CENTER);
        footer.setSpacingBefore(10);
        document.add(footer);

        document.close();
    }
}
