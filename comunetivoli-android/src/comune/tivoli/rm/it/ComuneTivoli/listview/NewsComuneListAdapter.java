package comune.tivoli.rm.it.ComuneTivoli.listview;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.R;
import comune.tivoli.rm.it.ComuneTivoli.model.ContattiComune;
import comune.tivoli.rm.it.ComuneTivoli.model.NewsComune;

import java.util.List;

/**
 * Created by millozzi.stefano on 26/04/2016.
 */
public class NewsComuneListAdapter extends BaseAdapter {

    private List<NewsComune> news;
    private Activity activity;
    private LayoutInflater layoutInflater;
    public NewsComuneListAdapter(Activity activity, List<NewsComune> feed ){
        this.news = feed;
        this.activity =activity;
        layoutInflater =(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {

        // Set the total list item count
        return news.size();


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
            listItem = layoutInflater.inflate(R.layout.listview_news, null);
        }

        TextView news_title= (TextView) listItem.findViewById(R.id.txt_titolo);
        TextView news_descrizione= (TextView) listItem.findViewById(R.id.txt_descrizione);
        TextView news_data= (TextView) listItem.findViewById(R.id.txt_data);


        final NewsComune nc = news.get(position);
        news_descrizione.setText(nc.descrizione);
        news_title.setText(nc.titolo);
        news_data.setText(nc.data+"");

        //contatti_image.setImageResource(R.id.cc.descrizione);


        return listItem;
    }





}
