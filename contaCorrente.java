class contaCorrente extends conta {
    // Construtor
    public contaCorrente(String nome, int ag, int co, double saldo) {
        super(nome, ag, co, saldo); // Senha não é necessária para conta corrente
    }
}