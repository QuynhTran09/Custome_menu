package loc.com.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import loc.com.myapplication.Model.ItemMenu;
import loc.com.myapplication.Until.Menu.CircleTransform;
import loc.com.myapplication.Until.Menu.CustomeMenu;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    /* gọi menu*/
    CustomeMenu customMenu;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // tạo một biens cử sô màng hình và lấy nó
        Window window = getWindow();

        window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        // lay v ri của custome menu
        customMenu = new CustomeMenu(this);
        // custome menu set gía trị layout
        customMenu.setContentView(R.layout.activity_main);
        // noi đay set menu cho giá trị
        customMenu.setRightShadow(R.drawable.shadow_right);

//        Button btn =(Button)customMenu.findViewById(R.id .button2);
//        frament1 right =new frament1();
        customMenu.setRightMenu(R.layout.menu2);

        ;

        FrameLayout btn = (FrameLayout) (customMenu.getChildAt(1));
        LinearLayout ln = (LinearLayout) btn.getChildAt(0);
        View v = (View) ln.getParent();
        ImageView img = (ImageView) v.findViewById(R.id.imageView);
        Picasso.with(this).load(R.drawable.icon)
                .transform(new CircleTransform()).into(img);
        setContentView(customMenu);
        lv = (ListView) v.findViewById(R.id.listView);
        AdapterMenu adapter = new AdapterMenu(this, ListView());
        lv.setAdapter(adapter);
        SetNum();
        setSupportActionBar((Toolbar) findViewById(R.id.idapbar));
    }

    /* neus sử dung  frament bạn có thể sự dung ở pt này tôi thì không cân Lee*/
    public void SetNum() {
        /*----*/
//        FragmentManager fragmentManager;
//        FragmentTransaction fragmentTransaction;
//        fragmentManager = getSupportFragmentManager();
//        fragmentTransaction = fragmentManager.beginTransaction();
//        frament1 fragmentDesign = new frament1();
//        fragmentTransaction.replace(R.id.container, fragmentDesign);
//        fragmentTransaction.commit();
    }

    /*---  demo ---*/
    public ArrayList<ItemMenu> ListView() {
        ArrayList<ItemMenu> list = new ArrayList<>();
        ItemMenu item = new ItemMenu(R.drawable.ic_apple_grey600_24dp, "Menu1");
        list.add(item);
        item = new ItemMenu(R.drawable.ic_apple_grey600_24dp, "Menu2");
        list.add(item);
        item = new ItemMenu(R.drawable.ic_apple_grey600_24dp, "Menu3");
        list.add(item);
        item = new ItemMenu(R.drawable.ic_apple_grey600_24dp, "Menu4");
        list.add(item);
        item = new ItemMenu(R.drawable.ic_apple_grey600_24dp, "Menu5");
        list.add(item);
        return list;
    }

    private void rightMenu() {
        if (customMenu.getState() == CustomeMenu.State.CLOSE_MENU) {
            customMenu.openRightMenuIfPossible();
        } else if (customMenu.getState() == CustomeMenu.State.RIGHT_MENU_OPENS) {
            customMenu.closeMenu();
        } else {
            Log.e(TAG, "CustomMenu State:" + customMenu.getState());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            rightMenu();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
