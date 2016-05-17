package comune.tivoli.rm.it.ComuneTivoli.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.R;
import comune.tivoli.rm.it.ComuneTivoli.model.DoveMangiareComune;

import java.util.List;

/**
 * Created by stefano on 04/03/15.
 */
public class DoveMangiareListAdapter extends BaseAdapter {

    private List<DoveMangiareComune> dovemangiare;

    private Activity activity;
    private LayoutInflater layoutInflater;

    public DoveMangiareListAdapter(Activity activity, List<DoveMangiareComune> feed) {
        this.dovemangiare = feed;
        this.activity = activity;
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        // Set the total list item count
        return dovemangiare.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Inflate the item layout and set the views
        View listItem = convertView;
        if (listItem == null) {
            listItem = layoutInflater.inflate(R.layout.listview_dovemangiare, null);
        }

        TextView dovemangiare_titolo = (TextView) listItem.findViewById(R.id.titolo_dovemangiare_listview);
        TextView dovemangiare_testo = (TextView) listItem.findViewById(R.id.descrizione_dovemangiare_listview);

        final DoveMangiareComune dmc = dovemangiare.get(position);
        dovemangiare_testo.setText(dmc.testo );
        dovemangiare_titolo.setText(dmc.titolo);

        return listItem;
    }


}
