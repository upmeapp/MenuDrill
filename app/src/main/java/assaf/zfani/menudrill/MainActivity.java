package assaf.zfani.menudrill;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    EditText editText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        editText =(EditText)findViewById(R.id.editText);
        registerForContextMenu(imageView);
        registerForContextMenu(editText);

    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v==imageView)
        {
            getMenuInflater().inflate(R.menu.image_menu,menu);

        }
        if (v==editText)
        {
            getMenuInflater().inflate(R.menu.edit_text_menu,menu);
        }




        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.prepend)
            return prepend();
        if (id ==R.id.append)
            return append();
        if (id ==R.id.anim1)
            return anim1();
        if (id==R.id.anim2)
            return anim2();




        return super.onContextItemSelected(item);
    }

    private boolean append() {
        Resources r = getResources();
        editText.setText(editText.getText().toString() +r.getString(R.string.that));
        return true;
    }
    private boolean prepend() {
        Resources n =getResources();
        editText.setText(n.getString(R.string.thetruth)+editText.getText().toString());
        return true;
    }
    private boolean anim1() {
        Animation an = AnimationUtils.loadAnimation(this,R.anim.slide);
        imageView.startAnimation(an);
    return true;
    }
    private boolean anim2() {
        Animation ani = AnimationUtils.loadAnimation(this,R.anim.slide);
        ani.setRepeatCount(2);
        imageView.startAnimation(ani);
        return true;
    }
}
