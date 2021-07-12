package io.github.brunaoflofl.clientes.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class BigDecimalConverter {
	
	public BigDecimal converter(String value) {
		if(value == null) {
			return null;
		}
	
		 value = value.replace(target: ".", replacement: "").replace(target: ",", replacement: ".");
			return new BigDecimal(value);
	}

}
