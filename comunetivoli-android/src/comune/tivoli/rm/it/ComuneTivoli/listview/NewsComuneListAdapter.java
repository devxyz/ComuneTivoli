package comune.tivoli.rm.it.ComuneTivoli.listview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import comune.tivoli.rm.it.ComuneTivoli.R;
import comune.tivoli.rm.it.ComuneTivoli.db.dao.NotizieSitoDbSqlLite;
import comune.tivoli.rm.it.ComuneTivoli.util.DateUtil;

import java.util.List;

/**
 * Created by millozzi.stefano on 26/04/2016.
 */
public class NewsComuneListAdapter extends BaseAdapter {

    private static final int MAX_DESC_SIZE = 300;
    private List<NotizieSitoDbSqlLite> news;
    private LayoutInflater layoutInflater;

    public NewsComuneListAdapter(Activity activity, List<NotizieSitoDbSqlLite> feed) {
        this.news = feed;
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

    private boolean isPunctuation(char c) {
        return ".,:;".contains("" + c);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Inflate the item layout and set the views
        View listItem = convertView;
        int pos = position;
        if (listItem == null) {
            listItem = layoutInflater.inflate(R.layout.listview_news, null);
        }

        TextView news_title = (TextView) listItem.findViewById(R.id.txt_titolo);
        TextView news_descrizione = (TextView) listItem.findViewById(R.id.txt_descrizione);
        TextView news_data = (TextView) listItem.findViewById(R.id.txt_data);


        final NotizieSitoDbSqlLite nc = news.get(position);
        final String testo = nc.getTesto();

        if (testo.length() < MAX_DESC_SIZE)
            news_descrizione.setText(testo);
        else {
            StringBuilder sb = new StringBuilder(testo.length());
            for (int i = 0; i < testo.length(); i++) {
                char c = testo.charAt(i);
                if (i > MAX_DESC_SIZE && (Character.isSpaceChar(c) || Character.isWhitespace(c) || isPunctuation(c))) {
                    sb.append("[...]");
                    break;
                }
                sb.append(c);
            }
            news_descrizione.setText(sb.toString());
        }
        news_title.setText(nc.getTitolo());
        news_data.setText(DateUtil.toDDMMYYY(nc.getData()));
        if (nc.getFlagContenutoLetto() == false) {
            news_title.setTypeface(null, Typeface.BOLD);
        } else {
            news_title.setTypeface(null, Typeface.NORMAL);
        }
        return listItem;
    }


}
