package l1_lexico;

public class ANFD {

        private int [] elemento = new int[30];    
        private int [] cero = new int[30];
        private int [] uno = new int[30];
        private int posicion;
        private int temp;
        private int puntero_elemento;
    
        public int getElemento(int posicion) {
		return elemento[posicion];
	}

	public void setElemento(int posicion, int temp) {
		this.temp = temp;
                this.posicion = posicion;
                elemento[posicion] = temp;
	}

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

        public int getPuntero_elemento() {
            return puntero_elemento;
        }

        public void setPuntero_elemento(int puntero_elemento) {
            this.puntero_elemento = puntero_elemento;
        }


}

