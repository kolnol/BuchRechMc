package com.fortum.nokid.buchrechmc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;


public class PdfActivity extends Activity {
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_layout);
        pdfView=(PDFView) findViewById(R.id.pdfview);

        OnPageChangeListener pageChangeListener = new OnPageChangeListener() {
            @Override
            public void onPageChanged(int page, int pageCount) {
                if(pdfView.getCurrentPage()==3){
                    Snackbar.make(pdfView, "Go to Mc", Snackbar.LENGTH_LONG)
                            .setAction("Action", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(MainActivity.contextMain,FullQuestionActivity.class);
                                    intent.putExtra("position", 1);
                                    MainActivity.contextMain.startActivity(intent);
                                }
                            }).show();
                }
            }
        };


        pdfView.fromAsset("testpdf.pdf").
                defaultPage(1).
                enableSwipe(true).
                onPageChange(pageChangeListener).
                load();

        pdfView.onLayerUpdate();
    }
}
