package dim.servlets;

import dim.service.CSVservice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dkomp on 28/6/2016.
 */
public class CSVServlet extends HttpServlet {

    final CSVservice csvService = new CSVservice();

    public void init() throws ServletException
    {
        // Do required initialization
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/csv");
        response.setHeader("Content-Disposition", "attachment;filename=\"test.csv\"");
//        csvService.generateCsvFile(response.getOutputStream());
        response.getOutputStream().print(csvService.generateCSV());
    }
}