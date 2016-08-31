package com.citizant.kudos.reporting;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.citizant.kudos.util.StringUtil;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class PdfGenerator {

    private static Log log = LogFactory.getLog(PdfGenerator.class);

	public static byte[] generatePDF(KudoReport report) {
		try {
			Map<String, Object> parameters = new HashMap<>();
			parameters.put("reportTitle", report.getReportTitle());
			
			parameters.put("column1", report.getColumnTitle1());
			parameters.put("column2", report.getColumnTitle2());
			parameters.put("column3", report.getColumnTitle3());
					
			JasperPrint print = JasperFillManager.fillReport(report.getReportTemplate(), parameters,
					new JRBeanCollectionDataSource(report.getData()));

			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			
			ByteArrayOutputStream o = new ByteArrayOutputStream();
			
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, o); 
			
			exporter.exportReport();
			
			return o.toByteArray();
			
		} catch (JRException e) {
			log.error(e);
		}
		
		return new byte[] {};
	}
	
}
