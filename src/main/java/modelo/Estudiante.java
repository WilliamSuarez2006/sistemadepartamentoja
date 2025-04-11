package modelo;

public class Estudiante {
    private String Nomb;
    private String Documento;
    private String Tdocumento;

    public Estudiante() {
        this.Documento = "";
        this.Tdocumento = "";
        this.Nomb = "";
    }
    public Estudiante(String documento, String tdocumento, String nomb) {
        this.Documento = documento;
        this.Tdocumento = tdocumento;
        this.Nomb = nomb;
    }

    public String getNomb() {
        return Nomb;
    }

    public void setNomb(String nomb) {
        Nomb = nomb;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String documento) {
        Documento = documento;
    }

    public String getTdocumento() {
        return Tdocumento;
    }

    public void setTdocumento(String tdocumento) {
        Tdocumento = tdocumento;
    }
}


