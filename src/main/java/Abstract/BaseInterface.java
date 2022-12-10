package Abstract;

import Abstract.BaseHero;

import java.util.ArrayList;

public interface BaseInterface {
    void step(ArrayList<BaseHero> team);

    String getInfo();

}
