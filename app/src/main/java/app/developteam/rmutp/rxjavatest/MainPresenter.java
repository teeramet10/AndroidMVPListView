package app.developteam.rmutp.rxjavatest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by barbie on 8/8/2017.
 */

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    Context context;

    public MainPresenter(Context context) {
        this.context = context;
    }

    @Override
    public void genarateData() {
        final List<String> list=new ArrayList<>();
        Observable.just("Yumi","Nami","Barbie").subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.i("OnSubscribe",d.toString());
            }

            @Override
            public void onNext(@NonNull String s) {
                list.add(s);
                Log.i("OnNext",s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.i("OnError",e.getMessage());
            }

            @Override
            public void onComplete() {
                view.showData(list);
                Log.i("OnComplete","Complete");
            }
        });



    }

    public void bind(MainContract.View view){
        this.view=view;

    }

    public void unbind(){
        this.view=null;
    }

}
