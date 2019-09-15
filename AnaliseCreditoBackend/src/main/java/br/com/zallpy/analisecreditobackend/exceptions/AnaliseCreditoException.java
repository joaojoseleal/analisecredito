package br.com.zallpy.analisecreditobackend.exceptions;

public class AnaliseCreditoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AnaliseCreditoException(String message, Exception e) {
        super(message,e);
    }
    public AnaliseCreditoException(String message) {
        super(message);
    }


}
