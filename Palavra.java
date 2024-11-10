public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
		// Verifica se o texto recebido � nulo ou ent�o vazio,
		// ou seja, sem nenhum caractere, lan�ando exce��o.
		// armazena o texto recebido em this.texto.
        if (texto == null || texto.isEmpty()) {
            throw new Exception("Texto inválido.");
        }
        this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        // Percorre o String this.texto, conta e retorna
        // quantas letras existem nele iguais a letra fornecida
        int count = 0;
        for (int i = 0; i < this.texto.length(); i++) {
            if (this.texto.charAt(i) == letra) {
                count++;
            }
        }
        return count;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        // Se i==0, retorna a posicao em que ocorre a primeira
        // aparicao de letra fornecida em this.texto;
        // Se i==1, retorna a posicao em que ocorre a segunda
        // aparicao de letra fornecida em this.texto;
        // Se i==2, retorna a posicao em que ocorre a terceira
        // aparicao de letra fornecida em this.texto;
        // E assim por diante.
        // Lan�ar excecao caso nao encontre em this.texto
        // a I�zima apari��o da letra fornecida.
        int count = 0;
        for (int j = 0; j < this.texto.length(); j++) {
            if (this.texto.charAt(j) == letra) {
                if (count == i) {
                    return j;  // Retorna a posição da i-ésima ocorrência
                }
                count++;
            }
        }
        throw new Exception("Não encontrada a " + (i + 1) + "ª ocorrência da letra '" + letra + "'.");
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }

    @Override
    public boolean equals (Object obj)
    {
        // Verificar se this e obj possuem o mesmo conte�do, retornando
        // true no caso afirmativo ou false no caso negativo
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Palavra palavra = (Palavra) obj;
        return this.texto.equals(palavra.texto);
    }

    @Override
    public int hashCode() {
        // Calcular e retornar o hashcode de this
        int ret = 1; // Valor inicial qualquer (positivo)

        // Atributo 'texto' é do tipo String, portanto, usamos o hashCode da string.
        ret = ret * 7 + this.texto.hashCode(); // multiplicamos por 7, um número primo arbitrário

        if (ret < 0)
            ret = -ret;

        return ret; // Retornamos o valor calculado
    }

    @Override
    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
