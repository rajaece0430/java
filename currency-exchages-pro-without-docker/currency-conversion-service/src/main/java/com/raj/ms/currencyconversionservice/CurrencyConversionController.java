package com.raj.ms.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		HashMap<String,String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to);
		
		ResponseEntity<CurrencyConversion> responsEntity = new RestTemplate().
		getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversion.class,uriVariable);
		
		CurrencyConversion  currCov = responsEntity.getBody();
		
		return new CurrencyConversion(currCov.getId(),from,to,quantity,
				currCov.getConversionMultiple(),quantity.multiply(currCov.getConversionMultiple()),currCov.getEnvironment()+" "+"Rest Template");
		
		//return new CurrencyConversion(1000L,from,to,quantity,BigDecimal.ONE,BigDecimal.ONE,"");
		
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(
			@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		
		CurrencyConversion  currCov = proxy.retrieveExchangeValue(from, to);
		
		return new CurrencyConversion(currCov.getId(),from,to,quantity,
				currCov.getConversionMultiple(),quantity.multiply(currCov.getConversionMultiple()),currCov.getEnvironment()+" "+"Feign");
		
	}
}
