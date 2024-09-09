/**
 * @author Elias-Fereira
 */

public class Carro {
    private Boolean estaLigado = false;
    private int velocidadeAtual = 0;
    private int velocidadeMaxima = 120;
    private int combustivel = 40;
    public  String mensagemDeErro = "Por faovr Lige o carro";

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
     *@param(null) Este metodo Não recebe parametros
     *
     *@return Este metodo altera o valor da varaioavel estaLigado, e a varaialvel velocidadeAtual para 0
     */
    public void ligarOuDesligarCarro() {
       this.estaLigado = !this.estaLigado;
       this.combustivel -= 5;
       velocidadeAtual = 0;
    }


    /**
     *@param(null) Este metodo Não recebe parametros
     *
     *@throws this.mensagemDeErro caso o carro esteja desligado,sem combustivel ou esteja na velocidade maxiam.
     *
     *@return  Este metodo altera o valor da varaioavel velocidadeAtual ate o maximo de 120
     */
    public void acelerar() {
        if (this.estaLigado){
            if(this.combustivel == 0 ) {
                System.out.print("O Carro ficou sem combustivel! por favor REABASTEÇA");
            }else
                if(this.velocidadeAtual == this.velocidadeMaxima) {
                System.out.print("O carro ja esta na velocidade Maxima!");
                    }else
                        this.velocidadeAtual += 10;
                        this.combustivel -= 5;
            } else System.out.println(mensagemDeErro);
        }


    /**
     *@param(null) Este metodo Não recebe parametros
     *
     *@throws this.mensagemDeErro caso o carro esteja desligado, ou se a velocidadeAtual for igual a 0.
     *
     *@return  Este metodo decrementa o valor da varaioavel velocidadeAtual ate que ele chegue a 0
     */
    public void desacelerar () {
        if (this.estaLigado){
            if(this.combustivel == 0 ) {
                System.out.print("O Carro ficou sem combustivel! por favor REABASTEÇA");
            }else
            if(this.velocidadeAtual == 0) {
                this.estaLigado = false;
                System.out.print("O carrto parou! Por favor ligue o carro novamente!");
            }else
                this.velocidadeAtual -= 10;
            this.combustivel -= 5;
        } else System.out.println(mensagemDeErro);
    }


    /**
     *@param(null) Este metodo Não recebe parametros
     *
     *@throws this.mensagemDeErro caso o carro esteja Ligado.
     *
     *@return  Este metodo altera o valor da varaioavel combustivel para 40
     */
    public void reabastecer () {
        if (estaLigado){
            System.out.println("Por favor Desligue o carro antes de reabastecer!");
        } else
            if(this.combustivel == 40){
            System.out.print("O tanque de combustivel esta cheio!");
        } else this.combustivel = 40;
    }


    /**
     *@param(null) Este metodo Não recebe parametros
     *
     *@return  Este metodo Imprime o valor atual das variaveis do carro instanciado no console
     */
    public void getStats () {
        System.out.println("-------------------------------------");
        System.out.println("O status atual do carro é:");
        System.out.println("Esata:" + " " + (this.estaLigado? "Ligado" : "Desligado") );
        System.out.println("Velocidade:" + " " + this.velocidadeAtual);
        System.out.println("Combustivel:" + " " + this.combustivel );
        System.out.println("-------------------------------------");
    }
}