package jesuitas.dam.scrollingtext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView sv = findViewById(R.id.article);
        registerForContextMenu(sv);

        View tv2 = findViewById(R.id.article_subheading);
        tv2.setOnLongClickListener(new View.OnLongClickListener() {
            private ActionMode mActionMode;
            @Override
            public boolean onLongClick(View v) {
                if(mActionMode != null) return false;
                mActionMode = MainActivity.this.startActionMode(mActionModeCallback);
                v.setSelected(true);
                return true;
            }
        });
    }

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback(){

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_context2, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.context_Favorite:
                    favoriteNote();
                    return true;
                case R.id.context_Info:
                    infoNote();
                    return true;
                case R.id.context_Shop:
                    shopNote();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    };



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.context_edit:
                editNote();
                return true;
            case R.id.context_share:
                shareNote();
                return true;
            case R.id.context_delete:
                deleteNote();
                return true;
            default: 
            return super.onContextItemSelected(item);
        }
    }

    public void displayToast(String text){
        Toast.makeText(getApplicationContext(), text,
                Toast.LENGTH_SHORT).show();
    }

    private void editNote() {
        displayToast(getString(R.string.edit_choice_clicked));
    }

    private void shareNote(){
        displayToast(getString(R.string.share_choice_clicked));
    }

    private void deleteNote(){
        displayToast(getString(R.string.delete_choice_clicked));
    }

    private void favoriteNote(){
        displayToast(getString(R.string.favorite_choice_chicked));
    }
    private void infoNote(){
        displayToast(getString(R.string.info_choice_clicked));
    }

    private void shopNote(){
        displayToast(getString(R.string.shop_choice_clicked));
    }
}