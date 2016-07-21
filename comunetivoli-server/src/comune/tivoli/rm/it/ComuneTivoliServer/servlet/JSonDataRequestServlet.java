package comune.tivoli.rm.it.ComuneTivoliServer.servlet;

import com.google.appengine.repackaged.com.google.gson.Gson;
import comune.tivoli.rm.it.ComuneTivoliCommon.data.CommonDataServerRequest;
import comune.tivoli.rm.it.ComuneTivoliCommon.data.CommonDataServerResponse;
import comune.tivoli.rm.it.ComuneTivoliCommon.data.NotiziaSitoDTO;
import comune.tivoli.rm.it.ComuneTivoliServer.ServerConfiguration;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.DataLayerBuilder;
import comune.tivoli.rm.it.ComuneTivoliServer.datalayer.impl.circolari.InMemoryCacheLayerNotiziaSitoDB;
import comune.tivoli.rm.it.ComuneTivoliServer.model.NotiziaSitoSERVERDB;
import comune.tivoli.rm.it.ComuneTivoliServer.util.CopyUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by stefano on 06/05/16.
 */
public class JSonDataRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String param = request.getParameter("param");
        if (param == null) throw new IOException("Parameter (param) not specified");
        final Gson g = new Gson();
        final CommonDataServerRequest req = g.fromJson(param, CommonDataServerRequest.class);
        System.out.println("Richiesta " + req);
        try {
            final InMemoryCacheLayerNotiziaSitoDB ee = DataLayerBuilder.getLoaderNewsSito();
            final List<NotiziaSitoSERVERDB> elencoNotizie = ee.allEntities();
            ArrayList<NotiziaSitoDTO> notizie = new ArrayList<>();

            for (NotiziaSitoSERVERDB x : elencoNotizie) {
                if (x.token > req.maxClientToken || req.version != ServerConfiguration.PERISTENCE_VERSION_NUMBER) {
                    //invia l'url originale
                    NotiziaSitoDTO n = CopyUtil.convertToDTO(x);
                    notizie.add(n);
                }
            }

            final CommonDataServerResponse resp = new CommonDataServerResponse(ServerConfiguration.PERISTENCE_VERSION_NUMBER, notizie);

            //invio
            final String s = g.toJson(resp);
            if (req.responseInZipFormat) {
                response.setContentType("application/zip");
                response.addHeader("Content-Disposition", "inline; filename=data.dto.zip");

                final ServletOutputStream outputStream = response.getOutputStream();
                ZipOutputStream out = new ZipOutputStream(outputStream);
                out.putNextEntry(new ZipEntry("data.json"));
                out.write(s.getBytes());
                out.closeEntry();
                out.flush();
                out.close();
            } else {
                final ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(s.getBytes());
                outputStream.flush();
            }


        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
