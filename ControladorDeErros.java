public class ControladorDeErros implements Cloneable
{
    private int qtdMax, qtdErr=0;

    public ControladorDeErros (int qtdMax) throws Exception
    {
        // Verifica se qtdMax fornecida n�o � positiva, lan�ando
        // uma exce��o.
        // Armazena qtdMax fornecida em this.qtdMax.
        if (qtdMax<0) throw new Exception ("Quantidade invalida");

        this.qtdMax=qtdMax;
    }

    public void registreUmErro () throws Exception
    {
        // Verifica se this.qtdErr ja � igual a this.qtdMax,
        // lan�ando excecao em caso positivo ou
        // incrementando this.qtdErr em caso negativo
        if (this.qtdErr==this.qtdMax) throw new Exception ("Errou alem do maximo");

        this.qtdErr++;
    }

    public boolean isAtingidoMaximoDeErros  ()
    {
        // Returna true se this.qtdErr for igual a this.qtdMax,
        // Ou ent�o false, caso contrario.
        /*
        if (this.qtdErr==this.qtdMax)
            return true;
        else
            return false;
        */

        return this.qtdErr==this.qtdMax;
    }

    @Override
    public String toString ()
    {
        return this.qtdErr + "/" + this.qtdMax;
    }

    @Override
    public boolean equals(Object obj) {
        // Verificar se this e obj possuem o mesmo conteúdo,
        // retornando true no caso afirmativo ou false no caso negativo
        if (this == obj) return true; // Verifica se são o mesmo objeto
        if (obj == null || getClass() != obj.getClass()) return false; // Verifica se obj é null ou de classe diferente

        ControladorDeErros that = (ControladorDeErros) obj; // Cast para o tipo correto
        return this.qtdMax == that.qtdMax && this.qtdErr == that.qtdErr; // Compara os atributos
    }

    @Override
    public int hashCode ()
    {
        // Calcular e retornar o hashcode de this

        int ret = 1; // Valor inicial qualquer (positivo)
        if (ret < 0)
            ret = -ret;

        return 31 * qtdMax + qtdErr;
    }

    public ControladorDeErros(ControladorDeErros c) throws Exception { // Construtor de cópia
        // Copiar c.qtdMax e c.qtdErr, respectivamente em this.qtdMax e this.qtdErr
        this(c.qtdMax); // Chama o construtor principal
        this.qtdErr = c.qtdErr; // Copia a quantidade de erros
    }

    @Override
    public Object clone() {
        // Retorna uma cópia de this
        try {
            return super.clone(); // Utiliza o método clone da classe Object
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e); // Em caso de erro, lança uma exceção em tempo de execução
        }
    }
}
