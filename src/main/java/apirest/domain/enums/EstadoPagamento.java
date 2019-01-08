package apirest.domain.enums;

public enum EstadoPagamento {

    PENDENTE(1,"Pendente"),
    QUITADO(2,"Quintado"),
    CANCELADO(3,"Cancelado");

    private Integer cod;
    private String descricao;

    EstadoPagamento(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(EstadoPagamento e: EstadoPagamento.values()){
            if(cod.equals(e.getCod())){
                return e;
            }
        }

        throw new IllegalArgumentException("Id Invalido: " + cod);
    }
}
