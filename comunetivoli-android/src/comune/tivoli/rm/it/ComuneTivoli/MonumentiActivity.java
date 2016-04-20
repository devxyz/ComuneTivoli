package comune.tivoli.rm.it.ComuneTivoli;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import comune.tivoli.rm.it.ComuneTivoli.listview.MonumentiComuneListAdapter;
import comune.tivoli.rm.it.ComuneTivoli.model.ContattiComune;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;

import java.util.ArrayList;

/**
 * Created by millozzi.stefano on 15/03/2016.
 */
public class MonumentiActivity extends Activity {
    ListView monumenti_list;
    private ArrayList<MonumentiComune> monumenti;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monumenti_activity);
        monumenti_list = (ListView) findViewById(R.id.monumenti_listview);
        monumenti = new ArrayList<>();

        MonumentiComune acquedotti = new MonumentiComune(
                getResources().getString(R.string.monumenti_acquedotti_titolo),
                getResources().getString(R.string.monumenti_acquedotti_descrizione),
                getResources().getDrawable(R.drawable.monumenti_acquedotti_fotosmall),
                getResources().getString(R.string.monumenti_acquedotti_url)
        );

        MonumentiComune anfiteatro = new MonumentiComune(
                getResources().getString(R.string.monumenti_anfiteatro_titolo),
                getResources().getString(R.string.monumenti_anfiteatro_descrizione),
                getResources().getDrawable(R.drawable.monumenti_anfiteatro_fotosmall),
                getResources().getString(R.string.monumenti_anfiteatro_url)
        );

        MonumentiComune arcata_dell_acquedotto = new MonumentiComune(
                getResources().getString(R.string.monumenti_arcata_dell_acquedotto_titolo),
                getResources().getString(R.string.monumenti_arcata_dell_acquedotto_descrizione),
                getResources().getDrawable(R.drawable.monumenti_arcata_dell_acquedotto_fotosmall),
                getResources().getString(R.string.monumenti_arcata_dell_acquedotto_url)
        );

        MonumentiComune mensa_ponderaria = new MonumentiComune(
                getResources().getString(R.string.monumenti_mensa_ponderaria_titolo),
                getResources().getString(R.string.monumenti_mensa_ponderaria_descrizione),
                getResources().getDrawable(R.drawable.monumenti_mensa_ponderaria_fotosmall),
                getResources().getString(R.string.monumenti_mensa_ponderaria_url)
        );

        MonumentiComune piazza_campitelli = new MonumentiComune(
                getResources().getString(R.string.monumenti_piazza_campitelli_titolo),
                getResources().getString(R.string.monumenti_piazza_campitelli_descrizione),
                getResources().getDrawable(R.drawable.monumenti_piazza_campitelli_fotosmall),
                getResources().getString(R.string.monumenti_piazza_campitelli_url)
        );

        MonumentiComune piazza_garibaldi = new MonumentiComune(
                getResources().getString(R.string.monumenti_piazza_garibaldi_titolo),
                getResources().getString(R.string.monumenti_piazza_garibaldi_descrizione),
                getResources().getDrawable(R.drawable.monumenti_piazza_garibaldi_fotosmall),
                getResources().getString(R.string.monumenti_piazza_garibaldi_url)
        );

        MonumentiComune ponte_gregoriano = new MonumentiComune(
                getResources().getString(R.string.monumenti_ponte_gregoriano_titolo),
                getResources().getString(R.string.monumenti_ponte_gregoriano_descrizione),
                getResources().getDrawable(R.drawable.monumenti_ponte_gregoriano_fotosmall),
                getResources().getString(R.string.monumenti_ponte_gregoriano_url)
        );

        MonumentiComune rocca_pia = new MonumentiComune(
                getResources().getString(R.string.monumenti_rocca_pia_titolo),
                getResources().getString(R.string.monumenti_rocca_pia_descrizione),
                getResources().getDrawable(R.drawable.monumenti_rocca_pia_fotosmall),
                getResources().getString(R.string.monumenti_rocca_pia_url)
        );

        MonumentiComune santuario_ercole = new MonumentiComune(
                getResources().getString(R.string.monumenti_santuario_ercole_titolo),
                getResources().getString(R.string.monumenti_santuario_ercole_descrizione),
                getResources().getDrawable(R.drawable.monumenti_santuario_ercole_fotosmall),
                getResources().getString(R.string.monumenti_santuario_ercole_url)
        );

        MonumentiComune tempio_della_sibilla = new MonumentiComune(
                getResources().getString(R.string.monumenti_tempio_della_sibilla_titolo),
                getResources().getString(R.string.monumenti_tempio_della_sibilla_descrizione),
                getResources().getDrawable(R.drawable.monumenti_tempio_della_sibilla_fotosmall),
                getResources().getString(R.string.monumenti_tempio_della_sibilla_url)
        );

        MonumentiComune tempio_di_vesta = new MonumentiComune(
                getResources().getString(R.string.monumenti_tempio_di_vesta_titolo),
                getResources().getString(R.string.monumenti_tempio_di_vesta_descrizione),
                getResources().getDrawable(R.drawable.monumenti_tempio_di_vesta_fotosmall),
                getResources().getString(R.string.monumenti_tempio_di_vesta_url)
        );

        MonumentiComune tomba_dei_plauzi = new MonumentiComune(
                getResources().getString(R.string.monumenti_tomba_dei_plauzi_titolo),
                getResources().getString(R.string.monumenti_tomba_dei_plauzi_descrizione),
                getResources().getDrawable(R.drawable.monumenti_tomba_dei_plauzi_fotosmall),
                getResources().getString(R.string.monumenti_tomba_dei_plauzi_url)
        );

        MonumentiComune villa_adriana = new MonumentiComune(
                getResources().getString(R.string.monumenti_villa_adriana_titolo),
                getResources().getString(R.string.monumenti_villa_adriana_descrizione),
                getResources().getDrawable(R.drawable.monumenti_villa_adriana_fotosmall),
                getResources().getString(R.string.monumenti_villa_adriana_url)
        );


        MonumentiComune villa_d_este = new MonumentiComune(
                getResources().getString(R.string.monumenti_villa_d_este_titolo),
                getResources().getString(R.string.monumenti_villa_d_este_descrizione),
                getResources().getDrawable(R.drawable.monumenti_villa_d_este_fotosmall),
                getResources().getString(R.string.monumenti_villa_d_este_url)
        );

        MonumentiComune villa_gregoriana = new MonumentiComune(
                getResources().getString(R.string.monumenti_villa_gregoriana_titolo),
                getResources().getString(R.string.monumenti_villa_gregoriana_descrizione),
                getResources().getDrawable(R.drawable.monumenti_villa_gregoriana_fotosmall),
                getResources().getString(R.string.monumenti_villa_gregoriana_url)
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

        MonumentiComuneListAdapter a=new MonumentiComuneListAdapter(this,monumenti);
                monumenti_list.setAdapter(a);


    }
}
