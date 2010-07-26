import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import ikuspro.interprete.c.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        CLexer lex = new CLexer(new ANTLRFileStream("F:\\ktulur\\workspace\\ikuspro_1.0\\src\\ikuspro\\interprete\\c\\.\\__Test___input.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        CParser g = new CParser(tokens, 49100, null);
        try {
            g.programa();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}