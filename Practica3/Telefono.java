public class Telefono {
    String  residencia, lada, numero, numDeTelefono;

	public Telefono(){
    this.residencia = "+52";
    this.lada = "981";
    this.numero = "1577863";
    this.numDeTelefono = residencia.concat(" "+lada+numero);
    }
    public String toString(){
        return numDeTelefono;
    }
}
