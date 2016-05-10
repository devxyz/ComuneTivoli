package comune.tivoli.rm.it;

import comune.tivoli.rm.it.ComuneTivoliCodingSupport.GenerateLayoutFiles;
import comune.tivoli.rm.it.ComuneTivoliCodingSupport.GenerateListaMonumentiDaStringFile;
import comune.tivoli.rm.it.greenDaoEngine.GreenDaoGenerator;

/**
 * Created by stefano on 10/05/16.
 */
public class CodeGenerator {
    public static void main(String[] args) throws Exception {
        GreenDaoGenerator.main(args);
        GenerateLayoutFiles.main(args);
        GenerateListaMonumentiDaStringFile.main(args);
    }
}
