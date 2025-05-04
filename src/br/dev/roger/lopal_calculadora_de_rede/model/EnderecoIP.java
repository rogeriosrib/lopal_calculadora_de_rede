package br.dev.roger.lopal_calculadora_de_rede.model;

public class EnderecoIP {

    private String enderecoCompleto; // Ex: "192.168.0.1/24"
    private String ip;               // Ex: "192.168.0.1"
    private String cidr;            // Ex: "24"
    private int primeiroOcteto;

    public void setEnderecoIP(String enderecoIP) {
        this.enderecoCompleto = enderecoIP;

        String[] partesBarra = enderecoIP.split("/");
        this.ip = partesBarra[0];
        this.cidr = (partesBarra.length > 1) ? partesBarra[1] : null;

        // Divide IP por "." e pega o primeiro octeto
        String[] partesIP = ip.split("\\.");
        if (partesIP.length >= 1) {
            try {
                this.primeiroOcteto = Integer.parseInt(partesIP[0]);
            } catch (NumberFormatException e) {
                this.primeiroOcteto = -1;
            }
        }
    }

    public String getEnderecoIP() {
        return enderecoCompleto;
    }

    public String getIP() {
        return ip;
    }

    public String getCIDR() {
        return cidr;
    }

    public int getPrimeiroOcteto() {
        return primeiroOcteto;
    }
}
