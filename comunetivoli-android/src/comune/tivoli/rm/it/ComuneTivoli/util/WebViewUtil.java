package comune.tivoli.rm.it.ComuneTivoli.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by stefano on 12/05/16.
 */
public class WebViewUtil {
    /**
     * associa il caricamento di una pagina con una progress bar
     *
     * @param www
     * @param bar
     */
    public static void webViewProgressBarLoaderLoadUrlInternally(WebView www, final ProgressBar bar) {
        www.setWebChromeClient(
                new WebChromeClient() {
                    public void onProgressChanged(WebView view, int progress) {
                        bar.setIndeterminate(false);
                        bar.setProgress(progress);
                    }
                }
        );

        www.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                bar.setVisibility(View.VISIBLE);
                bar.setIndeterminate(true);
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                bar.setVisibility(View.GONE);
            }
        });
    }

    /**
     * associa il caricamento di una pagina con una progress bar
     *
     * @param www
     * @param bar
     */
    public static void webViewProgressBarLoaderLoadUrlExternally(final Context a, WebView www, final ProgressBar bar) {
        www.setWebChromeClient(
                new WebChromeClient() {
                    public void onProgressChanged(WebView view, int progress) {
                        bar.setIndeterminate(false);
                        bar.setProgress(progress);
                    }
                }
        );

        www.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                a.startActivity(i);

                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                bar.setVisibility(View.VISIBLE);
                bar.setIndeterminate(true);
            }


            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                bar.setVisibility(View.GONE);
            }
        });
    }
}
