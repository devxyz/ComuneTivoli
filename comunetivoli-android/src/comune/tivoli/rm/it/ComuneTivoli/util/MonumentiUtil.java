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
                a.getResources().getDrawable(R.drawable.monumenti_acquedotti_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_acquedotti_fotobig),
                a.getResources().getString(R.string.monumenti_acquedotti_url),
                a.getResources().getString(R.string.monumenti_acquedotti_).
        );

        MonumentiComune anfiteatro = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_anfiteatro_titolo),
                a.getResources().getString(R.string.monumenti_anfiteatro_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_anfiteatro_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_anfiteatro_fotobig),
                a.getResources().getString(R.string.monumenti_anfiteatro_url)
        );

        MonumentiComune arcata_dell_acquedotto = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_titolo),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_arcata_dell_acquedotto_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_arcata_dell_acquedotto_fotobig),
                a.getResources().getString(R.string.monumenti_arcata_dell_acquedotto_url)
        );

        MonumentiComune mensa_ponderaria = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_titolo),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_mensa_ponderaria_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_mensa_ponderaria_fotobig),
                a.getResources().getString(R.string.monumenti_mensa_ponderaria_url)
        );

        MonumentiComune piazza_campitelli = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_piazza_campitelli_titolo),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_piazza_campitelli_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_piazza_campitelli_fotobig),
                a.getResources().getString(R.string.monumenti_piazza_campitelli_url)
        );

        MonumentiComune piazza_garibaldi = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_titolo),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_piazza_garibaldi_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_piazza_garibaldi_fotobig),
                a.getResources().getString(R.string.monumenti_piazza_garibaldi_url)
        );

        MonumentiComune ponte_gregoriano = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_titolo),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_ponte_gregoriano_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_ponte_gregoriano_fotobig),
                a.getResources().getString(R.string.monumenti_ponte_gregoriano_url)
        );

        MonumentiComune rocca_pia = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_rocca_pia_titolo),
                a.getResources().getString(R.string.monumenti_rocca_pia_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_rocca_pia_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_rocca_pia_fotobig),
                a.getResources().getString(R.string.monumenti_rocca_pia_url)
        );

        MonumentiComune santuario_ercole = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_santuario_ercole_titolo),
                a.getResources().getString(R.string.monumenti_santuario_ercole_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_santuario_ercole_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_santuario_ercole_fotobig),
                a.getResources().getString(R.string.monumenti_santuario_ercole_url)
        );

        MonumentiComune tempio_della_sibilla = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_titolo),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_tempio_della_sibilla_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_tempio_della_sibilla_fotobig),
                a.getResources().getString(R.string.monumenti_tempio_della_sibilla_url)
        );

        MonumentiComune tempio_di_vesta = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_titolo),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_tempio_di_vesta_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_tempio_di_vesta_fotobig),
                a.getResources().getString(R.string.monumenti_tempio_di_vesta_url)
        );

        MonumentiComune tomba_dei_plauzi = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_titolo),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_tomba_dei_plauzi_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_tomba_dei_plauzi_fotobig),
                a.getResources().getString(R.string.monumenti_tomba_dei_plauzi_url)
        );

        MonumentiComune villa_adriana = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_villa_adriana_titolo),
                a.getResources().getString(R.string.monumenti_villa_adriana_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_villa_adriana_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_villa_adriana_fotobig),
                a.getResources().getString(R.string.monumenti_villa_adriana_url)
        );


        MonumentiComune villa_d_este = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_villa_d_este_titolo),
                a.getResources().getString(R.string.monumenti_villa_d_este_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_villa_d_este_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_villa_d_este_fotobig),
                a.getResources().getString(R.string.monumenti_villa_d_este_url)
        );

        MonumentiComune villa_gregoriana = new MonumentiComune(
                a.getResources().getString(R.string.monumenti_villa_gregoriana_titolo),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_descrizione),
                a.getResources().getDrawable(R.drawable.monumenti_villa_gregoriana_fotosmall),
                a.getResources().getDrawable(R.drawable.monumenti_villa_gregoriana_fotobig),
                a.getResources().getString(R.string.monumenti_villa_gregoriana_url)
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
