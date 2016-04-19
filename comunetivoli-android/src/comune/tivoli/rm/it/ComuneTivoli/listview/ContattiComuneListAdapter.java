package comune.tivoli.rm.it.ComuneTivoli.listview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.R;
import comune.tivoli.rm.it.ComuneTivoli.model.ContattiComune;
import comune.tivoli.rm.it.ComuneTivoli.util.ScreenUtil;

import java.util.List;

/**
 * Created by stefano on 04/03/15.
 */
public class ContattiComuneListAdapter extends BaseAdapter {

    private List<ContattiComune> contatti;

    private Activity activity;
    private LayoutInflater layoutInflater;

    public ContattiComuneListAdapter(Activity activity, List<ContattiComune> feed) {
        this.contatti = feed;
        this.activity = activity;
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Point size = ScreenUtil.getSize(activity);
    }


    @Override
    public int getCount() {

        // Set the total list item count
        return contatti.size();
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
            listItem = layoutInflater.inflate(R.layout.listview_contatti, null);
        }

        TextView contatti_title= (TextView) listItem.findViewById(R.id.contatti_title);
        TextView contatti_descrizione= (TextView) listItem.findViewById(R.id.contatti_descrizione);
        ImageView contatti_image= (ImageView) listItem.findViewById(R.id.contatti_image);

        final ContattiComune cc = contatti.get(position);
        contatti_descrizione.setText(cc.descrizione);
        contatti_title.setText(cc.titolo);
        //contatti_image.setImageResource(R.id.cc.descrizione);


        return listItem;
    }


}
