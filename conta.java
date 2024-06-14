abstract class conta {
    private String nome;
    private int ag;
    private int co;
    private double saldo;
    private static String senha = "sim";

    static int total = 0;

    public conta(String nome, int ag, int co, double saldo) {
        conta.total++;
        setName(nome);
        setAg(ag);
        setCo(co);
        setSaldo(saldo);
    }

    public static String getSenha() {
        return senha;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public int getAg() {
        return ag;
    }

    public void setAg(int agencia) {
        this.ag = agencia;
    }

    public int getCo() {
        return co;
    }

    public void setCo(int conta) {
        this.co = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double Deposito(double valor) {
        saldo += valor;
        return saldo;
    }

    public double saque(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return saldo;
        } else {
            System.out.println("Saldo insuficiente.");
            return saldo;
        }
    }
}
