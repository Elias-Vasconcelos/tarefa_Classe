/**
 * @author Elias-Fereira
 */
public class Carro {
    private Boolean estaLigado = false;
    private int velocidadeAtual = 0;
    private int velocidadeMaxima = 120;
    private int combustivel = 40;
    public String mensagemDeErro = "Por favor, ligue o carro";

    public static void main(String[] args) {
        Carro carroDeCorrida = new Carro();

        carroDeCorrida.ligarOuDesligarCarro();
        carroDeCorrida.acelerar();
        carroDeCorrida.acelerar();
        carroDeCorrida.acelerar();
        carroDeCorrida.ligarOuDesligarCarro();
        carroDeCorrida.reabastecer();
        carroDeCorrida.ligarOuDesligarCarro();
        carroDeCorrida.acelerar();
        carroDeCorrida.acelerar();
        carroDeCorrida.desacelerar();

        carroDeCorrida.getStats();
    }

    /**
     * Liga ou desliga o carro.
     *
     * @return Este método altera o valor da variável estaLigado e reseta a velocidadeAtual para 0.
     */
    public void ligarOuDesligarCarro() {
        this.estaLigado = !this.estaLigado;
        this.combustivel -= 5;
        velocidadeAtual = 0;
    }

    /**
     * Acelera o carro.
     *
     * @throws IllegalStateException caso o carro esteja desligado, sem combustível ou na velocidade máxima.
     * @return Este método aumenta a velocidadeAtual até o máximo de 120.
     */
    public void acelerar() {
        if (this.estaLigado) {
            if (this.combustivel == 0) {
                System.out.println("O carro ficou sem combustível! Por favor, reabasteça.");
            } else if (this.velocidadeAtual == this.velocidadeMaxima) {
                System.out.println("O carro já está na velocidade máxima!");
            } else {
                this.velocidadeAtual += 10;
                this.combustivel -= 5;
            }
        } else {
            throw new IllegalStateException(mensagemDeErro);
        }
    }

    /**
     * Desacelera o carro.
     *
     * @throws IllegalStateException caso o carro esteja desligado ou a velocidadeAtual seja igual a 0.
     * @return Este método reduz a velocidadeAtual até 0.
     */
    public void desacelerar() {
        if (this.estaLigado) {
            if (this.combustivel == 0) {
                System.out.println("O carro ficou sem combustível! Por favor, reabasteça.");
            } else if (this.velocidadeAtual == 0) {
                this.estaLigado = false;
                System.out.println("O carro parou! Por favor, ligue o carro novamente.");
            } else {
                this.velocidadeAtual -= 10;
                this.combustivel -= 5;
            }
        } else {
            throw new IllegalStateException(mensagemDeErro);
        }
    }

    /**
     * Reabastece o carro.
     *
     * @throws IllegalStateException caso o carro esteja ligado.
     * @return Este método preenche o combustível até 40.
     */
    public void reabastecer() {
        if (estaLigado) {
            throw new IllegalStateException("Por favor, desligue o carro antes de reabastecer!");
        } else if (this.combustivel == 40) {
            System.out.println("O tanque de combustível está cheio!");
        } else {
            this.combustivel = 40;
        }
    }

    /**
     * Exibe o status atual do carro.
     *
     * @return Este método imprime o valor atual das variáveis do carro no console.
     */
    public void getStats() {
        System.out.println("-------------------------------------");
        System.out.println("O status atual do carro é:");
        System.out.println("Está: " + (this.estaLigado ? "Ligado" : "Desligado"));
        System.out.println("Velocidade: " + this.velocidadeAtual);
        System.out.println("Combustível: " + this.combustivel);
        System.out.println("-------------------------------------");
    }
}
