package com.cidadao.conectado.modules.category;

public enum CategoryEnum {
    TRANSPORTE_MOBILIDADE_URBANA("Transporte e Mobilidade Urbana"),
    SEGURANCA_PUBLICA("Segurança Pública"),
    MEIO_AMBIENTE_SUSTENTABILIDADE("Meio Ambiente e Sustentabilidade"),
    SAUDE_BEM_ESTAR("Saúde e Bem-Estar"),
    EDUCACAO_CULTURA("Educação e Cultura"),
    INFRAESTRUTURA_URBANA("Infraestrutura Urbana"),
    INCLUSAO_SOCIAL("Inclusão Social"),
    ECONOMIA_EMPREGO("Economia e Emprego"),
    TECNOLOGIA_INOVACAO("Tecnologia e Inovação"),
    LAZER_ENTRETENIMENTO("Lazer e Entretenimento"),
    HABITACAO_DESENVOLVIMENTO_URBANO("Habitação e Desenvolvimento Urbano"),
    TURISMO_PATRIMONIO_CULTURAL("Turismo e Patrimônio Cultural"),
    AGRICULTURA_ALIMENTACAO("Agricultura Urbana e Alimentação"),
    GESTAO_PARTICIPACAO_CIDADA("Gestão e Participação Cidadã");

    private final String displayName;

    CategoryEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
