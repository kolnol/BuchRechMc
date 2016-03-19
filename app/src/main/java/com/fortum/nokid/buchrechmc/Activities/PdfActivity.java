package com.fortum.nokid.buchrechmc.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.fortum.nokid.buchrechmc.Entities.Page;
import com.fortum.nokid.buchrechmc.Entities.VorlesungPDF;
import com.fortum.nokid.buchrechmc.R;
import com.fortum.nokid.buchrechmc.RealmClasses.RealmInteger;
import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import io.realm.Realm;
import io.realm.RealmList;


public class PdfActivity extends Activity {
    private PDFView pdfView;
    private String pdfName;
    private int position;
    private int pageNum;
    private OnPageChangeListener pageChangeListener;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_layout);

        realm = MainActivity.realm;

        pdfView=(PDFView) findViewById(R.id.pdfview);

        pdfName = getIntent().getStringExtra("pdfName");

        final VorlesungPDF vl = realm.where(VorlesungPDF.class).equalTo("name",pdfName).findFirst();

        if(vl!=null){
            pageChangeListener = new OnPageChangeListener() {
                @Override
                public void onPageChanged(int page, int pageCount) {
                    pageNum = page;
                    RealmList<RealmInteger> arr = vl.getQuestionsPageNumbers();
                    for(int i=0;i<arr.size();i++){
                        if(pdfView.getCurrentPage()==arr.get(i).getInteger().intValue()){
                            final int finalI = i;
                            Snackbar.make(pdfView, "Go to Mc", Snackbar.LENGTH_LONG)
                                    .setAction("Go", new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            goToQuestionsList(vl.getPages().get(finalI));
                                        }
                                    }).show();
                        }
                    }

                }
            };


            pdfView.fromAsset(pdfName).
                    defaultPage(pageNum).
                    enableSwipe(true).
                    onPageChange(pageChangeListener).
                    load();

        }else{
            pdfView.fromAsset(pdfName).
                    enableSwipe(true).
                    load();
        }


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

    private void goToQuestionsList(Page page){
        Intent intent = new Intent(MainActivity.contextMain,FullQuestionActivity.class);
        intent.putExtra("position", 0);
        intent.putExtra("fromPosition", page.getFrom());
        intent.putExtra("toPosition", page.getTo());
        MainActivity.contextMain.startActivity(intent);
    }
}
