package com.example.cuciin_android.activity.modul.invoice;

import com.example.cuciin_android.base.BasePresenter;
import com.example.cuciin_android.base.BaseView;

import java.util.ArrayList;

public interface InvoiceContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask();
    }

    interface Presenter extends BasePresenter {
        //ArrayList<Transaction> getDataset();
    }
}
