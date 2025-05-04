package br.dev.roger.lopal_calculadora_de_rede.model;

public class ClassificarIP {

    private String EnderecoIP;
    private int primeiroOcteto;
    private String cidr;

    public String getEnderecoIP() {
        return EnderecoIP;
    }

    public void setEnderecoIP(String enderecoIP) {
        this.EnderecoIP = enderecoIP;

        // Divide por "." e pega o primeiro octeto como inteiro
        String[] partes = enderecoIP.split("\\.");
        if (partes.length >= 1) {
            try {
                this.primeiroOcteto = Integer.parseInt(partes[0]);
            } catch (NumberFormatException e) {
                this.primeiroOcteto = -1; // Valor inválido
            }
        }
    }

    public String ClassificarRede() {
        if (primeiroOcteto >= 1 && primeiroOcteto <= 126) {
            return "Classe A";
        } else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
            return "Classe B";
        } else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
            return "Classe C";
        } else if (primeiroOcteto >= 224 && primeiroOcteto <= 239) {
            return "Classe D (Multicast)";
        } else if (primeiroOcteto >= 240 && primeiroOcteto <= 255) {
            return "Classe E (Reservada)";
        } else {
            return "Classe desconhecida ou inválida";
        }
    }
    
    public String calcularMascaraDecimal() {
        
        String[] partes = EnderecoIP.split("/");
        if (partes.length == 2) {
            String cidr = partes[1];  // guarda o número após a barra
            this.cidr = cidr;
                    
            switch (cidr) {
            case "8":
                return "255.0.0.0";
            case "16":
                return "255.255.0.0";
            case "24":
                return "255.255.255.0";
            case "25":
                return "255.255.255.128";
            case "26":
                return "255.255.255.192";
            case "27":
                return "255.255.255.224";
            case "28":
                return "255.255.255.240";
            case "29":
                return "255.255.255.248";
            case "30":
                return "255.255.255.252";
            case "31":
                return "255.255.255.254";
            case "32":
                return "255.255.255.255";
            default:
                return "Sufixo inválido";
        }
            
    } else {
        return "IP inválido (sem sufixo)";
    }
    
    
    }
    
    public String converterDecimalParaBinario() {
        String[] octetos = calcularMascaraDecimal().split("\\.");
        StringBuilder binario = new StringBuilder();

        for (int i = 0; i < octetos.length; i++) {
            int valor = Integer.parseInt(octetos[i]); // ex: 255
            String bin = String.format("%8s", Integer.toBinaryString(valor)).replace(' ', '0');
            binario.append(bin);

            if (i < 3) {
                binario.append(".");
            }
        }

        return binario.toString();
    }
    
    public String CalcularHosts() {
        int hosts = Integer.parseInt(cidr);
        int nHosts = (int) (Math.pow(2, (32 - hosts)) - 2);
        return nHosts + ""; 
    }
}