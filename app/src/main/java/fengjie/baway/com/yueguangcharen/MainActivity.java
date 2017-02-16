package fengjie.baway.com.yueguangcharen;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.yueguang.main_interface.fragment.Discount;
import com.yueguang.main_interface.fragment.Mine;
import com.yueguang.main_interface.fragment.Moonlight;
import com.yueguang.main_interface.fragment.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private List<RadioButton> radioButtons = new ArrayList<>();
    private RadioButton moonlight;
    private RadioButton discount;
    private RadioButton shoppingCart;
    private RadioButton mine;
    private FragmentManager supportFragmentManager;
    private Moonlight moonlight1;
    private Discount discount1;
    private ShoppingCart shoppingCart1;
    private Mine mine1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件 把按钮添加到集合中
        initViews();
        //fragment初始化  把fragment添加到集合中
        initFragments();


    }

    private void initFragments() {

        supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        moonlight1 = new Moonlight();
        discount1 = new Discount();
        shoppingCart1 = new ShoppingCart();
        mine1 = new Mine();

        fragmentTransaction.add(R.id.fragment_content, moonlight1).
                show(moonlight1).
                add(R.id.fragment_content, discount1).
                add(R.id.fragment_content, shoppingCart1).
                add(R.id.fragment_content, mine1).
                commit();

        FragmentTransaction fragmentTransaction5 =
                supportFragmentManager.beginTransaction();
        fragmentTransaction5.show(moonlight1).hide(discount1)
                .hide(mine1).hide(shoppingCart1).commit();
        moonlight.setChecked(true);
        discount.setChecked(false);
        mine.setChecked(false);
        shoppingCart.setChecked(false);
        moonlight.setTextColor(Color.BLUE);
        mine.setTextColor(Color.GRAY);
        discount.setTextColor(Color.GRAY);
        shoppingCart.setTextColor(Color.GRAY);


    }


    private void initViews() {
        moonlight = (RadioButton) findViewById(R.id.moonlight_bt);
        discount = (RadioButton) findViewById(R.id.discount_bt);
        shoppingCart = (RadioButton) findViewById(R.id.shopping_cart_bt);
        mine = (RadioButton) findViewById(R.id.mine_bt);


        moonlight.setOnClickListener(this);
        discount.setOnClickListener(this);
        shoppingCart.setOnClickListener(this);
        mine.setOnClickListener(this);

        radioButtons.add(moonlight);
        radioButtons.add(discount);
        radioButtons.add(shoppingCart);
        radioButtons.add(mine);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.moonlight_bt:
                FragmentTransaction fragmentTransaction1 =
                        supportFragmentManager.beginTransaction();
                fragmentTransaction1.show(moonlight1).hide(discount1)
                        .hide(mine1).hide(shoppingCart1).commit();
                moonlight.setChecked(true);
                discount.setChecked(false);
                mine.setChecked(false);
                shoppingCart.setChecked(false);
                moonlight.setTextColor(Color.BLUE);
                mine.setTextColor(Color.GRAY);
                discount.setTextColor(Color.GRAY);
                shoppingCart.setTextColor(Color.GRAY);

                break;
            case R.id.discount_bt:
                FragmentTransaction fragmentTransaction2 =
                        supportFragmentManager.beginTransaction();
                fragmentTransaction2.show(discount1).hide(moonlight1)
                        .hide(mine1).hide(shoppingCart1).commit();
                moonlight.setChecked(false);
                discount.setChecked(true);
                mine.setChecked(false);
                shoppingCart.setChecked(false);
                moonlight.setTextColor(Color.GRAY);
                mine.setTextColor(Color.GRAY);
                discount.setTextColor(Color.BLUE);
                shoppingCart.setTextColor(Color.GRAY);



                break;
            case R.id.shopping_cart_bt:
                FragmentTransaction fragmentTransaction3 =
                        supportFragmentManager.beginTransaction();
                fragmentTransaction3.show(shoppingCart1).hide(discount1)
                        .hide(mine1).hide(moonlight1).commit();
                moonlight.setChecked(false);
                discount.setChecked(false);
                mine.setChecked(false);
                shoppingCart.setChecked(true);
                moonlight.setTextColor(Color.GRAY);
                mine.setTextColor(Color.GRAY);
                discount.setTextColor(Color.GRAY);
                shoppingCart.setTextColor(Color.BLUE);

                break;
            case R.id.mine_bt:
                FragmentTransaction fragmentTransaction4 =
                        supportFragmentManager.beginTransaction();
                fragmentTransaction4.show(mine1).hide(discount1)
                        .hide(moonlight1).hide(shoppingCart1).commit();
                moonlight.setChecked(false);
                discount.setChecked(false);
                mine.setChecked(true);
                shoppingCart.setChecked(false);
                moonlight.setTextColor(Color.GRAY);
                mine.setTextColor(Color.BLUE);
                discount.setTextColor(Color.GRAY);
                shoppingCart.setTextColor(Color.GRAY);

                break;

        }


    }


}
