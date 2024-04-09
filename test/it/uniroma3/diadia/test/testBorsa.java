package it.uniroma3.diadia.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class testBorsa {
	
	Borsa borsa;
	Attrezzo attrezzo ;
	@BeforeEach
	public void setUp() {
		
		borsa =new Borsa(10);
		attrezzo = new Attrezzo("Osso",1);
	}

	@Test
	void testAddAttrezzoBorsaVuota() {
		
		borsa.addAttrezzo(attrezzo);
		
		assertEquals(attrezzo, borsa.getAttrezzo("Osso"));
	}
	
	@Test
	void testAddAttrezzoBorsaPiena() {
		
		Attrezzo attrezzo10 = new Attrezzo("Pistola",10);
		borsa.addAttrezzo(attrezzo10);
		borsa.addAttrezzo(attrezzo);
		
		assertFalse(borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	void testRemoveAttrezzo() {
		
		borsa.addAttrezzo(attrezzo);
		borsa.removeAttrezzo("Osso");
		
		assertTrue(borsa.isEmpty());
	}
	@Test
	void testRemoveAttrezzoBorsaVuota() {
		
		assertEquals(null, borsa.removeAttrezzo("Osso"));
	}
	
	@Test
	void testRemoveAttrezzoBorsaPienaAttrezzoInesistente() {
		
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		borsa.addAttrezzo(attrezzo);
		
		assertEquals(null, borsa.removeAttrezzo("Pistola"));
	}



}
