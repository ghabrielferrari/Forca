public class Tracinhos implements Cloneable
{
    private char texto [];

    public Tracinhos (int qtd) throws Exception
    {
		// Verifica se qtd n�o � positiva, lan�ando uma exce��o.
		// Instancia this.texto com um vetor com tamanho igual qtd.
		// Preenche this.texto com underlines (_).
        if (qtd <= 0) {
            throw new Exception("A quantidade de tracinhos deve ser positiva.");
        }
        this.texto = new char[qtd];
        for (int i = 0; i < qtd; i++) {
            this.texto[i] = '_'; // Preenche o vetor com underline
        }
    }

    public void revele (int posicao, char letra) throws Exception
    {
		// Verifica se posicao � negativa ou ent�o igual ou maior
		// do que this.texto.length, lan�ando uma exce��o.
		// Armazena a letra fornecida na posicao tambem fornecida
		// do vetor this.texto
        if (posicao < 0 || posicao >= this.texto.length) {
            throw new Exception("Posição inválida.");
        }
        this.texto[posicao] = letra; // Substitui o underline pela letra
    }

    public boolean isAindaComTracinhos ()
    {
        // Percorre o vetor de char this.texto e verifica
        // se o mesmo ainda contem algum underline ou se ja
        // foram todos substituidos por letras; Retornar true
        // caso ainda reste algum underline, ou false caso
        // contrario
        for (char c : this.texto) {
            if (c == '_') {
                return true; // Ainda tem tracinhos
            }
        }
        return false; // Não tem mais tracinhos
    }

    @Override
    public String toString ()
    {
        // Retorna um String com TODOS os caracteres que h�
        // no vetor this.texto, intercalados com espa�os em
        // branco
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.texto.length; i++) {
            sb.append(this.texto[i]);
            if (i < this.texto.length - 1) {
                sb.append(" "); // Adiciona um espaço entre os caracteres
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals (Object obj)
    {
        // Verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tracinhos tracinhos = (Tracinhos) obj;
        if (this.texto.length != tracinhos.texto.length) return false;
        for (int i = 0; i < this.texto.length; i++) {
            if (this.texto[i] != tracinhos.texto[i]) {
                return false; // Verifica se os conteúdos dos vetores são iguais
            }
        }
        return true;
    }

    @Override
    public int hashCode ()
    {
        // Calcular e retornar o hashcode de this
        int ret = 1;
        for (char c : this.texto) {
            ret = 31 * ret + c; // Calcula o hashcode combinando os caracteres
        }

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    public Tracinhos (Tracinhos t) throws Exception // construtor de c�pia
    {
        // Intanciar this.texto um vetor com o mesmo tamanho de t.texto
        // e copilar o conte�do de t.texto para this.texto
        this.texto = new char[t.texto.length];
        System.arraycopy(t.texto, 0, this.texto, 0, t.texto.length); // Copia o conteúdo do vetor
    }

    @Override
    public Object clone ()
    {
        // Retornar uma copia de this
        try {
            return new Tracinhos(this); // Retorna uma cópia do objeto Tracinhos
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Em caso de erro, retorna null
        }
    }
}
