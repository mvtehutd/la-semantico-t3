package br.ufscar.dc.compiladores.la.semantico;

import br.ufscar.dc.compiladores.la.semantico.TabelaDeSimbolos.TipoLa;
import br.ufscar.dc.compiladores.parser.LaBaseVisitor;
import br.ufscar.dc.compiladores.parser.LaParser;
import br.ufscar.dc.compiladores.parser.LaParser.CmdAtribuicaoContext;
import br.ufscar.dc.compiladores.parser.LaParser.Declaracao_localContext;
import br.ufscar.dc.compiladores.parser.LaParser.IdentificadorContext;

public class LaSemantico extends LaBaseVisitor<Void> {

    TabelaDeSimbolos tabela;

    // Cria o visitante do Programa que cria a tabela de símbolos
    @Override
    public Void visitPrograma(LaParser.ProgramaContext ctx) {
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    // Visitante da Declaração Local que confere erros de declaração
    @Override
    public Void visitDeclaracao_local(Declaracao_localContext ctx) {
        String tipo = ctx.variavel().tipo().getText();
        TipoLa tipovar = TipoLa.INVALIDO;

        // verifica se é algum dos tipos padrão
        switch (tipo) {
            case
                    "inteiro":
                tipovar = TipoLa.INTEIRO;
                break;
            case
                    "literal":
                tipovar = TipoLa.LITERAL;
                break;
            case
                    "real":
                tipovar = TipoLa.REAL;
                break;
            case
                    "logico":
                tipovar = TipoLa.LOGICO;
                break;

            default:
                LaSemanticoUtils.adicionarErroSemantico(ctx.variavel().identificador(0).IDENT(0).getSymbol(),
                        "tipo " + tipo + " nao declarado");
                break;
        }
        // Se ele já existe na tabela de símbolos, então erro de já declarado, senão adiciona na tabela de símbolos
        for (IdentificadorContext variavelIdent : ctx.variavel().identificador()) {
            String variavel = variavelIdent.getText();
            if (tabela.existe(variavel)) {
                LaSemanticoUtils.adicionarErroSemantico(variavelIdent.IDENT(0).getSymbol(), "identificador "+ variavel +" ja declarado anteriormente");
            } else {
                tabela.adicionar(variavel, tipovar);
            }
        }

        return super.visitDeclaracao_local(ctx);
    }

    // Visitante do Identificador confere se não está na tabela de símbolos, gerando erro de não declarado
    @Override
    public Void visitIdentificador(IdentificadorContext ctx) {
        if (!tabela.existe(ctx.IDENT(0).getText())) {
            LaSemanticoUtils.adicionarErroSemantico(ctx.IDENT(0).getSymbol(),
                    "identificador " + ctx.IDENT(0).getText() + " nao declarado");
        }
        return super.visitIdentificador(ctx);
    }

    // Visitante do comando de atribuição verifica se a atribuição é compatível com os tipos declarados
    @Override
    public Void visitCmdAtribuicao(CmdAtribuicaoContext ctx) {
        TipoLa tipoExpressao = LaSemanticoUtils.verificarTipo(tabela, ctx.expressao());
        String nomeVariavel = ctx.identificador().getText();
        if(tipoExpressao != TipoLa.INVALIDO){
            TipoLa tipoVariavel = LaSemanticoUtils.verificarTipo(tabela, nomeVariavel);
            if(LaSemanticoUtils.tiposDiferentes(tipoVariavel, tipoExpressao)){
                LaSemanticoUtils.adicionarErroSemantico(ctx.identificador().IDENT(0).getSymbol(), "atribuicao nao compativel para " + nomeVariavel);
            }
        } else{
            LaSemanticoUtils.adicionarErroSemantico(ctx.identificador().IDENT(0).getSymbol(), "atribuicao nao compativel para " + nomeVariavel);
        }
        return super.visitCmdAtribuicao(ctx);
    }

    

}