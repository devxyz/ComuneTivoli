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

        MonumentiComune acquedotti = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_acquedotti_titolo),
                a.getResources().getString(R.string.monumenti_acquedotti_descrizione),
                a.getResources().getString(R.string.monumenti_acquedotti_descrizionebig),
                (R.drawable.monumenti_acquedotti_fotosmall),
                (R.drawable.monumenti_acquedotti_fotobig),
                a.getResources().getString(R.string.monumenti_acquedotti_url),
                a.getResources().getString(R.string.monumenti_acquedotti_tred),
                a.getResources().getString(R.string.monumenti_acquedotti_maps),
                a.getResources().getString(R.string.monumenti_acquedotti_video)
        );

        MonumentiComune anfiteatro = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_anfiteatro_titolo),
                a.getResources().getString(R.string.monumenti_anfiteatro_descrizione),
                a.getResources().getString(R.string.monumenti_anfiteatro_descrizionebig),
                (R.drawable.monumenti_anfiteatro_fotosmall),
                (R.drawable.monumenti_anfiteatro_fotobig),
                a.getResources().getString(R.string.monumenti_anfiteatro_url),
                a.getResources().getString(R.string.monumenti_anfiteatro_tred),
                a.getResources().getString(R.string.monumenti_anfiteatro_maps),
                a.getResources().getString(R.string.monumenti_anfiteatro_video)
        );

        MonumentiComune arcata_dell_acquedotto = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_titolo),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_descrizione),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_descrizionebig),
                (R.drawable.monumenti_arcata_dell_acquedotto_fotosmall),
                (R.drawable.monumenti_arcata_dell_acquedotto_fotobig),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_url),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_tred),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_maps),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_video)

        );

        MonumentiComune mensa_ponderaria = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_titolo),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_descrizione),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_descrizionebig),
                (R.drawable.monumenti_mensa_ponderaria_fotosmall),
                (R.drawable.monumenti_mensa_ponderaria_fotobig),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_url),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_tred),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_maps),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_video)
        );

        MonumentiComune piazza_campitelli = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_piazza_campitelli_titolo),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_descrizione),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_descrizionebig),
                (R.drawable.monumenti_piazza_campitelli_fotosmall),
                (R.drawable.monumenti_piazza_campitelli_fotobig),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_url),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_tred),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_maps),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_video)
        );

        MonumentiComune piazza_garibaldi = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_titolo),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_descrizione),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_descrizionebig),
                (R.drawable.monumenti_piazza_garibaldi_fotosmall),
                (R.drawable.monumenti_piazza_garibaldi_fotobig),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_url),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_tred),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_maps),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_video)
        );

        MonumentiComune ponte_gregoriano = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_titolo),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_descrizione),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_descrizionebig),
                (R.drawable.monumenti_ponte_gregoriano_fotosmall),
                (R.drawable.monumenti_ponte_gregoriano_fotobig),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_url),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_tred),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_maps),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_video)
        );

        MonumentiComune rocca_pia = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_rocca_pia_titolo),
                a.getResources().getString(R.string.monumenti_rocca_pia_descrizione),
                a.getResources().getString(R.string.monumenti_rocca_pia_descrizionebig),
                (R.drawable.monumenti_rocca_pia_fotosmall),
                (R.drawable.monumenti_rocca_pia_fotobig),
                a.getResources().getString(R.string.monumenti_rocca_pia_url),
                a.getResources().getString(R.string.monumenti_rocca_pia_tred),
                a.getResources().getString(R.string.monumenti_rocca_pia_maps),
                a.getResources().getString(R.string.monumenti_rocca_pia_video)
        );

        MonumentiComune santuario_ercole = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_santuario_ercole_titolo),
                a.getResources().getString(R.string.monumenti_santuario_ercole_descrizione),
                a.getResources().getString(R.string.monumenti_santuario_ercole_descrizionebig),
                (R.drawable.monumenti_santuario_ercole_fotosmall),
                (R.drawable.monumenti_santuario_ercole_fotobig),
                a.getResources().getString(R.string.monumenti_santuario_ercole_url),
                a.getResources().getString(R.string.monumenti_santuario_ercole_tred),
                a.getResources().getString(R.string.monumenti_santuario_ercole_maps),
                a.getResources().getString(R.string.monumenti_santuario_ercole_video)
        );

        MonumentiComune tempio_della_sibilla = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_titolo),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_descrizione),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_descrizionebig),
                (R.drawable.monumenti_tempio_della_sibilla_fotosmall),
                (R.drawable.monumenti_tempio_della_sibilla_fotobig),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_url),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_tred),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_maps),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_video)
        );

        MonumentiComune tempio_di_vesta = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_titolo),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_descrizione),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_descrizionebig),
                (R.drawable.monumenti_tempio_di_vesta_fotosmall),
                (R.drawable.monumenti_tempio_di_vesta_fotobig),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_url),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_tred),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_maps),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_video)
        );

        MonumentiComune tomba_dei_plauzi = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_titolo),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_descrizione),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_descrizionebig),
                (R.drawable.monumenti_tomba_dei_plauzi_fotosmall),
                (R.drawable.monumenti_tomba_dei_plauzi_fotobig),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_url),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_tred),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_maps),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_video)
        );

        MonumentiComune villa_adriana = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_villa_adriana_titolo),
                a.getResources().getString(R.string.monumenti_villa_adriana_descrizione),
                a.getResources().getString(R.string.monumenti_villa_adriana_descrizionebig),
                (R.drawable.monumenti_villa_adriana_fotosmall),
                (R.drawable.monumenti_villa_adriana_fotobig),
                a.getResources().getString(R.string.monumenti_villa_adriana_url),
                a.getResources().getString(R.string.monumenti_villa_adriana_tred),
                a.getResources().getString(R.string.monumenti_villa_adriana_maps),
                a.getResources().getString(R.string.monumenti_villa_adriana_video)
        );


        MonumentiComune villa_d_este = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_villa_d_este_titolo),
                a.getResources().getString(R.string.monumenti_villa_d_este_descrizione),
                a.getResources().getString(R.string.monumenti_villa_d_este_descrizionebig),
                (R.drawable.monumenti_villa_d_este_fotosmall),
                (R.drawable.monumenti_villa_d_este_fotobig),
                a.getResources().getString(R.string.monumenti_villa_d_este_url),
                a.getResources().getString(R.string.monumenti_villa_d_este_tred),
                a.getResources().getString(R.string.monumenti_villa_d_este_maps),
                a.getResources().getString(R.string.monumenti_villa_d_este_video)
        );

        MonumentiComune villa_gregoriana = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_villa_gregoriana_titolo),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_descrizione),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_descrizione_big),
                (R.drawable.monumenti_villa_gregoriana_fotosmall),
                (R.drawable.monumenti_villa_gregoriana_fotobig),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_url),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_tred),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_maps),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_video)
        );

        monumenti.add(acquedotti);
        monumenti.add(anfiteatro);
        monumenti.add(arcata_dell_acquedotto);
        monumenti.add(mensa_ponderaria);
        monumenti.add(piazza_campitelli);
        monumenti.add(piazza_garibaldi);
        monumenti.add(ponte_gregoriano);
        monumenti.add(rocca_pia);
        monumenti.add(santuario_ercole);
        monumenti.add(tempio_della_sibilla);
        monumenti.add(tempio_di_vesta);
        monumenti.add(tomba_dei_plauzi);
        monumenti.add(villa_adriana);
        monumenti.add(villa_d_este);
        monumenti.add(villa_gregoriana);
        return monumenti;
    }
}
