public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        // Torna this.letrasJaDigitadas igual ao String vazio
        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        // Percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo
        return this.letrasJaDigitadas.indexOf(letra) != -1;
    }

    public void registre (char letra) throws Exception
    {
		// Verifica se a letra fornecida ja foi digitada (pode usar
		// o m�todo this.isJaDigitada, para isso), lancando uma exce��o
		// em caso afirmativo.
		// Concatena a letra fornecida a this.letrasJaDigitadas.
        if (isJaDigitada(letra)) {
            throw new Exception("Letra já digitada");
        }
        this.letrasJaDigitadas += letra;
    }

    @Override
    public String toString ()
    {
		// retorna um String com TODAS as letras presentes em
		// this.letrasJaDigitadas separadas por v�rgula (,).
        return String.join(",", letrasJaDigitadas.split(""));
    }

    @Override
    public boolean equals(Object obj) {
        // Verifica se this e obj são iguais
        if (this == obj) return true; // Verifica se são o mesmo objeto
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica se obj é null ou de classe diferente

        ControladorDeLetrasJaDigitadas that = (ControladorDeLetrasJaDigitadas) obj; // Cast para o tipo correto
        return this.letrasJaDigitadas.equals(that.letrasJaDigitadas); // Compara o atributo letrasJaDigitadas
    }

    @Override
    public int hashCode() {
        // Calcula e retorna o hashcode de this
        int ret = 1;

        ret = ret * 7 + (letrasJaDigitadas != null ? letrasJaDigitadas.hashCode() : 0);

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    public ControladorDeLetrasJaDigitadas
            (ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
            throws Exception { // Construtor de cópia
        // Copia c.letrasJaDigitadas em this.letrasJaDigitadas
        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    @Override
    public Object clone() {
        // Cria uma cópia do this com o construtor de cópia e retorna
        try {
            return super.clone(); // Utiliza o método clone da classe Object
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); // Em caso de erro, lança uma exceção em tempo de execução
        }
    }
}
