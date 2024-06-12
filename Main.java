import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner teclado = new Scanner(System.in);
        // criando um array para as contas
        conta[] contas = new conta[2];
        contas[0] = new contaCorrente("Tallys", 205, 3120, 3500);
        contas[1] = new contaCorrente("Ester", 301, 3146, 2000);
        int index = 0;
        while (true) {
            System.out.println("---------- Cadastro ----------");
            System.out.println("Você deseja se cadastrar? S/N");
            String resposta = teclado.nextLine();
            if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("SIM")) {
                System.out.println("Digite seu Nome: ");
                String r1 = teclado.nextLine();
                System.out.println("Digite sua Agencia: ");
                int r2 = teclado.nextInt();
                System.out.println("Digite sua Conta: ");
                int r3 = teclado.nextInt();
                System.out.println("Obrigatorio o Deposito Inicial no minino 10 reais. ");
                teclado.nextLine();
                System.out.println("Insira o valor do deposito: ");
                double depositoInicial = teclado.nextDouble();
                System.out.println("Esperando o comprovante de pagamento...");
                Thread.currentThread();
                Thread.sleep(2000);
                // fazer uma comprovaçao do comprovante tipo enviar um mensagem pra um numero
                System.out.println("Comprovante Confirmado!");
                double r5 = depositoInicial;
                // quando comprovar fazer um insert into no BD
                contaCorrente novaConta = new contaCorrente(r1, r2, r3, r5);
                contas[index] = novaConta;
                index++;
                System.out.println("Conta Cadastrada com sucesso!");
                teclado.nextLine();
            }
            // fazer uma classe login
            System.out.println("Você Deseja Entrar na Sua Conta? S/N");
            String login = teclado.nextLine();
            if (login.equalsIgnoreCase("S") || login.equalsIgnoreCase("SIM")) {
                boolean logado = false;
                while (!logado) {
                    // Entrada de Dados
                    System.out.println("    -------------------BancoDev------------------   ");
                    System.out.println("Digite sua Agencia: ");
                    int agenciaEntrada = teclado.nextInt();
                    teclado.nextLine(); // Consumir a quebra de linha pendente
                    System.out.println("Digite sua Conta: ");
                    int contaEntrada = teclado.nextInt();
                    teclado.nextLine(); // Consumir a quebra de linha pendente

                    // procurando a conta
                    conta contaSelecionada = null;
                    for (conta conta : contas) {
                        if (conta.getAg() == agenciaEntrada && conta.getCo() == contaEntrada) {
                            contaSelecionada = conta;
                            break;
                        }

                    }

                    if (contaSelecionada != null) {
                        logado = true;// usuario logado
                        System.out.println("Olá Sr(a) " + contaSelecionada.getName() + ", seu saldo é R$: "
                                + contaSelecionada.getSaldo());

                        System.out.println("Você deseja fazer um depósito? S / N : ");
                        String dep = teclado.nextLine();

                        if (dep.equalsIgnoreCase("S") || dep.equalsIgnoreCase("Sim")) {
                            System.out.println("Digite o valor: ");
                            double novoSaldo = contaSelecionada.Deposito(teclado.nextDouble());
                            teclado.nextLine();
                            System.out.println(
                                    "Sr(a) " + contaSelecionada.getName() + ", seu novo saldo é : " + novoSaldo);
                        }
                        if (logado == true) {
                            System.out.println("Você deseja fazer uma retirada? S / N : ");
                            String saq = teclado.nextLine();
                            if (saq.equalsIgnoreCase("S") || saq.equalsIgnoreCase("SIM")) {
                                System.out.println("Digite o valor: ");
                                boolean valor = true;
                                double saque = teclado.nextDouble();
                                double saqueSaldo = contaSelecionada.saque(saque);
                                teclado.nextLine();
                                if (valor == true) {
                                    System.out.println(
                                            "Para confirmar o saque de R$ " + saque + " por favor digite a senha: ");
                                    String senhas;
                                    senhas = teclado.nextLine();
                                    if (Objects.equals(senhas, conta.getSenha())) {

                                        System.out.println("Sr(a) " + contaSelecionada.getName()
                                                + ", seu novo saldo é : " + saqueSaldo);

                                    } else {
                                        System.out.println("Senha Incorreta!");

                                    }
                                }
                            } else {
                                System.out.println("Obrigado Sr(a) " + contaSelecionada.getName() + ".");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Agência ou Conta Erradas. Deseja tentar novamente? (S / N)");
                        String tentarNovamente = teclado.next();
                        if (tentarNovamente.equalsIgnoreCase("NAO") || tentarNovamente.equalsIgnoreCase("N")) {
                            System.out.println("Obrigado!!");
                            // Se o usuário não quiser tentar novamente, saímos do loop
                            return;
                        }
                    }

                }
            } else {
                System.out.println("Obrigado!!!");
                break;
            }
            System.out.println("Contas Instaciadas: " + contaCorrente.total);

        }
    }
}
