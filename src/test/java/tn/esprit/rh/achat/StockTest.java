package tn.esprit.rh.achat;



import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.services.IStockService;


@SpringBootTest

public class StockTest {
	@Autowired
	private IStockService stockservice;
	
	@Test
	public void testAddStock() {
		Stock s = new Stock("stock test",100,10);
		Stock savedStock= stockservice.addStock(s);
		assertEquals(s.getLibelleStock(), savedStock.getLibelleStock());
		}
	
	@Test
	public void testDeleteStock() {
		stockservice.deleteStock(11L);
	assertNull(stockservice.retrieveStock(11L));
	}
	
	@Test
	public void testRetrieveAllStocks() {
	java.util.List<Stock> allStocks = stockservice.retrieveAllStocks();
	assertEquals(8, allStocks.size());
	}
	
	@Test
	public void testRetrieveStock() {
	Stock stock = stockservice.retrieveStock(2L);
	assertEquals(2L, stock.getIdStock());
	}
	
}
