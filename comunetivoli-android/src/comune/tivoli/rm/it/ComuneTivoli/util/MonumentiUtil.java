package comune.tivoli.rm.it.ComuneTivoli.util;

import android.app.Activity;
import comune.tivoli.rm.it.ComuneTivoli.R;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * todo: aumentare la dimensione delle immagini "big", portandola ad almeno 400 pixel di larghezza
 */
public class MonumentiUtil {
    public static List<MonumentiComune> filtraByCategoria(List<MonumentiComune> a, String categoria) {
        List<MonumentiComune> ris = new ArrayList<>();
        for (MonumentiComune monumentiComune : a) {
            if (monumentiComune.categoria.equalsIgnoreCase(categoria))
                ris.add(monumentiComune);
        }
        return ris;
    }
public static List<String> estraiCategorie(List<MonumentiComune> a) {
        TreeSet<String> r = new TreeSet<>();
        for (MonumentiComune monumentiComune : a) {
            r.add(monumentiComune.categoria);
        }
        return new ArrayList<>(r);
    }

    public static MonumentiComune findById(List<MonumentiComune> a,int id) {
        
        for (MonumentiComune monumentiComune : a) {
            if (monumentiComune.id==id)return monumentiComune;
        }
        return null;
    }
    public static List<MonumentiComune> elencoMonumenti(Activity a) {
        ArrayList<MonumentiComune> monumenti;
        monumenti = new ArrayList<>();
   //monumentixml_Casa_Gotica
monumenti.add(new MonumentiComune(
1,                 a.getResources().getString(R.string.monumentixml_Casa_Gotica_titolo),
                a.getResources().getString(R.string.monumentixml_Casa_Gotica_descrizione),
                a.getResources().getString(R.string.monumentixml_Casa_Gotica_descrizionebig),
                (R.drawable.monumentixml_Casa_Gotica_fotosmall),
                a.getResources().getString(R.string.monumentixml_Casa_Gotica_fotobigurl),
                a.getResources().getString(R.string.monumentixml_Casa_Gotica_url),
                a.getResources().getString(R.string.monumentixml_Casa_Gotica_maps),
                a.getResources().getString(R.string.monumentixml_Casa_Gotica_tred),
                a.getResources().getString(R.string.monumentixml_Casa_Gotica_video),
                a.getResources().getString(R.string.monumentixml_Casa_Gotica_categoria),
                a.getResources().getString(R.string.monumentixml_Casa_Gotica_gallery)
        ));
   //monumentixml_Cattedrale_di_San_Lorenzo
monumenti.add(new MonumentiComune(
2,                 a.getResources().getString(R.string.monumentixml_Cattedrale_di_San_Lorenzo_titolo),
                a.getResources().getString(R.string.monumentixml_Cattedrale_di_San_Lorenzo_descrizione),
                a.getResources().getString(R.string.monumentixml_Cattedrale_di_San_Lorenzo_descrizionebig),
                (R.drawable.monumentixml_Cattedrale_di_San_Lorenzo_fotosmall),
                a.getResources().getString(R.string.monumentixml_Cattedrale_di_San_Lorenzo_fotobigurl),
                a.getResources().getString(R.string.monumentixml_Cattedrale_di_San_Lorenzo_url),
                a.getResources().getString(R.string.monumentixml_Cattedrale_di_San_Lorenzo_maps),
                a.getResources().getString(R.string.monumentixml_Cattedrale_di_San_Lorenzo_tred),
                a.getResources().getString(R.string.monumentixml_Cattedrale_di_San_Lorenzo_video),
                a.getResources().getString(R.string.monumentixml_Cattedrale_di_San_Lorenzo_categoria),
                a.getResources().getString(R.string.monumentixml_Cattedrale_di_San_Lorenzo_gallery)
        ));
   //monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo
monumenti.add(new MonumentiComune(
3,                 a.getResources().getString(R.string.monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo_titolo),
                a.getResources().getString(R.string.monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo_descrizione),
                a.getResources().getString(R.string.monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo_descrizionebig),
                (R.drawable.monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo_fotosmall),
                a.getResources().getString(R.string.monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo_fotobigurl),
                a.getResources().getString(R.string.monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo_url),
                a.getResources().getString(R.string.monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo_maps),
                a.getResources().getString(R.string.monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo_tred),
                a.getResources().getString(R.string.monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo_video),
                a.getResources().getString(R.string.monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo_categoria),
                a.getResources().getString(R.string.monumentixml_Chiesa_della_Maria_SS_di_Quintiliolo_gallery)
        ));
   //monumentixml_Chiesa_di_San_Biagio
monumenti.add(new MonumentiComune(
4,                 a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Biagio_titolo),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Biagio_descrizione),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Biagio_descrizionebig),
                (R.drawable.monumentixml_Chiesa_di_San_Biagio_fotosmall),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Biagio_fotobigurl),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Biagio_url),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Biagio_maps),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Biagio_tred),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Biagio_video),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Biagio_categoria),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Biagio_gallery)
        ));
   //monumentixml_Chiesa_di_San_Pietro_alla_Carità
monumenti.add(new MonumentiComune(
5,                 a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Pietro_alla_Carità_titolo),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Pietro_alla_Carità_descrizione),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Pietro_alla_Carità_descrizionebig),
                (R.drawable.monumentixml_Chiesa_di_San_Pietro_alla_Carità_fotosmall),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Pietro_alla_Carità_fotobigurl),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Pietro_alla_Carità_url),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Pietro_alla_Carità_maps),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Pietro_alla_Carità_tred),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Pietro_alla_Carità_video),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Pietro_alla_Carità_categoria),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Pietro_alla_Carità_gallery)
        ));
   //monumentixml_Chiesa_di_San_Silvestro
monumenti.add(new MonumentiComune(
6,                 a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Silvestro_titolo),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Silvestro_descrizione),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Silvestro_descrizionebig),
                (R.drawable.monumentixml_Chiesa_di_San_Silvestro_fotosmall),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Silvestro_fotobigurl),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Silvestro_url),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Silvestro_maps),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Silvestro_tred),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Silvestro_video),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Silvestro_categoria),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_San_Silvestro_gallery)
        ));
   //monumentixml_Chiesa_di_Santa_Maria_Maggiore
monumenti.add(new MonumentiComune(
7,                 a.getResources().getString(R.string.monumentixml_Chiesa_di_Santa_Maria_Maggiore_titolo),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_Santa_Maria_Maggiore_descrizione),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_Santa_Maria_Maggiore_descrizionebig),
                (R.drawable.monumentixml_Chiesa_di_Santa_Maria_Maggiore_fotosmall),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_Santa_Maria_Maggiore_fotobigurl),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_Santa_Maria_Maggiore_url),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_Santa_Maria_Maggiore_maps),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_Santa_Maria_Maggiore_tred),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_Santa_Maria_Maggiore_video),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_Santa_Maria_Maggiore_categoria),
                a.getResources().getString(R.string.monumentixml_Chiesa_di_Santa_Maria_Maggiore_gallery)
        ));
   //monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera
monumenti.add(new MonumentiComune(
8,                 a.getResources().getString(R.string.monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera_titolo),
                a.getResources().getString(R.string.monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera_descrizione),
                a.getResources().getString(R.string.monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera_descrizionebig),
                (R.drawable.monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera_fotosmall),
                a.getResources().getString(R.string.monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera_fotobigurl),
                a.getResources().getString(R.string.monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera_url),
                a.getResources().getString(R.string.monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera_maps),
                a.getResources().getString(R.string.monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera_tred),
                a.getResources().getString(R.string.monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera_video),
                a.getResources().getString(R.string.monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera_categoria),
                a.getResources().getString(R.string.monumentixml_Palazzo_della_Missione_Complesso_Mauro_Macera_gallery)
        ));
   //monumentixml_acquedotti
monumenti.add(new MonumentiComune(
9,                 a.getResources().getString(R.string.monumentixml_acquedotti_titolo),
                a.getResources().getString(R.string.monumentixml_acquedotti_descrizione),
                a.getResources().getString(R.string.monumentixml_acquedotti_descrizionebig),
                (R.drawable.monumentixml_acquedotti_fotosmall),
                a.getResources().getString(R.string.monumentixml_acquedotti_fotobigurl),
                a.getResources().getString(R.string.monumentixml_acquedotti_url),
                a.getResources().getString(R.string.monumentixml_acquedotti_maps),
                a.getResources().getString(R.string.monumentixml_acquedotti_tred),
                a.getResources().getString(R.string.monumentixml_acquedotti_video),
                a.getResources().getString(R.string.monumentixml_acquedotti_categoria),
                a.getResources().getString(R.string.monumentixml_acquedotti_gallery)
        ));
   //monumentixml_anfiteatro
monumenti.add(new MonumentiComune(
10,                 a.getResources().getString(R.string.monumentixml_anfiteatro_titolo),
                a.getResources().getString(R.string.monumentixml_anfiteatro_descrizione),
                a.getResources().getString(R.string.monumentixml_anfiteatro_descrizionebig),
                (R.drawable.monumentixml_anfiteatro_fotosmall),
                a.getResources().getString(R.string.monumentixml_anfiteatro_fotobigurl),
                a.getResources().getString(R.string.monumentixml_anfiteatro_url),
                a.getResources().getString(R.string.monumentixml_anfiteatro_maps),
                a.getResources().getString(R.string.monumentixml_anfiteatro_tred),
                a.getResources().getString(R.string.monumentixml_anfiteatro_video),
                a.getResources().getString(R.string.monumentixml_anfiteatro_categoria),
                a.getResources().getString(R.string.monumentixml_anfiteatro_gallery)
        ));
   //monumentixml_arcata_dell_acquedotto
monumenti.add(new MonumentiComune(
11,                 a.getResources().getString(R.string.monumentixml_arcata_dell_acquedotto_titolo),
                a.getResources().getString(R.string.monumentixml_arcata_dell_acquedotto_descrizione),
                a.getResources().getString(R.string.monumentixml_arcata_dell_acquedotto_descrizionebig),
                (R.drawable.monumentixml_arcata_dell_acquedotto_fotosmall),
                a.getResources().getString(R.string.monumentixml_arcata_dell_acquedotto_fotobigurl),
                a.getResources().getString(R.string.monumentixml_arcata_dell_acquedotto_url),
                a.getResources().getString(R.string.monumentixml_arcata_dell_acquedotto_maps),
                a.getResources().getString(R.string.monumentixml_arcata_dell_acquedotto_tred),
                a.getResources().getString(R.string.monumentixml_arcata_dell_acquedotto_video),
                a.getResources().getString(R.string.monumentixml_arcata_dell_acquedotto_categoria),
                a.getResources().getString(R.string.monumentixml_arcata_dell_acquedotto_gallery)
        ));
   //monumentixml_mensa_ponderaria
monumenti.add(new MonumentiComune(
12,                 a.getResources().getString(R.string.monumentixml_mensa_ponderaria_titolo),
                a.getResources().getString(R.string.monumentixml_mensa_ponderaria_descrizione),
                a.getResources().getString(R.string.monumentixml_mensa_ponderaria_descrizionebig),
                (R.drawable.monumentixml_mensa_ponderaria_fotosmall),
                a.getResources().getString(R.string.monumentixml_mensa_ponderaria_fotobigurl),
                a.getResources().getString(R.string.monumentixml_mensa_ponderaria_url),
                a.getResources().getString(R.string.monumentixml_mensa_ponderaria_maps),
                a.getResources().getString(R.string.monumentixml_mensa_ponderaria_tred),
                a.getResources().getString(R.string.monumentixml_mensa_ponderaria_video),
                a.getResources().getString(R.string.monumentixml_mensa_ponderaria_categoria),
                a.getResources().getString(R.string.monumentixml_mensa_ponderaria_gallery)
        ));
   //monumentixml_piazza_campitelli
monumenti.add(new MonumentiComune(
13,                 a.getResources().getString(R.string.monumentixml_piazza_campitelli_titolo),
                a.getResources().getString(R.string.monumentixml_piazza_campitelli_descrizione),
                a.getResources().getString(R.string.monumentixml_piazza_campitelli_descrizionebig),
                (R.drawable.monumentixml_piazza_campitelli_fotosmall),
                a.getResources().getString(R.string.monumentixml_piazza_campitelli_fotobigurl),
                a.getResources().getString(R.string.monumentixml_piazza_campitelli_url),
                a.getResources().getString(R.string.monumentixml_piazza_campitelli_maps),
                a.getResources().getString(R.string.monumentixml_piazza_campitelli_tred),
                a.getResources().getString(R.string.monumentixml_piazza_campitelli_video),
                a.getResources().getString(R.string.monumentixml_piazza_campitelli_categoria),
                a.getResources().getString(R.string.monumentixml_piazza_campitelli_gallery)
        ));
   //monumentixml_piazza_garibaldi
monumenti.add(new MonumentiComune(
14,                 a.getResources().getString(R.string.monumentixml_piazza_garibaldi_titolo),
                a.getResources().getString(R.string.monumentixml_piazza_garibaldi_descrizione),
                a.getResources().getString(R.string.monumentixml_piazza_garibaldi_descrizionebig),
                (R.drawable.monumentixml_piazza_garibaldi_fotosmall),
                a.getResources().getString(R.string.monumentixml_piazza_garibaldi_fotobigurl),
                a.getResources().getString(R.string.monumentixml_piazza_garibaldi_url),
                a.getResources().getString(R.string.monumentixml_piazza_garibaldi_maps),
                a.getResources().getString(R.string.monumentixml_piazza_garibaldi_tred),
                a.getResources().getString(R.string.monumentixml_piazza_garibaldi_video),
                a.getResources().getString(R.string.monumentixml_piazza_garibaldi_categoria),
                a.getResources().getString(R.string.monumentixml_piazza_garibaldi_gallery)
        ));
   //monumentixml_ponte_gregoriano
monumenti.add(new MonumentiComune(
15,                 a.getResources().getString(R.string.monumentixml_ponte_gregoriano_titolo),
                a.getResources().getString(R.string.monumentixml_ponte_gregoriano_descrizione),
                a.getResources().getString(R.string.monumentixml_ponte_gregoriano_descrizionebig),
                (R.drawable.monumentixml_ponte_gregoriano_fotosmall),
                a.getResources().getString(R.string.monumentixml_ponte_gregoriano_fotobigurl),
                a.getResources().getString(R.string.monumentixml_ponte_gregoriano_url),
                a.getResources().getString(R.string.monumentixml_ponte_gregoriano_maps),
                a.getResources().getString(R.string.monumentixml_ponte_gregoriano_tred),
                a.getResources().getString(R.string.monumentixml_ponte_gregoriano_video),
                a.getResources().getString(R.string.monumentixml_ponte_gregoriano_categoria),
                a.getResources().getString(R.string.monumentixml_ponte_gregoriano_gallery)
        ));
   //monumentixml_rocca_pia
monumenti.add(new MonumentiComune(
16,                 a.getResources().getString(R.string.monumentixml_rocca_pia_titolo),
                a.getResources().getString(R.string.monumentixml_rocca_pia_descrizione),
                a.getResources().getString(R.string.monumentixml_rocca_pia_descrizionebig),
                (R.drawable.monumentixml_rocca_pia_fotosmall),
                a.getResources().getString(R.string.monumentixml_rocca_pia_fotobigurl),
                a.getResources().getString(R.string.monumentixml_rocca_pia_url),
                a.getResources().getString(R.string.monumentixml_rocca_pia_maps),
                a.getResources().getString(R.string.monumentixml_rocca_pia_tred),
                a.getResources().getString(R.string.monumentixml_rocca_pia_video),
                a.getResources().getString(R.string.monumentixml_rocca_pia_categoria),
                a.getResources().getString(R.string.monumentixml_rocca_pia_gallery)
        ));
   //monumentixml_santuario_ercole
monumenti.add(new MonumentiComune(
17,                 a.getResources().getString(R.string.monumentixml_santuario_ercole_titolo),
                a.getResources().getString(R.string.monumentixml_santuario_ercole_descrizione),
                a.getResources().getString(R.string.monumentixml_santuario_ercole_descrizionebig),
                (R.drawable.monumentixml_santuario_ercole_fotosmall),
                a.getResources().getString(R.string.monumentixml_santuario_ercole_fotobigurl),
                a.getResources().getString(R.string.monumentixml_santuario_ercole_url),
                a.getResources().getString(R.string.monumentixml_santuario_ercole_maps),
                a.getResources().getString(R.string.monumentixml_santuario_ercole_tred),
                a.getResources().getString(R.string.monumentixml_santuario_ercole_video),
                a.getResources().getString(R.string.monumentixml_santuario_ercole_categoria),
                a.getResources().getString(R.string.monumentixml_santuario_ercole_gallery)
        ));
   //monumentixml_tempio_della_sibilla
monumenti.add(new MonumentiComune(
18,                 a.getResources().getString(R.string.monumentixml_tempio_della_sibilla_titolo),
                a.getResources().getString(R.string.monumentixml_tempio_della_sibilla_descrizione),
                a.getResources().getString(R.string.monumentixml_tempio_della_sibilla_descrizionebig),
                (R.drawable.monumentixml_tempio_della_sibilla_fotosmall),
                a.getResources().getString(R.string.monumentixml_tempio_della_sibilla_fotobigurl),
                a.getResources().getString(R.string.monumentixml_tempio_della_sibilla_url),
                a.getResources().getString(R.string.monumentixml_tempio_della_sibilla_maps),
                a.getResources().getString(R.string.monumentixml_tempio_della_sibilla_tred),
                a.getResources().getString(R.string.monumentixml_tempio_della_sibilla_video),
                a.getResources().getString(R.string.monumentixml_tempio_della_sibilla_categoria),
                a.getResources().getString(R.string.monumentixml_tempio_della_sibilla_gallery)
        ));
   //monumentixml_tempio_di_vesta
monumenti.add(new MonumentiComune(
19,                 a.getResources().getString(R.string.monumentixml_tempio_di_vesta_titolo),
                a.getResources().getString(R.string.monumentixml_tempio_di_vesta_descrizione),
                a.getResources().getString(R.string.monumentixml_tempio_di_vesta_descrizionebig),
                (R.drawable.monumentixml_tempio_di_vesta_fotosmall),
                a.getResources().getString(R.string.monumentixml_tempio_di_vesta_fotobigurl),
                a.getResources().getString(R.string.monumentixml_tempio_di_vesta_url),
                a.getResources().getString(R.string.monumentixml_tempio_di_vesta_maps),
                a.getResources().getString(R.string.monumentixml_tempio_di_vesta_tred),
                a.getResources().getString(R.string.monumentixml_tempio_di_vesta_video),
                a.getResources().getString(R.string.monumentixml_tempio_di_vesta_categoria),
                a.getResources().getString(R.string.monumentixml_tempio_di_vesta_gallery)
        ));
   //monumentixml_tomba_dei_plauzi
monumenti.add(new MonumentiComune(
20,                 a.getResources().getString(R.string.monumentixml_tomba_dei_plauzi_titolo),
                a.getResources().getString(R.string.monumentixml_tomba_dei_plauzi_descrizione),
                a.getResources().getString(R.string.monumentixml_tomba_dei_plauzi_descrizionebig),
                (R.drawable.monumentixml_tomba_dei_plauzi_fotosmall),
                a.getResources().getString(R.string.monumentixml_tomba_dei_plauzi_fotobigurl),
                a.getResources().getString(R.string.monumentixml_tomba_dei_plauzi_url),
                a.getResources().getString(R.string.monumentixml_tomba_dei_plauzi_maps),
                a.getResources().getString(R.string.monumentixml_tomba_dei_plauzi_tred),
                a.getResources().getString(R.string.monumentixml_tomba_dei_plauzi_video),
                a.getResources().getString(R.string.monumentixml_tomba_dei_plauzi_categoria),
                a.getResources().getString(R.string.monumentixml_tomba_dei_plauzi_gallery)
        ));
   //monumentixml_villa_adriana
monumenti.add(new MonumentiComune(
21,                 a.getResources().getString(R.string.monumentixml_villa_adriana_titolo),
                a.getResources().getString(R.string.monumentixml_villa_adriana_descrizione),
                a.getResources().getString(R.string.monumentixml_villa_adriana_descrizionebig),
                (R.drawable.monumentixml_villa_adriana_fotosmall),
                a.getResources().getString(R.string.monumentixml_villa_adriana_fotobigurl),
                a.getResources().getString(R.string.monumentixml_villa_adriana_url),
                a.getResources().getString(R.string.monumentixml_villa_adriana_maps),
                a.getResources().getString(R.string.monumentixml_villa_adriana_tred),
                a.getResources().getString(R.string.monumentixml_villa_adriana_video),
                a.getResources().getString(R.string.monumentixml_villa_adriana_categoria),
                a.getResources().getString(R.string.monumentixml_villa_adriana_gallery)
        ));
   //monumentixml_villa_d_este
monumenti.add(new MonumentiComune(
22,                 a.getResources().getString(R.string.monumentixml_villa_d_este_titolo),
                a.getResources().getString(R.string.monumentixml_villa_d_este_descrizione),
                a.getResources().getString(R.string.monumentixml_villa_d_este_descrizionebig),
                (R.drawable.monumentixml_villa_d_este_fotosmall),
                a.getResources().getString(R.string.monumentixml_villa_d_este_fotobigurl),
                a.getResources().getString(R.string.monumentixml_villa_d_este_url),
                a.getResources().getString(R.string.monumentixml_villa_d_este_maps),
                a.getResources().getString(R.string.monumentixml_villa_d_este_tred),
                a.getResources().getString(R.string.monumentixml_villa_d_este_video),
                a.getResources().getString(R.string.monumentixml_villa_d_este_categoria),
                a.getResources().getString(R.string.monumentixml_villa_d_este_gallery)
        ));
   //monumentixml_villa_gregoriana
monumenti.add(new MonumentiComune(
23,                 a.getResources().getString(R.string.monumentixml_villa_gregoriana_titolo),
                a.getResources().getString(R.string.monumentixml_villa_gregoriana_descrizione),
                a.getResources().getString(R.string.monumentixml_villa_gregoriana_descrizionebig),
                (R.drawable.monumentixml_villa_gregoriana_fotosmall),
                a.getResources().getString(R.string.monumentixml_villa_gregoriana_fotobigurl),
                a.getResources().getString(R.string.monumentixml_villa_gregoriana_url),
                a.getResources().getString(R.string.monumentixml_villa_gregoriana_maps),
                a.getResources().getString(R.string.monumentixml_villa_gregoriana_tred),
                a.getResources().getString(R.string.monumentixml_villa_gregoriana_video),
                a.getResources().getString(R.string.monumentixml_villa_gregoriana_categoria),
                a.getResources().getString(R.string.monumentixml_villa_gregoriana_gallery)
        ));
        return monumenti;
    }
}

