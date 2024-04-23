package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {

	@Override
	public void esegui(Partita partita) {
		
		partita.getIo().mostraMessaggio("Comando non valido \n");

	}

	@Override
	public void setParametro(String parametro) {
		
	}

	@Override
	public String getParametro() {
		
		return null;
	}

	@Override
	public String getNome() {
		
		return "non valido";
	}

}
