package app.developteam.rmutp.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements MainContract.View{

    MainPresenter presenter;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.ListView);
        presenter=new MainPresenter(MainActivity.this);
        presenter.bind(this);
        presenter.genarateData();
    }

    @Override
    public void showData(List<String> data) {
        arrayAdapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unbind();
    }
}
