package comune.tivoli.rm.it.ComuneTivoli.application;

import android.app.Application;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by stefano on 04/05/16.
 */
public class GlobalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this, 250000000));
        Picasso built = builder.build();
        //built.setIndicatorsEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);

        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;


    }
}