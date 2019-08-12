package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private InvoiceDao invoiceDao;
    private static final String PRODUCT_NAME = "Pen";
    private static final String INVOICE_NUMBER = "02082019";

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Product product = new Product(PRODUCT_NAME);
        productDao.save(product);
        Item item1 = new Item(product, new BigDecimal(10), 10);
        Item item2 = new Item(product, new BigDecimal(20), 20);
        Invoice invoice = new Invoice(INVOICE_NUMBER);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);

        //When
        invoiceDao.save(invoice);
        List<Item> itemsByProduct = itemDao.findByProduct(product);
        List<Item> itemsByInvoice = itemDao.findByInvoice(invoice);

        //Then
        Assert.assertEquals(2, itemsByProduct.size());
        Assert.assertEquals(2, itemsByInvoice.size());

        //CleanUp
        invoiceDao.deleteById(invoice.getId());
        productDao.deleteById(product.getId());
    }
}
