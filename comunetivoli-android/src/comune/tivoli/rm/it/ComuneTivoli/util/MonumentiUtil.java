package comune.tivoli.rm.it.ComuneTivoli.util;

import android.app.Activity;
import comune.tivoli.rm.it.ComuneTivoli.R;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;

import java.util.ArrayList;

/**
 * Created by millozzi.stefano on 22/04/2016.
 */
public class MonumentiUtil {
    public static ArrayList<MonumentiComune> elencoMonumenti(Activity a){
        ArrayList<MonumentiComune> monumenti = new ArrayList<>();


        //monumenti_Cattedrale_di_San_Lorenzo
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_Cattedrale_di_San_Lorenzo_titolo),
                a.getResources().getString(R.string.monumenti_Cattedrale_di_San_Lorenzo_descrizione),
                a.getResources().getString(R.string.monumenti_Cattedrale_di_San_Lorenzo_descrizionebig),
                (R.drawable.monumenti_Cattedrale_di_San_Lorenzo_fotosmall),
                (R.drawable.monumenti_Cattedrale_di_San_Lorenzo_fotobig),
                a.getResources().getString(R.string.monumenti_Cattedrale_di_San_Lorenzo_url),
                a.getResources().getString(R.string.monumenti_Cattedrale_di_San_Lorenzo_maps),
                a.getResources().getString(R.string.monumenti_Cattedrale_di_San_Lorenzo_tred),
                a.getResources().getString(R.string.monumenti_Cattedrale_di_San_Lorenzo_video),
                a.getResources().getString(R.string.monumenti_Cattedrale_di_San_Lorenzo_categoria),
                a.getResources().getString(R.string.monumenti_Cattedrale_di_San_Lorenzo_gallery)
        ));
//monumenti_Chiesa_della_Maria_SS_di_Quintiliolo
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_Chiesa_della_Maria_SS_di_Quintiliolo_titolo),
                a.getResources().getString(R.string.monumenti_Chiesa_della_Maria_SS_di_Quintiliolo_descrizione),
                a.getResources().getString(R.string.monumenti_Chiesa_della_Maria_SS_di_Quintiliolo_descrizionebig),
                (R.drawable.monumenti_Chiesa_della_Maria_SS_di_Quintiliolo_fotosmall),
                (R.drawable.monumenti_Chiesa_della_Maria_SS_di_Quintiliolo_fotobig),
                a.getResources().getString(R.string.monumenti_Chiesa_della_Maria_SS_di_Quintiliolo_url),
                a.getResources().getString(R.string.monumenti_Chiesa_della_Maria_SS_di_Quintiliolo_maps),
                a.getResources().getString(R.string.monumenti_Chiesa_della_Maria_SS_di_Quintiliolo_tred),
                a.getResources().getString(R.string.monumenti_Chiesa_della_Maria_SS_di_Quintiliolo_video),
                a.getResources().getString(R.string.monumenti_Chiesa_della_Maria_SS_di_Quintiliolo_categoria),
                a.getResources().getString(R.string.monumenti_Chiesa_della_Maria_SS_di_Quintiliolo_gallery)
        ));
//monumenti_Chiesa_di_San_Biagio
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Biagio_titolo),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Biagio_descrizione),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Biagio_descrizionebig),
                (R.drawable.monumenti_Chiesa_di_San_Biagio_fotosmall),
                (R.drawable.monumenti_Chiesa_di_San_Biagio_fotobig),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Biagio_url),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Biagio_maps),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Biagio_tred),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Biagio_video),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Biagio_categoria),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Biagio_gallery)
        ));
//monumenti_Chiesa_di_San_Pietro_alla_Carità
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Pietro_alla_Carità_titolo),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Pietro_alla_Carità_descrizione),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Pietro_alla_Carità_descrizionebig),
                (R.drawable.monumenti_Chiesa_di_San_Pietro_alla_Carità_fotosmall),
                (R.drawable.monumenti_Chiesa_di_San_Pietro_alla_Carità_fotobig),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Pietro_alla_Carità_url),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Pietro_alla_Carità_maps),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Pietro_alla_Carità_tred),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Pietro_alla_Carità_video),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Pietro_alla_Carità_categoria),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Pietro_alla_Carità_gallery)
        ));
//monumenti_Chiesa_di_San_Silvestro
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Silvestro_titolo),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Silvestro_descrizione),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Silvestro_descrizionebig),
                (R.drawable.monumenti_Chiesa_di_San_Silvestro_fotosmall),
                (R.drawable.monumenti_Chiesa_di_San_Silvestro_fotobig),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Silvestro_url),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Silvestro_maps),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Silvestro_tred),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Silvestro_video),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Silvestro_categoria),
                a.getResources().getString(R.string.monumenti_Chiesa_di_San_Silvestro_gallery)
        ));
//monumenti_Chiesa_di_Santa_Maria_Maggiore
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_Chiesa_di_Santa_Maria_Maggiore_titolo),
                a.getResources().getString(R.string.monumenti_Chiesa_di_Santa_Maria_Maggiore_descrizione),
                a.getResources().getString(R.string.monumenti_Chiesa_di_Santa_Maria_Maggiore_descrizionebig),
                (R.drawable.monumenti_Chiesa_di_Santa_Maria_Maggiore_fotosmall),
                (R.drawable.monumenti_Chiesa_di_Santa_Maria_Maggiore_fotobig),
                a.getResources().getString(R.string.monumenti_Chiesa_di_Santa_Maria_Maggiore_url),
                a.getResources().getString(R.string.monumenti_Chiesa_di_Santa_Maria_Maggiore_maps),
                a.getResources().getString(R.string.monumenti_Chiesa_di_Santa_Maria_Maggiore_tred),
                a.getResources().getString(R.string.monumenti_Chiesa_di_Santa_Maria_Maggiore_video),
                a.getResources().getString(R.string.monumenti_Chiesa_di_Santa_Maria_Maggiore_categoria),
                a.getResources().getString(R.string.monumenti_Chiesa_di_Santa_Maria_Maggiore_gallery)
        ));
//monumenti_acquedotti
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_acquedotti_titolo),
                a.getResources().getString(R.string.monumenti_acquedotti_descrizione),
                a.getResources().getString(R.string.monumenti_acquedotti_descrizionebig),
                (R.drawable.monumenti_acquedotti_fotosmall),
                (R.drawable.monumenti_acquedotti_fotobig),
                a.getResources().getString(R.string.monumenti_acquedotti_url),
                a.getResources().getString(R.string.monumenti_acquedotti_maps),
                a.getResources().getString(R.string.monumenti_acquedotti_tred),
                a.getResources().getString(R.string.monumenti_acquedotti_video),
                a.getResources().getString(R.string.monumenti_acquedotti_categoria),
                a.getResources().getString(R.string.monumenti_acquedotti_gallery)
        ));
//monumenti_anfiteatro
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_anfiteatro_titolo),
                a.getResources().getString(R.string.monumenti_anfiteatro_descrizione),
                a.getResources().getString(R.string.monumenti_anfiteatro_descrizionebig),
                (R.drawable.monumenti_anfiteatro_fotosmall),
                (R.drawable.monumenti_anfiteatro_fotobig),
                a.getResources().getString(R.string.monumenti_anfiteatro_url),
                a.getResources().getString(R.string.monumenti_anfiteatro_maps),
                a.getResources().getString(R.string.monumenti_anfiteatro_tred),
                a.getResources().getString(R.string.monumenti_anfiteatro_video),
                a.getResources().getString(R.string.monumenti_anfiteatro_categoria),
                a.getResources().getString(R.string.monumenti_anfiteatro_gallery)
        ));
//monumenti_arcata_dell_acquedotto
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_titolo),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_descrizione),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_descrizionebig),
                (R.drawable.monumenti_arcata_dell_acquedotto_fotosmall),
                (R.drawable.monumenti_arcata_dell_acquedotto_fotobig),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_url),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_maps),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_tred),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_video),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_categoria),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_gallery)
        ));
//monumenti_mensa_ponderaria
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_titolo),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_descrizione),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_descrizionebig),
                (R.drawable.monumenti_mensa_ponderaria_fotosmall),
                (R.drawable.monumenti_mensa_ponderaria_fotobig),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_url),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_maps),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_tred),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_video),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_categoria),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_gallery)
        ));
//monumenti_piazza_campitelli
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_piazza_campitelli_titolo),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_descrizione),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_descrizionebig),
                (R.drawable.monumenti_piazza_campitelli_fotosmall),
                (R.drawable.monumenti_piazza_campitelli_fotobig),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_url),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_maps),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_tred),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_video),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_categoria),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_gallery)
        ));
//monumenti_piazza_garibaldi
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_titolo),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_descrizione),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_descrizionebig),
                (R.drawable.monumenti_piazza_garibaldi_fotosmall),
                (R.drawable.monumenti_piazza_garibaldi_fotobig),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_url),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_maps),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_tred),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_video),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_categoria),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_gallery)
        ));
//monumenti_ponte_gregoriano
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_titolo),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_descrizione),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_descrizionebig),
                (R.drawable.monumenti_ponte_gregoriano_fotosmall),
                (R.drawable.monumenti_ponte_gregoriano_fotobig),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_url),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_maps),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_tred),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_video),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_categoria),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_gallery)
        ));
//monumenti_rocca_pia
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_rocca_pia_titolo),
                a.getResources().getString(R.string.monumenti_rocca_pia_descrizione),
                a.getResources().getString(R.string.monumenti_rocca_pia_descrizionebig),
                (R.drawable.monumenti_rocca_pia_fotosmall),
                (R.drawable.monumenti_rocca_pia_fotobig),
                a.getResources().getString(R.string.monumenti_rocca_pia_url),
                a.getResources().getString(R.string.monumenti_rocca_pia_maps),
                a.getResources().getString(R.string.monumenti_rocca_pia_tred),
                a.getResources().getString(R.string.monumenti_rocca_pia_video),
                a.getResources().getString(R.string.monumenti_rocca_pia_categoria),
                a.getResources().getString(R.string.monumenti_rocca_pia_gallery)
        ));
//monumenti_santuario_ercole
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_santuario_ercole_titolo),
                a.getResources().getString(R.string.monumenti_santuario_ercole_descrizione),
                a.getResources().getString(R.string.monumenti_santuario_ercole_descrizionebig),
                (R.drawable.monumenti_santuario_ercole_fotosmall),
                (R.drawable.monumenti_santuario_ercole_fotobig),
                a.getResources().getString(R.string.monumenti_santuario_ercole_url),
                a.getResources().getString(R.string.monumenti_santuario_ercole_maps),
                a.getResources().getString(R.string.monumenti_santuario_ercole_tred),
                a.getResources().getString(R.string.monumenti_santuario_ercole_video),
                a.getResources().getString(R.string.monumenti_santuario_ercole_categoria),
                a.getResources().getString(R.string.monumenti_santuario_ercole_gallery)
        ));
//monumenti_tempio_della_sibilla
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_titolo),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_descrizione),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_descrizionebig),
                (R.drawable.monumenti_tempio_della_sibilla_fotosmall),
                (R.drawable.monumenti_tempio_della_sibilla_fotobig),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_url),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_maps),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_tred),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_video),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_categoria),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_gallery)
        ));
//monumenti_tempio_di_vesta
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_titolo),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_descrizione),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_descrizionebig),
                (R.drawable.monumenti_tempio_di_vesta_fotosmall),
                (R.drawable.monumenti_tempio_di_vesta_fotobig),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_url),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_maps),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_tred),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_video),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_categoria),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_gallery)
        ));
//monumenti_tomba_dei_plauzi
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_titolo),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_descrizione),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_descrizionebig),
                (R.drawable.monumenti_tomba_dei_plauzi_fotosmall),
                (R.drawable.monumenti_tomba_dei_plauzi_fotobig),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_url),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_maps),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_tred),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_video),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_categoria),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_gallery)
        ));
//monumenti_villa_adriana
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_villa_adriana_titolo),
                a.getResources().getString(R.string.monumenti_villa_adriana_descrizione),
                a.getResources().getString(R.string.monumenti_villa_adriana_descrizionebig),
                (R.drawable.monumenti_villa_adriana_fotosmall),
                (R.drawable.monumenti_villa_adriana_fotobig),
                a.getResources().getString(R.string.monumenti_villa_adriana_url),
                a.getResources().getString(R.string.monumenti_villa_adriana_maps),
                a.getResources().getString(R.string.monumenti_villa_adriana_tred),
                a.getResources().getString(R.string.monumenti_villa_adriana_video),
                a.getResources().getString(R.string.monumenti_villa_adriana_categoria),
                a.getResources().getString(R.string.monumenti_villa_adriana_gallery)
        ));
//monumenti_villa_d_este
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_villa_d_este_titolo),
                a.getResources().getString(R.string.monumenti_villa_d_este_descrizione),
                a.getResources().getString(R.string.monumenti_villa_d_este_descrizionebig),
                (R.drawable.monumenti_villa_d_este_fotosmall),
                (R.drawable.monumenti_villa_d_este_fotobig),
                a.getResources().getString(R.string.monumenti_villa_d_este_url),
                a.getResources().getString(R.string.monumenti_villa_d_este_maps),
                a.getResources().getString(R.string.monumenti_villa_d_este_tred),
                a.getResources().getString(R.string.monumenti_villa_d_este_video),
                a.getResources().getString(R.string.monumenti_villa_d_este_categoria),
                a.getResources().getString(R.string.monumenti_villa_d_este_gallery)
        ));
//monumenti_villa_gregoriana
        monumenti.add(new MonumentiComune(
                a.getResources().getString(R.string.monumenti_villa_gregoriana_titolo),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_descrizione),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_descrizionebig),
                (R.drawable.monumenti_villa_gregoriana_fotosmall),
                (R.drawable.monumenti_villa_gregoriana_fotobig),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_url),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_maps),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_tred),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_video),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_categoria),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_gallery)
        ));
        return monumenti;
    }
}
