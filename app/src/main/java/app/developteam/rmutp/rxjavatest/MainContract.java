package app.developteam.rmutp.rxjavatest;

import java.util.List;

/**
 * Created by barbie on 8/8/2017.
 */

public interface MainContract {

    interface  Presenter{
        void genarateData();
    }

    interface View{
        void showData(List<String> data);
    }
}
