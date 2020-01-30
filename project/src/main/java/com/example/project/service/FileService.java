package com.example.project.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import com.example.project.domain.Product;
import com.example.project.domain.Supplier;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    @Autowired
    private ProductService productservice;

    public String upload(MultipartFile file) {
        String dirName = File.separator + "temp";
        File dir = new File(dirName);

        if (!dir.exists())
            dir.mkdir();

        String filename = file.getOriginalFilename();
        String image = dir + File.separator + filename;
        File destFile = new File(image);

        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return image;
    }

    public void readExcel() throws IOException {
        FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\victor.souza\\Documents\\Java\\Spring\\decola.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();
        workbook.close();

        iterator.next();
        while (iterator.hasNext()) {

            Row currentRow = iterator.next();
            Product product = Product.builder().productname(currentRow.getCell(1).getStringCellValue()).
            supplierid(Supplier.builder().idsupplier((int) currentRow.getCell(2).getNumericCellValue()).build()).
            unitprice(currentRow.getCell(3).getNumericCellValue()).packagename(currentRow.getCell(4).
            getStringCellValue()).isdiscontinued(((int) currentRow.getCell(5).getNumericCellValue())==1).build();

            productservice.createProduct(product);
        }

    } 


}
