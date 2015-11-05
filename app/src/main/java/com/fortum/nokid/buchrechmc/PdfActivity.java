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
    private String pdfName;
    private int position;
    private int pageNum;
    private OnPageChangeListener pageChangeListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_layout);
        pdfView=(PDFView) findViewById(R.id.pdfview);

        pdfName = getIntent().getStringExtra("pdfName");
        pageChangeListener = new OnPageChangeListener() {
            @Override
            public void onPageChanged(int page, int pageCount) {
                pageNum = page;
                if(pdfView.getCurrentPage()==3){
                    Snackbar.make(pdfView, "Go to Mc", Snackbar.LENGTH_LONG)
                            .setAction("Action", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(MainActivity.contextMain,FullQuestionActivity.class);
                                    intent.putExtra("position", 1);
                                   //intent.putExtra("fromPosition", 1);//// TODO: 26/10/15
                                    //intent.putExtra("toPosition", 1);
                                    MainActivity.contextMain.startActivity(intent);
                                }
                            }).show();
                }
            }
        };


        pdfView.fromAsset(pdfName).
                defaultPage(pageNum).
                enableSwipe(true).
                onPageChange(pageChangeListener).
                load();


    }

    @Override
    protected void onPause() {
        super.onPause();
        pdfView.fromAsset(pdfName).
                defaultPage(pageNum).
                enableSwipe(true).
                onPageChange(pageChangeListener).
                load();
    }
}
