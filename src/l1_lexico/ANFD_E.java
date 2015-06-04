package l1_lexico;

public class ANFD_E {
	
        private int [] cero = new int[30];
        private int [] uno = new int[30];
        private int [] vacio = new int[30];
        private int posicion;
        private int temp;
        
	public int getCero(int posicion) {
		return cero[posicion];
	}

	public void setCero(int posicion, int temp) {
		this.temp = temp;
                this.posicion = posicion;
                cero[posicion] = temp;
	}

	public int getUno(int posicion) {
		return uno[posicion];
	}
        
	public void setUno(int posicion, int temp) {
            	this.temp = temp;
                this.posicion = posicion;
		uno[posicion] = temp;
	}

	public int getVacio(int posicion) {
		return vacio[posicion];
	}
        
	public void setVacio(int posicion, int temp) {
            	this.temp = temp;
                this.posicion = posicion;
		vacio[posicion] = temp;
	}


}

