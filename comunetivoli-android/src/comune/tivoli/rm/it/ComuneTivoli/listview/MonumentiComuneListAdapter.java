package comune.tivoli.rm.it.ComuneTivoli.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.R;
import comune.tivoli.rm.it.ComuneTivoli.model.MonumentiComune;

import java.util.List;

/**
 * Created by stefano on 04/03/15.
 */
public class MonumentiComuneListAdapter extends BaseAdapter {

    private List<MonumentiComune> monumenti;

    private Activity activity;
    private LayoutInflater layoutInflater;

    public MonumentiComuneListAdapter(Activity activity, List<MonumentiComune> feed) {
        this.monumenti = feed;
        this.activity = activity;
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        // Set the total list item count
        return monumenti.size();
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
        int pos = position;
        if (listItem == null) {
            listItem = layoutInflater.inflate(R.layout.listview_monumenti, null);
        }

        TextView monumenti_titolo= (TextView) listItem.findViewById(R.id.monumenti_titolo);
        TextView monumenti_descrizione= (TextView) listItem.findViewById(R.id.monumenti_descrizione);
        ImageView monumenti_image= (ImageView) listItem.findViewById(R.id.monumenti_image);

        final MonumentiComune mc = monumenti.get(position);
        monumenti_descrizione.setText(mc.descrizione);
        monumenti_titolo.setText(mc.titolo);

        monumenti_image.setImageDrawable(mc.foto_small);


        return listItem;
    }


}
