package sg.edu.rp.c346.id19002765.localbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button tvDisplayDbs,tvDisplayOCBC,tvDisplayUOB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplayDbs = findViewById(R.id.buttonDBS);
        registerForContextMenu(tvDisplayDbs);
        tvDisplayOCBC = findViewById(R.id.buttonOCBC);
        registerForContextMenu(tvDisplayOCBC);
        tvDisplayUOB = findViewById(R.id.buttonUOB);
        registerForContextMenu(tvDisplayUOB);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.equals(tvDisplayDbs) == true) {
            menu.add(0, 0, 0, "Website");
            menu.add(0, 1, 1, "Contact the bank");
        }
        else if(v.equals(tvDisplayOCBC) == true){
            menu.add(1, 2, 0, "Website");
            menu.add(1, 3, 1, "Contact the bank");
        }
        else if(v.equals(tvDisplayUOB) == true){
            menu.add(2, 4, 0, "Website");
            menu.add(2, 5, 1, "Contact the bank");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == 1){
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800-111-1111"));
            startActivity(intentCall);
            return true;
        }
        else if (item.getItemId() == 2) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ocbc.com"));
            startActivity(intent);
            return true;
        }
        else if(item.getItemId() == 3){
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1800-363-3333"));
            startActivity(intentCall);
            return true;
        }
        else if(item.getItemId()==4) {
            Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("htt;://www.uobgroup.com.sg"));
            startActivity(intent);
            return true;
        }
        else if(item.getItemId()==5) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"1800-222-2121"));
            startActivity(intentCall);
            return true;
        }
        return super.onContextItemSelected(item);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(item.getItemId() == R.id.mnuChinese){
            tvDisplayDbs.setText("星展银行");
            tvDisplayOCBC.setText("华侨银行");
            tvDisplayUOB.setText("大华银行");
            return true;
        }
        else if(item.getItemId() == R.id.mnuEnglish){
            tvDisplayDbs.setText("DBS");
            tvDisplayOCBC.setText("OCBC");
            tvDisplayUOB.setText("UOB");
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

}
